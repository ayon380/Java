import java.util.*;

class th extends Thread{
    public void run()
    {
        System.out.println("Thread is running");
    }
}
class Thread1 {
    public static void main(String args[]) {
        th t=new th();
        t.start();
    }
}