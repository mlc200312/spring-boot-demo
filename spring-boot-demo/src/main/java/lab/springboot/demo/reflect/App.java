package lab.springboot.demo.reflect;

public class App {

	public static boolean foo(char str) {
		System.out.println(str);
		return true;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			System.out.println(i%300);
		}
	}

}
