public class ThreadYield extends Thread {
    public void run() {
        int i = 0;
        while (true) {
            System.out.println("Thread 1 is running " + i);
            i++;
        }
    }

    public static void main(String args[]) {
        ThreadYield t1 = new ThreadYield();
        t1.setDaemon(true);
        t1.start();
        Thread mt = Thread.currentThread();
        
        int i = 0;
        while (true) {
            System.out.println("Thread 2 is running " + i);
            t1.yield();
            i++;
        }
        
    }
}
