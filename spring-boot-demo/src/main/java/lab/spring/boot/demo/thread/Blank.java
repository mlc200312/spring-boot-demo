package lab.spring.boot.demo.thread;

public class Blank {
	public static double MAX_MONEY = 200d;
	public static Blank CHINA_BLANK = null;

	static {
		CHINA_BLANK = new Blank();
		CHINA_BLANK.setMoney(100d);
		CHINA_BLANK.setCount(0);
	}

	private double money;
	private int count;

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public synchronized void save(double money) {
		this.count++;
		System.out.println("共操作了" + Blank.CHINA_BLANK.getCount() + "次！");
		if ((money + this.money) > MAX_MONEY) {
			System.out.println("存款失败！");
			throw new RuntimeException("最大存储金额不能大于" + MAX_MONEY);
		}
		this.money += money;
		System.out.println("存款成功！");
	}

	public synchronized void take(double money) {
		this.count++;
		System.out.println("共操作了" + Blank.CHINA_BLANK.getCount() + "次！");
		if (money > this.money) {
			System.out.println("取款失败！");
			throw new RuntimeException("取款金额：" + money + "，余额：" + this.money
					+ "，余额不足");
		}
		this.money -= money;
		System.out.println("取款成功！");
	}

}
