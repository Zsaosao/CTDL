package lab3;

public class Order {

	private OrderItem[] items;

	public Order(OrderItem[] items) {
		super();
		this.items = items;
	}

	public OrderItem[] getItems() {
		return items;
	}

	public double cost() {
		double totalCost = 0;
		for (int i = 0; i < this.items.length; i++) {
			totalCost += this.items[i].getPriceOfProduct();
		}
		return totalCost;
	}

	public boolean contains(Product p) {

		int left = 0;
		int right = this.items.length - 1;

		while (right >= left) {
			int mid = (left + right) / 2;
			if (this.items[mid].equalsProduct(p)) {
				return true;
			} else if (this.items[mid].getPriceOfProduct() < p.getPrice()) {
				left = mid + 1;

			} else {
				right = mid - 1;
			}
		}

		return false;
	}

	public Product[] filter(String type) {
		int count = 0;
		for (int i = 0; i < this.items.length; i++) {
			if (this.items[i].isSameTypeOfProduct(type)) {
				count++;
			}
		}
		Product productRes[] = new Product[count];
		int index = 0;
		for (int i = 0; i < this.items.length; i++) {
			if (this.items[i].isSameTypeOfProduct(type)) {
				productRes[index] = this.items[i].getP();
				index++;
			}
		}
		return productRes;
	}
}
