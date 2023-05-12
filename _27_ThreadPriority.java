public class _27_ThreadPriority implements Runnable {
    public void run()
    {
        System.out.println("Thread"+Thread.currentThread().getName()+" is running");
        System.out.println("Thread"+Thread.currentThread().getName()+" Priority: "+Thread.currentThread().getPriority());
    }
    public static void main(String args[])
    {
        Thread t1=new Thread(new _27_ThreadPriority());
        Thread t2=new Thread(new _27_ThreadPriority());
        Thread t3=new Thread(new _27_ThreadPriority());
        System.out.println("Thread1 Priority: "+t1.getPriority());
        System.out.println("Thread2 Priority: "+t2.getPriority());
        System.out.println("Thread3 Priority: "+t3.getPriority());
        // Setting Priorities
        t1.setPriority(1);
        t2.setPriority(5);
        t3.setPriority(10);
        System.out.println("Thread1 Priority: "+t1.getPriority());
        System.out.println("Thread2 Priority: "+t2.getPriority());
        System.out.println("Thread3 Priority: "+t3.getPriority());
        t3.start();
        t1.start();
        t2.start();
        
        System.out.println("Thread1 Priority: "+Thread.currentThread().getName());
        System.out.println("Thread2 Priority: "+Thread.currentThread().getName());
        System.out.println("Thread3 Priority: "+Thread.currentThread().getName());
    }
}
