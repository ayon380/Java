public class ThreadInterface implements Runnable{
    public void run()
    {
        for(int i=0;i<10;i++)
        System.out.println("Hello!!!");
    }
    public static void main(String args[])
    {
        ThreadInterface t=new ThreadInterface();
        Thread q=new Thread(t );
        q.start();
        for(int i=0;i<10;i++)
        System.out.println("Hi!!!");
    }
}
