import java.io.FileInputStream;

public class fileread {
    public static void main(String args[]) throws Exception
    {
        FileInputStream fin=new FileInputStream("test.txt");
        byte b[]=new byte[fin.available()];
        fin.read(b);
        String s=new String(b);
        System.out.println(s);
    }
}
