public class ThreadClass extends Thread{
    public void run()
    {
        for(int i=0;i<10;i++)
        System.out.println("Hello!!!");
    }
    public static void main(String args[])
    {
        ThreadClass t=new ThreadClass();
        // Thread q=new Thread(t );
        t.start();
        for(int i=0;i<10;i++)
        System.out.println("Hi!!!");
    }
    
}
