package lab.springboot.demo.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RegisterClient {
	
	private static int count = 0;

	public static void main(String[] args) {
		for (int j = 0; j < 10; j++) {
			TaskService service = new TaskService();
			for (int i = 0; i < 100; i++) {
				count ++;
				try {
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				service.executeTask(count);
			}
			service.endService();
		}
	}

}

class TaskService {
	private ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

	public void executeTask(int i) {
		System.out.println("service：注册了一个用户！[" + i + "]");
		TaskSms sms = new TaskSms("sms" + i);
		TaskEmail email = new TaskEmail("email" + i);
		executor.execute(sms);
		executor.execute(email);
		System.out.printf("service:pool执行器中线程中实际的线程数量:%d，执行器中正在执行任务的线程数量：%d，执行器中已经完成的任务数量:%d\n", executor.getPoolSize(), executor.getActiveCount(),
				executor.getCompletedTaskCount());
	}

	public void endService() {
		System.out.printf("service-----------------shutdown--------------:pool执行器中线程中实际的线程数量:%d，执行器中正在执行任务的线程数量：%d，执行器中已经完成的任务数量:%d\n", executor.getPoolSize(),
				executor.getActiveCount(), executor.getCompletedTaskCount());
		executor.shutdown();
	}

}

class TaskSms implements Runnable {

	private String name;

	public TaskSms(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		try {
			long time = (long) (Math.random() * 10); // 模拟工作时间
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.name + "【" + name + "】发送了一条短信！");
	}

}

class TaskEmail implements Runnable {

	private String name;

	public TaskEmail(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		try {
			long time = (long) (Math.random() * 10); // 模拟工作时间
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.name + "【" + name + "】发送了一条邮件！");
	}

}