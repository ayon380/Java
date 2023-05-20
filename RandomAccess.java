import java.io.RandomAccessFile;

public class RandomAccess {
    public static void main(String args[]) throws Exception {
        RandomAccessFile rf = new RandomAccessFile("test3.txt", "rw");
        System.out.println((char) rf.read());
        rf.write('X');
        System.out.println(rf.readLine());
        rf.seek(6);
        System.out.println((char) rf.read());
        rf.skipBytes(3);
        System.out.println((char) rf.read());
    }
}
