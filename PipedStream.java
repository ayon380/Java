import java.io.*;
class Producer extends Thread{
    OutputStream o;
    public Producer(OutputStream o)
    {
        this.o=o;
    }
    public void run()
    {
        try{
            for(int i=65;i<=90;i++)
            {
                o.write(i);
                Thread.sleep(1000);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
class Consumer extends Thread{
    InputStream i;
    public Consumer(InputStream i)
    {
        this.i=i;
    }
    public void run()
    {
        try{
            int x=0;
            while((x=i.read())!=-1)
            {
                System.out.println((char)x);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
public class PipedStream {
    public static void main(String args[])
    {
        try{
            PipedOutputStream po=new PipedOutputStream();
            PipedInputStream pi=new PipedInputStream(po);
            Producer p=new Producer(po);
            Consumer c=new Consumer(pi);
            p.start();
            c.start();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }   
    }
}
