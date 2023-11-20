package ServerEcho;
import java.io.*;
import java.net.*;


public class Server {
   public static void main(String[] args) {
       final int PORT = 12345;
      
       try (ServerSocket serverSocket = new ServerSocket(PORT)) {
           System.out.println("Server is listening on port " + PORT);
          
           while (true) {
               Socket clientSocket = serverSocket.accept();
               System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
              
               // Handle client communication in a separate thread
               new ClientHandler(clientSocket).start();
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}


class ClientHandler extends Thread {
   private Socket clientSocket;
  
   public ClientHandler(Socket clientSocket) {
       this.clientSocket = clientSocket;
   }
  
   public void run() {
       try (
           BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
           PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
       ) {
           String inputLine;
          
           while ((inputLine = in.readLine()) != null) {
               System.out.println("Received from client: " + inputLine);
               out.println("Server received: " + inputLine);
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
      
       System.out.println("Client disconnected: " + clientSocket.getInetAddress().getHostAddress());
   }
}
