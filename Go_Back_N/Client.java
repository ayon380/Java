package Go_Back_N;

// import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket(54321);

            int expectedSequenceNumber = 0;
            StringBuilder receivedMessage = new StringBuilder();
            double errorProbability = 0.3;

            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                if (Math.random() < errorProbability) {
                    continue;
                }

                clientSocket.receive(receivePacket);
                String data = new String(receivePacket.getData(), 0, receivePacket.getLength());

                int packetSequenceNumber = Integer.parseInt(data.substring(0, 2));
                String packetData = data.substring(2);

                if (packetSequenceNumber == expectedSequenceNumber) {
                    System.out.println("Received: " + packetData);
                    receivedMessage.append(packetData);
                    expectedSequenceNumber++;

                    String ack = String.format("%02d", packetSequenceNumber);
                    byte[] sendAckData = ack.getBytes();
                    DatagramPacket sendAckPacket = new DatagramPacket(sendAckData, sendAckData.length,
                            receivePacket.getAddress(), receivePacket.getPort());

                    if (Math.random() < errorProbability) {
                        continue;
                    } else {
                        clientSocket.send(sendAckPacket);
                    }
                } else {
                    System.out.println("Received out-of-order packet: " + packetData);
                }

                if (receivedMessage.length() == expectedSequenceNumber) {
                    System.out.println("Received message: " + receivedMessage.toString());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
