package lab9;

public class Chapter {
	String title;
	int numberOfPages;

	public Chapter(String title, int numberOfPages) {
		this.title = title;
		this.numberOfPages = numberOfPages;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	@Override
	public String toString() {
		return "Chapter [title=" + title + ", numberOfPages=" + numberOfPages + "]";
	}
}
