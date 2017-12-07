package lab.springboot.demo.collections.table;

public class App {

	public static void main(String[] args) {

		MyTable m = new MyLinkedTable();
		m.add("1");
		m.add("2");
		m.add("3");
		m.add("4");
		m.add("5");
		m.add("6");

		for (int i = 1; i <= m.length(); i++) {
			System.out.println(i + ":" + m.get(i));
		}
		System.out.println("length:" + m.length());

		m.delete(2);
		for (int i = 1; i <= m.length(); i++) {
			System.out.println(i + ":" + m.get(i));
		}
		System.out.println("length:" + m.length());
		System.out.print("index5:" + m.get(5));
	}

}
