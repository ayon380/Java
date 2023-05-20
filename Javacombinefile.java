import java.io.*;
public class Javacombinefile {
    public static void main(String args[]) throws Exception
    {
        FileInputStream fr=new FileInputStream("test.txt");
       FileInputStream fr1= new FileInputStream("test2.txt");
       FileOutputStream fo=new FileOutputStream( "test3.txt");
        byte b[]=new byte[fr.available()];
        byte b1[]=new byte[fr1.available()];
        fr.read(b);
        fr1.read(b1);
        fo.write(b);
        fo.write(b1);
        fr.close();
        fr1.close();
        fo.close();
        
    }
}