package lab3;

public class OrderItem implements Comparable<OrderItem> {
	private Product p;
	private int quality;

	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public OrderItem(Product p, int quality) {
		super();
		this.p = p;
		this.quality = quality;
	}

	public double getPriceOfProduct() {
		return this.p.getPrice();
	}

	public boolean isSameTypeOfProduct(String type) {
		return this.p.isSameType(type);
	}

	@Override
	public int compareTo(OrderItem o) {
		return this.p.compareTo(o.getP());
	}

	@Override
	public String toString() {
		return "OrderItem [p=" + p + ", quality=" + quality + "]";
	}
}
