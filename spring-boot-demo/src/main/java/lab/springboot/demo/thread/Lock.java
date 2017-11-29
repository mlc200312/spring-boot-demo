package lab.springboot.demo.thread;

import java.util.concurrent.locks.ReentrantLock;

class MyService {

	private ReentrantLock lock = new ReentrantLock();

	public void method() {
		try {
			lock.lock();
			for (int i = 1; i <= 3; i++) {
				Thread.sleep(1000);
				System.out.println("ThreadName=" + Thread.currentThread().getName() + "  " + i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}

class MyThread extends Thread {

	private MyService service;

	MyThread(MyService service) {
		this.service = service;
	}

	@Override
	public void run() {
		service.method();
	}
}

public class Lock {

	public static void main(String[] args) {
		MyService service = new MyService();
		MyThread myThread1 = new MyThread(service);
		MyThread myThread2 = new MyThread(service);

		myThread1.start();
		myThread2.start();
	}
}