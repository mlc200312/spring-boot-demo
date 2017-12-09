package lab.springboot.demo.thread;

import lab.springboot.demo.collections.queue.LinkedQueue;

public class TicketCounter {
	// 接受服务的时间
	private static int PROCESS = 120;
	// 最多窗口数
	private static int MAX_CASHIERS = 10;
	// 顾客的数量
	private static int NUM_CUSTOMERS = 100;

	public static void main(String[] args) {
		Costomer costomer;
		// 存储顾客的队列
		LinkedQueue<Costomer> costomerQueue = new LinkedQueue<Costomer>();
		int[] cashierTime = new int[MAX_CASHIERS];
		int totalTime, averageTime, departs;
		// 该循环决定了每遍模拟时用了多少个售票口
		for (int cashiers = 0; cashiers < MAX_CASHIERS; cashiers++) {
			// 将售票口的服务时间初始化为 0
			for (int count = 0; count < cashiers; count++) {
				cashierTime[count] = 0;
			}
			// 往costomerQueue存储顾客，模拟每隔15分钟来一个顾客
			for (int count = 1; count <= NUM_CUSTOMERS; count++) {
				costomerQueue.enqueue(new Costomer(count * 15));
			}
			// 初始化总的服务时间为0
			totalTime = 0;
			// 开始服务
			while (!(costomerQueue.isEmpty())) {
				for (int count = 0; count <= cashiers; count++) {
					if (!(costomerQueue.isEmpty())) {
						// 取出一位顾客
						costomer = costomerQueue.dequeue();
						// 顾客来的时间与售票口的服务时间相比
						if (costomer.getArrivalTime() > cashierTime[count]) {
							// 表示空闲，可以进行服务
							departs = costomer.getArrivalTime() + PROCESS;
						} else {
							// 无空闲则需排队等待
							departs = cashierTime[count] + PROCESS;
						}
						// 保存用户的离开时间
						costomer.setDepartureTime(departs);
						// 设置该售票口的服务时间
						cashierTime[count] = departs;
						// 计算总的服务时间
						totalTime += costomer.totalTime();
					}
				}
			}

			averageTime = totalTime / NUM_CUSTOMERS;
			System.out.println("售票口数量： " + (cashiers + 1));
			System.out.println("平均时间： " + averageTime + "\n");

		}
	}

}