package lab.springboot.demo.collections.queue;

import java.util.concurrent.TimeUnit;

public class App {

	public static void main(String[] args) {

		final LinkedQueue<Integer> queue = new LinkedQueue<>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);

		System.out.println("---------------------------");
		Thread thread0 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Integer num = queue.dequeue();
				System.out.println(Thread.currentThread().getId() + "取到了" + num);
			}
		});
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Integer num = queue.dequeue();
				System.out.println(Thread.currentThread().getId() + "取到了" + num);
			}
		});
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Integer num = queue.dequeue();
				System.out.println(Thread.currentThread().getId() + "取到了" + num);
			}
		});
		Thread thread3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Integer num = queue.dequeue();
				System.out.println(Thread.currentThread().getId() + "取到了" + num);
			}
		});
		Thread thread4 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Integer num = queue.dequeue();
				System.out.println(Thread.currentThread().getId() + "取到了" + num);
			}
		});
		Thread thread5 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Integer num = queue.dequeue();
				System.out.println(Thread.currentThread().getId() + "取到了" + num);
			}
		});
		
		
		thread0.start();
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
	}

}
