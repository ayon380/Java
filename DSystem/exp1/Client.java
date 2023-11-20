package DSystem.exp1;
import java.io.IOException;
import java.net.*;
import java.io.*;
public class Client {
    public static void main(String[] args)throws UnknownHostException,IOException {
        int port=5000;
        String host="localhost";
        Socket s=new Socket(host,port);
        PrintWriter out = new PrintWriter(s.getOutputStream());
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        String message;
        while((message=in.readLine())!=null)
        {
            out.println(message);
            String res=in.readLine();
            System.out.println(res);
        }
    }
}
