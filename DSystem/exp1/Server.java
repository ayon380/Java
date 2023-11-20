package DSystem.exp1;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 5000;
        ServerSocket sr = new ServerSocket(5000);
        System.out.println("SErver Listening on portt ");
        while (true) {
            Socket cs = sr.accept();
            System.out.println("Client connected");
            new ClientHandler(cs).run();
        }

    }
}

class ClientHandler implements Runnable {
    Socket sc;

    public ClientHandler(Socket Cs) {
        sc = Cs;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            PrintWriter out = new PrintWriter(sc.getOutputStream(), true);
            String inputline;
            while ((inputline = in.readLine()) != null) {
                System.out.println("REcecievied from client " + inputline);
                out.println("SErver recieved" + inputline);
            }
        } catch (IOException e) {

        }

    }
}
