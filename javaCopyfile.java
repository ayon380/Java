import java.io.*;
public class javaCopyfile {
    public static void main(String args[]) throws Exception
    {
        FileInputStream fr=new FileInputStream("test.txt");
        FileOutputStream fw=new FileOutputStream("test2.txt");
        byte b[]=new byte[fr.available()];
        fr.read(b);
        fw.write(b);
        fr.close();
        fw.close();

    }
}
