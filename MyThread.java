import java.io.*;

class MyThread extends Thread {
	boolean stop = false;

	public void run() {
		for (int i = 0; i < 1000000000; i++) {
			System.out.println(i);
			if (stop == true)
				return;

		}
	}
}

class Demo_Thread1 {
	public static void main(String args[]) throws IOException {
		MyThread obj = new MyThread();
		Thread t = new Thread(obj);
		t.start();
		System.out.println("Press Enter Key to Terminate the Thread");
		System.in.read();
		obj.stop = true;
	}
}
