package lab.springboot.demo.collections.table;

public class MyLinkedTable implements MyTable {

	private Node head = new Node();

	@Override
	public boolean add(String str) {
		Node node = new Node();
		node.setValue(str);
		if (head.getNext() == null) {
			head.setNext(node);
			return true;
		}
		Node tmp = head;
		while (tmp.getNext() != null) {
			tmp = tmp.getNext();
		}
		tmp.setNext(node);
		return true;
	}

	@Override
	public boolean delete(Node node) {
		Node next = node.getNext();
		if (next == null) {
			node = null;
			return true;
		}

		Node nnext = next.getNext();
		String nvalue = next.getValue();

		node.setValue(nvalue);
		node.setNext(nnext);

		return true;
	}

	@Override
	public boolean delete(int index) {
		if (head.getNext() == null) {
			return false;
		}
		int i = 1;
		Node tmp = head.getNext();
		while (i < index) {
			tmp = tmp.getNext();
			i++;
		}
		delete(tmp);
		return true;
	}

	@Override
	public String get(int index) {
		if (index > length() || index < 1) {
			return null;
		}

		int i = 1;
		Node temp = head.getNext();
		while (i < index) {
			temp = temp.getNext();
			i++;
		}

		return temp.getValue();

	}

	@Override
	public int length() {
		if (head.getNext() == null) {
			return 0;
		}
		int i = 1;
		Node tmp = head.getNext();
		while ((tmp = tmp.getNext()) != null) {
			i++;
		}
		return i;
	}

}
