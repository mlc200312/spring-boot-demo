package lab.springboot.demo.design;

public class Single {

	private final static Single SINGLE = new Single();

	private Single() {
		super();
	}

	public static Single newInstance() {
		return SINGLE;
	}

	public void add() {
	}

	public static void main(String[] args) {
		Single.newInstance().add();
	}

}
