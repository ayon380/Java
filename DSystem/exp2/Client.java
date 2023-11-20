package DSystem.exp2;

import java.net.*;
import java.util.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket s = new Socket("localhost", 5000);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(),true);
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = userInput.readLine()) != null) {
            out.println(line);
            System.out.println(line);
            String response =in.readLine();
            System.out.println(response);
        }
    }
}
