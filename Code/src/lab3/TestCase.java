package lab3;

import java.util.Arrays;

public class TestCase {
	public static void main(String[] args) {
		OrderItem orderItem[] = new OrderItem[4];
		Product pro1 = new Product("1", "milk", 80, "pro1");
		Product pro2 = new Product("2", "milk", 100, "pro1");
		Product pro3 = new Product("3", "milk", 30, "pro2");
		Product pro4 = new Product("4", "milk", 70, "pro2");

		Product pro5 = new Product("4", "milk", 40, "pro2");

		orderItem[0] = new OrderItem(pro1, 10);
		orderItem[1] = new OrderItem(pro2, 2);
		orderItem[2] = new OrderItem(pro3, 8);
		orderItem[3] = new OrderItem(pro4, 90);

		Arrays.sort(orderItem);

		Order order = new Order(orderItem);

		System.out.println(order.contains(pro1));
		System.out.println(order.contains(pro5));

		System.out.println(Arrays.toString(order.getItems()));

		System.out.println(Arrays.toString(order.filter("pro2")));
	}
}