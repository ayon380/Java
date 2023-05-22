import java.io.FileInputStream;
import java.util.StringTokenizer;

public class StringTokenizer_ {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("test.txt");
        int size = fis.available();
        byte[] b = new byte[size];
        fis.read(b);
        String str = new String(b);
        StringTokenizer st = new StringTokenizer(str);
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}