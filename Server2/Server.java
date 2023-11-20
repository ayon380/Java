package Server2;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {
    private static final int PORT = 12345;
    private static final List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server listening on port " + PORT);

            // Create a thread to handle server-side input
            Thread inputThread = new Thread(() -> handleServerInput());
            inputThread.start();

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Create a new client handler thread
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clients.add(clientHandler);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void broadcastMessage(String message, ClientHandler sender) {
        for (ClientHandler client : clients) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }

    // Method to handle server-side input
    private static void handleServerInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Server: ");
            String message = scanner.nextLine();
            broadcastMessage("Server: " + message, null);
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String message;
        try {
            while ((message = in.readLine()) != null) {
                System.out.println("Received from client: " + message);
                Server.broadcastMessage(message, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // clients.remove(this);
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}
