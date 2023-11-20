package ServerEcho;

import java.io.*;
import java.net.*;


public class Client {
   public static void main(String[] args) {
       final String SERVER_IP = "127.0.0.1";
       final int SERVER_PORT = 12345;
      
       try (
           Socket socket = new Socket(SERVER_IP, SERVER_PORT);
           BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
           BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
       ) {
           System.out.println("Connected to server. Type your message:");


           String userMessage;
           while ((userMessage = userInput.readLine()) != null) {
               out.println(userMessage);
               String response = in.readLine();
               System.out.println("Server response: " + response);
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}


