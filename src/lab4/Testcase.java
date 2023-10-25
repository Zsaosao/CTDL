package lab4;

import java.util.Arrays;

import lab3.Order;
import lab3.OrderItem;
import lab3.Product;

public class Testcase {
	public static void main(String[] args) {

		int array1[] = { 4, 5, 1, 2, 0, 9, 9, 10, 3 };
		SortingAlgorithms.selectionSort(array1);
		System.out.println(Arrays.toString(array1));
		int array2[] = { 4, 5, 1, 2, 0, 9, 9, 10, 3 };
		SortingAlgorithms.bubbleSort(array2);
		System.out.println(Arrays.toString(array2));
		int array3[] = { 4, 5, 1, 2, 0, 9, 9, 10, 3 };
		SortingAlgorithms.insertionSort(array3);
		System.out.println(Arrays.toString(array3));

		OrderItem orderItem[] = new OrderItem[4];
		Product pro1 = new Product("1", "milk", 80, "pro1");
		Product pro2 = new Product("2", "milk", 100, "pro1");
		Product pro3 = new Product("3", "milk", 30, "pro2");
		Product pro4 = new Product("4", "milk", 70, "pro2");

		orderItem[0] = new OrderItem(pro1, 10);
		orderItem[1] = new OrderItem(pro2, 2);
		orderItem[2] = new OrderItem(pro3, 8);
		orderItem[3] = new OrderItem(pro4, 90);

		Arrays.sort(orderItem);

		Order order = new Order(orderItem);

		System.out.println(Arrays.toString(order.getItems()));

		int array4[] = { 4, 5, 1, 2, 0, 9, 9, 10, 3 };
		SortingAlgorithms.mergeSort(array4);
		System.out.println(Arrays.toString(array4));

		int array5[] = { 6, 4, 5, 1, 2, 0, 9, 9, 10, 3 };
		SortingAlgorithms.quickSort(array5);
		System.out.println(Arrays.toString(array5));
	}
}
