package lab3;

public class Product implements Comparable<Product> {
	private String id;
	private String name;
	private double price;
	private String type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Product(String id, String name, double price, String type) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public boolean isSameType(String type) {
		return this.type.equals(type);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", type=" + type + "]";
	}

	public boolean equals(Product p) {
		return this.id.equals(p.id) && this.name.equals(p.name) && this.price == p.price && this.type.equals(p.type);
	}

	@Override
	public int compareTo(Product o) {
		int res = this.name.compareTo(o.name);
		if (res == 0) {
			return Double.compare(this.price, o.price);
		}
		return res;
	}
}
