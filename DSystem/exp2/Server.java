package DSystem.exp2;

import java.net.*;
import java.io.*;
import java.util.*;
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5000);
        while (true) {
            Socket cs = ss.accept();
            System.out.println("Client connected");
            DataOutputStream  ds=new DataOutputStream(cs.getOutputStream());
            Date d=new Date();
            ds.writeBytes(d.toString());
            new ClientHandler(cs).start();
        }
    }
}

class ClientHandler extends Thread{
    Socket client;

    ClientHandler(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream());
            String inputline;
            while ((inputline = in.readLine()) != null) {
                System.out.println("Recieved from client"+inputline);
            }
        } catch (

        IOException e) {

        }
    }
}
