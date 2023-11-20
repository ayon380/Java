import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable {
    int id=9;
}

public class Ser {
    public static void main(String args[]) throws IOException,ClassNotFoundException{
        FileOutputStream fs=new FileOutputStream("test.txt");
        ObjectOutputStream o=new ObjectOutputStream(fs);
        Student s =new Student();
        o.writeObject(s);
        FileInputStream fi=new FileInputStream("test.txt");
        ObjectInputStream oo=new ObjectInputStream(fi);
        Student ss=(Student)oo.readObject();
        System.out.println(ss.id);
    }
}
