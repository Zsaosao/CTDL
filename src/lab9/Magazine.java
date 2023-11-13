package lab9;

public class Magazine extends ABook {

	private String magazineName;

	public Magazine(String title, int numberOfPages, int yearPublished, String author, double price,
			String magazineName) {
		super(title, numberOfPages, yearPublished, author, price);
		this.magazineName = magazineName;
	}

	@Override
	public String getType() {
		return "Magazine";
	}

	public boolean sameMagazineName(String magazineName) {
		return this.magazineName.equals(magazineName);
	}

	@Override
	public boolean isSameType(ABook other) {
		return this.getType().equals(other.getType());
	}

	@Override
	public String toString() {
		return super.toString() + " Magazine [magazineName=" + magazineName + "]";

	}

}
