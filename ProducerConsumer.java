class data {
    int data;
    boolean flag = false;

    synchronized void set(int data) {
        while (flag != true) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        flag = false;
        this.data = data;
        notify();
    }

    synchronized int get() {
        while (flag != false) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        flag = true;
        notify();
        return data;

    }
}

class Producer extends Thread {
    data d;

    Producer(data d) {
        this.d = d;
    }

    public void run() {
        int i = 0;
        while (true) {
            d.set(i++);
            System.out.println("Producer : " + i);
        }
    }
}

class Consumer extends Thread {
    data d;

    Consumer(data d) {
        this.d = d;
    }

    public void run() {
        while (true) {
            System.out.println("Consumer : " + d.get());
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        data d = new data();
        Producer p = new Producer(d);
        Consumer c = new Consumer(d);
        p.start();
        c.start();
    }
}
