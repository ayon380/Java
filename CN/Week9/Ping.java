package CN.Week9;
import java.net.*;
import java.io.*;
public class Ping {
    public static void main(String[] args)throws IOException {
        String host="google.com";
        InetAddress gg=InetAddress.getByName(host);
        if(gg.isReachable(2000))
        {
            System.out.println("Successful");
        }
        else
        {
            System.out.println("unsuccessful");
        }
    }
}
