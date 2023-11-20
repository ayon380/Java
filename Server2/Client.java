
package Server2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String saddress = "localhost";
        int port = 12345;

        try (Socket clientSocket = new Socket(saddress, port)) {
            System.out.println("Connected to server on port " + port);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            Scanner sc = new Scanner(System.in);
            String inputLine;
            while (true) {
                System.out.print("Enter message: ");
                inputLine = sc.nextLine();
                out.println(inputLine);
                if (inputLine.equals("exit")) {
                    break;
                }
                System.out.println("Received from server: " + in.readLine());
            }
            sc.close();
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
