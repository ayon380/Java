    import java.io.*;
    import java.net.*;
    import java.util.*;

    public class Client {
        public static void main(String args[]) throws Exception {
            Receiver receiver = new Receiver();
            receiver.run();
        }
    }

    class Receiver{
        public void run() throws Exception {
            String exitCommand = "exit";

            ServerSocket serverSocket = new ServerSocket(9999);
            Socket clientSocket = serverSocket.accept();

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            Map<Integer, Boolean> receivedFrames = new HashMap<>();
            int expectedSeqNum = 0;

            while (true) {
                String message = reader.readLine();

                if (message == null || message.equals(exitCommand)) {
                    System.out.println("Exiting receiver...");
                    break;
                }

                int frameNumber = Integer.parseInt(message);

                if (frameNumber == expectedSeqNum) {
                    System.out.println("Frame " + frameNumber + " was received");
                    writer.println(frameNumber);
                    receivedFrames.put(frameNumber, true);

                    // Check for consecutive frames and deliver them in order
                    while (receivedFrames.containsKey(expectedSeqNum) && receivedFrames.get(expectedSeqNum)) {
                        System.out.println("Delivering Frame " + expectedSeqNum);
                        expectedSeqNum++;
                    }
                } else {
                    System.out.println("Frame " + frameNumber + " was received out of order, discarding.");
                }
            }

            serverSocket.close();
        }
    }