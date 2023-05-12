import java.util.*;

public class _25_Thread implements Runnable{
    public void run()
    {
        System.out.println("Thread is running");
    }
    public static void main(String args[]) {
        _25_Thread obj=new _25_Thread();
        Thread t=new Thread(obj,"Thread1");
        t.start();
        String str=t.getName();
        System.out.println(str);
    }
}
