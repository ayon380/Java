import java.io.*;
public class BufferReader {
    public static void main(String args[]) throws IOException
    {
        BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(b.readLine());
        System.out.println(a);
    }
}
