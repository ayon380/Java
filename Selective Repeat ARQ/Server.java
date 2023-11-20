import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    public static void main(String args[]) throws Exception {
        Sender sender = new Sender();
        sender.run();
    }
}

class Sender {
    public void run() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of frames to be sent: ");
        int numberOfFrames = sc.nextInt();
        int windowSize = 4;
        int base = 0;
        int nextSeqNum = 0;

        Socket socket = new Socket("localhost", 9999);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        List<Integer> frames = new ArrayList<>();
        Map<Integer, Boolean> ackReceived = new HashMap<>();

        for (int i = 0; i < numberOfFrames; i++) {
            frames.add(i);
            ackReceived.put(i, false);
        }

        while (base < numberOfFrames) {
            for (int i = base; i < Math.min(base + windowSize, numberOfFrames); i++) {
                if (!ackReceived.get(i)) {
                    System.out.println("Sending Frame " + i);
                    out.println(frames.get(i));
                }
                nextSeqNum++;
            }

            try {
                socket.setSoTimeout(5000); // Timeout for acknowledgment
                int ackNumber = Integer.parseInt(in.readLine());

                if (ackReceived.containsKey(ackNumber)) {
                    System.out.println("Acknowledgment received: " + ackNumber);
                    ackReceived.put(ackNumber, true);
                }
            } catch (SocketTimeoutException e) {
                System.out.println("Timeout, retransmitting frames...");
                nextSeqNum = base;
            }

            // Update the base to the next unacknowledged frame
            while (ackReceived.get(base)) {
                base++;
            }
        }

        socket.close();
    }
}