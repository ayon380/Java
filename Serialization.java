import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class Student implements java.io.Serializable {
    int roll;
    String name;

    public Student(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }
}

public class Serialization {
    public static void main(String args[]) throws Exception {
        FileOutputStream fis = new FileOutputStream("test.txt");
        ObjectOutputStream ois = new ObjectOutputStream(fis);
        Student s = new Student(1, "Ayush");
        ois.writeObject(s);
        ois.flush();
        ois.close();
        fis.close();
        
        FileInputStream fiss = new FileInputStream("test.txt");
        ObjectInputStream oiss = new ObjectInputStream(fiss);
        Student si = (Student)oiss.readObject();
        System.out.println(s.roll + " " + s.name);
        
    }
}
