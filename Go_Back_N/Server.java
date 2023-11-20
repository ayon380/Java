package Go_Back_N;

import java.net.*;
import java.util.*;

public class Server {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(12345);
            InetAddress clientAddress = InetAddress.getLocalHost();
            int clientPort = 54321;
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a message to send: ");
            String message = scanner.nextLine();
            scanner.close();
            char[] characters = message.toCharArray();
            int windowSize = 3;
            int base = 0;
            int nextSequenceNumber = 0;
            int expectedAck = 0;
            while (base < characters.length) {
                for (int i = nextSequenceNumber; i < Math.min(base + windowSize, characters.length); i++) {
                    char data = characters[i];
                    String packetData = String.format("%02d", i) + String.valueOf(data);
                    byte[] sendData = packetData.getBytes();
                    DatagramPacket packet = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                    serverSocket.send(packet);
                    System.out.println("Sent: " + data);
                    nextSequenceNumber++;
                }
                try {
                    serverSocket.setSoTimeout(5000);
                    byte[] receiveData = new byte[1024];
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    serverSocket.receive(receivePacket);
                    String ack = new String(receivePacket.getData(), 0, receivePacket.getLength());
                    int ackNumber = Integer.parseInt(ack);

                    if (ackNumber >= expectedAck) {
                        base = ackNumber + 1;
                        System.out.println("Received ACK: " + ackNumber);
                        expectedAck = ackNumber;
                    }
                } catch (SocketTimeoutException e) {
                    System.out.println("Timeout! Retransmitting...");
                    nextSequenceNumber = base;
                }
            }
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
