package lab.springboot.demo.thread;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ThreadPoolTask implements Runnable, Serializable {

	private Object attachData;

	ThreadPoolTask(Object tasks) {
		this.attachData = tasks;
	}

	public void run() {
		System.out.println("开始执行任务：" + attachData);
		attachData = null;
	}

	public Object getTask() {
		return this.attachData;
	}
}