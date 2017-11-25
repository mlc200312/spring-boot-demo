package lab.spring.boot.demo.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		People people1 = new People(Move.OUT, 20d);
		People people2 = new People(Move.OUT, 30d);
		People people3 = new People(Move.OUT, 40d);
		People people4 = new People(Move.OUT, 50d);
		//
		// Thread thread1 = new Thread(people1);
		// Thread thread2 = new Thread(people2);
		// Thread thread3 = new Thread(people3);
		// Thread thread4 = new Thread(people4);
		//
		// thread1.setName("用户1");
		// thread2.setName("用户2");
		// thread3.setName("用户3");
		// thread4.setName("用户4");
		//
		// thread1.start();
		// thread2.start();
		// thread3.start();
		// thread4.start();

//		ExecutorService e = Executors.newFixedThreadPool(4);
//		e.execute(people1);
//		e.execute(people2);
//		e.execute(people3);
//		e.execute(people4);

		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3, 10, 1,
				TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(3),
				new ThreadPoolExecutor.DiscardOldestPolicy());
		
		try {
			threadPool.execute(people1);
			Thread.sleep(2);
			threadPool.execute(people2);
			Thread.sleep(2);
			threadPool.execute(people3);
			Thread.sleep(2);
			threadPool.execute(people4);
			Thread.sleep(2);
			
			System.out.println(threadPool.getCorePoolSize());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
