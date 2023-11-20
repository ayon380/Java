package CN.Week4;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;
import java.io.*;
public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        String address="localhost";
        int Host=12345;
        try(Socket s=new Socket(address,Host))
        {
            System.out.println("Connected to port");
            PrintWriter out = new PrintWriter(s.getOutputStream(),true);
            BufferedReader in= new BufferedReader(new InputStreamReader(s.getInputStream()));
            Scanner sc=new Scanner(System.in);
            String inputline;
            while(true)
            {
                System.err.println("Enter message:");
                inputline=sc.nextLine();
                out.println(inputline);
                if(inputline.equals("exit"))
                break;
                System.err.println("REcieved"+in.readLine());
            }
            sc.close();
            s.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
