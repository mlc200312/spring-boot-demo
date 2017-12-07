package lab.springboot.demo.collections.queue;

public class App {

	public static void main(String[] args) {

		LinkedQueue<Integer> queue = new LinkedQueue<>();
		queue.enqueue(1);
		System.out.println(queue.size());
		queue.enqueue(2);
		System.out.println(queue.size());
		queue.enqueue(3);
		System.out.println(queue.size());
		queue.enqueue(4);
		System.out.println(queue.size());

		System.out.println("---------------------------");
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}

}
