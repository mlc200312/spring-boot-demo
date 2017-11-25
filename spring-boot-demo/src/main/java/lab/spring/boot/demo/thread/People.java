package lab.spring.boot.demo.thread;

public class People implements Runnable {

	public People(Move move, double money) {
		super();
		this.move = move;
		this.money = money;
	}

	private Move move;
	private double money;

	public Move getMove() {
		return move;
	}

	public void setMove(Move move) {
		this.move = move;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	@Override
	public void run() {
		if (move == Move.IN) {
			System.out.println("预备存储金额：" + money);
			Blank.CHINA_BLANK.save(money);
			System.out.println("存储金额：" + money + "，当前卡内余额："
					+ Blank.CHINA_BLANK.getMoney());
		} else {
			System.out.println("预备取款金额：" + money);
			Blank.CHINA_BLANK.take(money);
			System.out.println("取款金额：" + money + "，当前卡内余额："
					+ Blank.CHINA_BLANK.getMoney());
		}
	}

}
