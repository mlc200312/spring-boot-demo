package lab.springboot.demo.collections.table;

public interface MyTable {

	boolean add(String str);

	boolean delete(Node node);

	boolean delete(int index);

	String get(int index);

	int length();

}
