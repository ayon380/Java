package CN.Week9;

import java.io.*;

public class Tracert {
    public static void main(String[] args) throws IOException,InterruptedException {
        String host="google.com";
        ProcessBuilder pb= new ProcessBuilder("tracert",host);
        Process p= pb.start();
        BufferedReader reader= new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while ((line=reader.readLine())!=null) {
            System.out.println(line);
        }
        p.waitFor();
    }
}
