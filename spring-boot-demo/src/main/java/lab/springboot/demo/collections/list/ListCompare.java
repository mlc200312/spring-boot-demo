package lab.springboot.demo.collections.list;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListCompare {
	public static void testPerformance() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();

		int times = 1000 * 1000;
		// times = 100 * 1000;
		// times = 1000 * 1000;
		System.out.println("Test times = " + times);
		System.out.println("-------------------------");
		// ArrayList add
		long startTime = System.nanoTime();

		for (int i = 0; i < times; i++) {
			arrayList.add(i);
		}
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println(duration + " <--ArrayList add");

		// LinkedList add
		startTime = System.nanoTime();

		for (int i = 0; i < times; i++) {
			linkedList.add(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println(duration + " <--LinkedList add");
		System.out.println("-------------------------");
		// ArrayList get
		startTime = System.nanoTime();

		for (int i = 0; i < times; i++) {
			arrayList.get(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println(duration + " <--ArrayList get");

		// LinkedList get
		startTime = System.nanoTime();

		for (int i = 0; i < times; i++) {
			linkedList.get(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println(duration + " <--LinkedList get");
		System.out.println("-------------------------");

//		// ArrayList set
//		startTime = System.nanoTime();
//
//		for (int i = times - 1; i >= 0; i--) {
//			arrayList.set(0, i);
//		}
//		endTime = System.nanoTime();
//		duration = endTime - startTime;
//		System.out.println(duration + " <--ArrayList set");
//
//		// LinkedList set
//		startTime = System.nanoTime();
//
//		for (int i = times - 1; i >= 0; i--) {
//			linkedList.set(0, i);
//		}
//		endTime = System.nanoTime();
//		duration = endTime - startTime;
//		System.out.println(duration + " <--LinkedList set");
//		System.out.println("-------------------------");

		// ArrayList remove
		startTime = System.nanoTime();

		for (int i = times - 1; i >= 0; i--) {
			arrayList.remove(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println(duration + " <--ArrayList remove");

		// LinkedList remove
		startTime = System.nanoTime();

		for (int i = times - 1; i >= 0; i--) {
			linkedList.remove(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println(duration + " <--LinkedList remove");
	}
}
