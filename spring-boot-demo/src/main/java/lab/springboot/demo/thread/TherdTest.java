package lab.springboot.demo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TherdTest {

	public static List<Integer> getData() {
		List<Integer> data = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			data.add(i);
		}
		return data;
	}

	public static void test1() {
		List<Integer> data = getData();

		long start = System.currentTimeMillis();
		for (int i = 0; i < data.size(); i++) {
			System.out.println("工作开始了。。。。。。。。。。" + Thread.currentThread().getId());
			try {
				Thread.sleep((long) (Math.random() * 10));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("工作结束了。。。。。。。。。。" + Thread.currentThread().getId());
		}
		long end = System.currentTimeMillis();
		System.out.println("花了多长时间---------------------------------------------:" + (end - start));
	}

	public static void test2() {
		List<Integer> data = getData();

		long start = System.currentTimeMillis();
		ExecutorService service = Executors.newFixedThreadPool(10);
		for (int i = 0; i < data.size(); i++) {
			service.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println("工作开始了。。。。。。。。。。" + Thread.currentThread().getId());
					try {
						Thread.sleep((long) (Math.random() * 10));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("工作结束了。。。。。。。。。。" + Thread.currentThread().getId());
				}
			});
		}
		long end = System.currentTimeMillis();
		System.out.println("花了多长时间---------------------------------------------:" + (end - start));
		service.shutdown();
	}

	public static void main(String[] args) {
//		 test1();
		test2();
	}
}
