public class ThreadJoin extends Thread {
    public void run() {
        int i = 0;
        while (true) {
            System.out.println("Thread is running " + i);
            i++;
        }
    }

    public static void main(String args[]) {
        ThreadJoin t1 = new ThreadJoin();
        t1.setDaemon(true);
        t1.start();
        Thread mt = Thread.currentThread();
        try {
            mt.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
