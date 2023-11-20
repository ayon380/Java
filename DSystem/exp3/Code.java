package DSystem.exp3;
import java.io.IOException;
import java.net.*;
public class Code {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket s=new Socket("google.com",80);
        s.setKeepAlive(false);
        s.setTcpNoDelay(false);
        s.setSoLinger(false, 0);
        s.setSendBufferSize(8192);
        s.setReceiveBufferSize(8192);
    }
}
