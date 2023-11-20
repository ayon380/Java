package StopAndWait;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String args[]) {
        try {
            try (DatagramSocket receiverSocket = new DatagramSocket(9876)) {
                while (true) {
                    byte[] receiveData = new byte[1024];
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    receiverSocket.receive(receivePacket);
                    String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                    System.out.println("Received: " + message);
                    if (Math.random() < 0.5) {
                        String acknowledgment = "ACK";
                        byte[] sendData = acknowledgment.getBytes();
                        InetAddress senderAddress = receivePacket.getAddress();
                        int senderPort = receivePacket.getPort();
                        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, senderAddress,
                                senderPort);

                        receiverSocket.send(sendPacket);
                        System.out.println("Sent Acknowledgment: " + acknowledgment);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
