public class DaemonThread extends Thread {
    public void run() {
        int i = 0;
        while (true) {
            System.out.println("Thread is running " + i);
            i++;
        }
    }

    public static void main(String args[]){
        DaemonThread t1 = new DaemonThread();
        t1.setDaemon(true);
        t1.start();
        try{
            t1.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e);
            

        }
    }
}
