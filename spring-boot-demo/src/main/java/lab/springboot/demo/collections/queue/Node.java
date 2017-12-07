package lab.springboot.demo.collections.queue;

public class Node<T> {
	public T data;
	public Node<T> next;

	// 无参构造函数
	public Node() {
	}

	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}
}
