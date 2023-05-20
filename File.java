import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class File {
    public static void main(String[] args) {
        try {
            FileOutputStream f=new FileOutputStream("test.txt");
            String s="Hello World!";
            f.write(s.getBytes());
            f.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
