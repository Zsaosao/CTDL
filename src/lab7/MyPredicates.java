package lab7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class MyPredicates {
	// Remove every object, obj, from coll for which p.test(obj)
	// is true. (This does the same thing as coll.removeIf(p).)

	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iterator = coll.iterator();
		while (iterator.hasNext()) {
			T obj = iterator.next();
			if (p.test(obj)) {
				iterator.remove();
			}
		}
	}

	// Return a Set that contains all unique objects, obj,
	// from the collection, coll, such that p.test(obj)
	// is true.
	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		Set<T> result = new HashSet<>();
		Iterator<T> iterator = coll.iterator();
		while (iterator.hasNext()) {
			T obj = iterator.next();
			if (p.test(obj)) {
				result.add(obj);
			}
		}
		return result;
	}

	// Return the index of the first item in list
	// for which the predicate is true, if any.
	// If there is no such item, return -1.
	public static <T> int find(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iterator = coll.iterator();
		int index = 0;
		while (iterator.hasNext()) {
			T obj = iterator.next();
			if (p.test(obj)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	public static void main(String[] args) {
		// Test case 1: Remove all even numbers from a list of integers
		List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1));
		Even even = new Even();
		Predicate<Integer> isEven = n -> even.test(n);

		MyPredicates.remove(numbers, isEven);
		System.out.println(numbers);

		List<Integer> numbers2 = new ArrayList<>(Arrays.asList(1, 1, 3, 1, 5, 3, 7, 8, 9, 10, 8));
		Set<Integer> numbers3 = MyPredicates.collect(numbers2, isEven);
		System.out.println(numbers3);

		List<Integer> numbers4 = new ArrayList<>(Arrays.asList(1, 1, 3, 1, 5, 3, 7, 8, 9, 10, 8));
		int number = MyPredicates.find(numbers4, isEven);
		System.out.println(number);

	}
}
