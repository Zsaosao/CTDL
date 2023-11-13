package lab9;

abstract class ABook {
	private String title;
	private int numberOfPages;
	private int yearPublished;
	private String author;
	private double price;

	public ABook(String title, int numberOfPages, int yearPublished, String author, double price) {
		this.title = title;
		this.numberOfPages = numberOfPages;
		this.yearPublished = yearPublished;
		this.author = author;
		this.price = price;
	}

	public String getType() {
		return "Book";
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public String getTitle() {
		return title;
	}

	public abstract boolean isSameType(ABook other);

	public boolean isPublishedTimeAgo10Years() {
		return (2021 - this.yearPublished) > 10;
	}

	public boolean isSameYearPublished(int year) {
		return this.yearPublished == year;
	}

	public double getPrice() {
		return price;
	}

	public boolean isSameTypeAndAuthor(ABook other) {
		return this.isSameType(other) && this.author.equals(other.author);
	}

	public int compareTo(ABook o2) {
		return 0;
	}

	public int compareToTitle(ABook o2) {
		return this.title.compareTo(o2.title);
	}

	public int compareToYear(ABook o2) {
		return this.yearPublished - o2.yearPublished;
	}

	@Override
	public String toString() {
		return "ABook [title=" + title + ", numberOfPages=" + numberOfPages + ", yearPublished=" + yearPublished
				+ ", author=" + author + ", price=" + price + "]" + "\n";
	}

}
