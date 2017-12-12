package lab.springboot.demo.collections.queue;

public class LinkedQueue<T> {

	// 队列头指针
	private Node<T> front;
	// 队列尾指针
	private Node<T> rear;

	private int size;

	public LinkedQueue() {
		Node<T> n = new Node<T>(null, null);
		front = rear = n;
	}

	public void enqueue(T data) {
		Node<T> node = new Node<T>(data, null);
		rear.next = node;
		rear = node;
		size++;
	}

	public synchronized T dequeue() {
		if (rear == front) {
			try {
				throw new Exception("堆栈为空");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		Node<T> next = front.next;
		T data = next.data;
		front.next = next.next;
		// 判断出队列长度是否为1
		if (next.next == null)
			rear = front;
		// 删除节点
		next = null;
		size--;
		return data;
	}

	/**
	 * 队列长队
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * 判断队列是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;

	}

}
