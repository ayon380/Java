package CN.Week4;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {
    private static final int port = 12345;
    private static final List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            try (ServerSocket sr = new ServerSocket(port)) {
                System.out.println("Lsitening on " + port);
                Thread it = new Thread(() -> handleServerInput());
                it.start();
                while (true) {
                    Socket cs = sr.accept();
                    System.out.println("client connected");
                    ClientHandler clientHandler = new ClientHandler(cs);
                    clients.add(clientHandler);
                    Thread t = new Thread(clientHandler);
                    t.start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void broadcast(String message, ClientHandler sender) {
        for (ClientHandler client : clients) {
            if (client != sender)
                client.sendMessage(message);
        }
    }

    private static void handleServerInput() {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print("Server :");
                String message = sc.nextLine();
                broadcast(message, null);
            }
        }
    }
}

class ClientHandler implements Runnable {
    private Socket cs;
    private PrintWriter out;
    private BufferedReader in;

    public ClientHandler(Socket s) {
        this.cs = s;
        try {
            out = new PrintWriter(cs.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String message;
        try {
            while ((message = in.readLine()) != null) {
                System.out.println("receieved from client " + message);
                Server.broadcast(message, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                cs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}