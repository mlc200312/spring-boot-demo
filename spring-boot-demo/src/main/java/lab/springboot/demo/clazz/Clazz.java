package lab.springboot.demo.clazz;

public class Clazz {

	/**
	 * 成员内部类
	 * 
	 * @author liangchao.min
	 *
	 */
	class Clazz1 {
		// 不能声明静态属性、静态方法
	}

	Clazz1 getClazz1() {
		return new Clazz1();
	}

	public Clazz1 getClazz2() {
		/**
		 * 局部内部类
		 * 
		 * @author liangchao.min
		 *
		 */
		class Clazz2 extends Clazz1 {
		}
		return new Clazz2();
	}

	/**
	 * 嵌套内部类
	 * 
	 * @author liangchao.min
	 *
	 */
	static class Clazz3 {
		// 普通内部类不能有static数据和static属性，也不能包含嵌套类，但嵌套类可以。而嵌套类不能声明为private，一般声明为public，方便调用。
		static String name;

	}

	public interface Myitfc {
		void test();
	}

	void method2(Myitfc myitfc) {
	}

	public static void main(String[] args) {
		Clazz.Clazz1 clazz1 = new Clazz().new Clazz1();//成员内部类调用
		
		Clazz1 clazz2 = new Clazz().getClazz2();//局部内部类调用
		
		Clazz.Clazz3 clazz3 = new Clazz.Clazz3();//静态内部类调用
		
		/**
		 * 匿名内部类
		 */
		new Clazz().method2(new Myitfc() {

			@Override
			public void test() {

			}
		});

	}

}
