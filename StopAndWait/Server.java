package StopAndWait;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;

public class Server {
    public static void main(String[] args) {
        try {
            DatagramSocket senderSocket = new DatagramSocket();
            InetAddress receiverAddress = InetAddress.getLocalHost();
            int receiverPort = 9876;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.print("Enter the message to send (or 'exit' to quit): ");
                String message = reader.readLine();
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                byte[] sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receiverAddress,receiverPort);
                int maxAttempts = 3;
                int currentAttempt = 0;
                boolean ackReceived = false;
                while (!ackReceived && currentAttempt < maxAttempts) {
                    senderSocket.send(sendPacket);
                    System.out.println("Sent: " + message);
                    // Set a timeout for receiving the acknowledgment
                    senderSocket.setSoTimeout(2000); // 2 seconds timeout
                    byte[] receiveData = new byte[1024];
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    try {
                        senderSocket.receive(receivePacket);
                        String acknowledgment = new String(receivePacket.getData(), 0, receivePacket.getLength());
                        System.out.println("Received Acknowledgment: " + acknowledgment);
                        ackReceived = true;
                    } catch (SocketTimeoutException e) {
                        System.err.println("Timeout. Resending the packet.");
                        currentAttempt++;
                    }
                }
                if (!ackReceived) {
                    System.err.println("Max attempts reached. Giving up on this message.");
                }
            }
            senderSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
