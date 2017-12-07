package lab.springboot.demo;

public class App {

	public class Person implements Cloneable {

		private int age;
		private String name;

		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}

		public Person() {
		}

		public int getAge() {
			return age;
		}

		public String getName() {
			return name;
		}

		@Override
		protected Object clone() throws CloneNotSupportedException {
			return (Person) super.clone();
		}
	}

	public Person getPerson(int age, String name) {
		return new Person(age, name);
	}

	public static void main(String[] args) {
		App app = new App();
		try {
			Person person = app.getPerson(12, "张三");
			person.hashCode();
			Person clonePerson = (Person) person.clone();
			Person clonePerson2 = person;
			System.out.println(person.getName() == clonePerson.getName() ? "浅拷贝" : "深拷贝");
			System.out.println(person.getName() == clonePerson2.getName() ? "浅拷贝" : "深拷贝");
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

	}
}
