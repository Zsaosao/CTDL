package lab9;

import java.util.List;

public class ReferenceBook extends ABook {
	private String field;
	private List<Chapter> chapters;

	public ReferenceBook(String title, int numberOfPages, int yearPublished, String author, double price,
			String field, List<Chapter> chapters) {
		super(title, numberOfPages, yearPublished, author, price);
		this.field = field;
		this.chapters = chapters;
	}

	@Override
	public String getType() {
		return "ReferenceBook";
	}

	@Override
	public boolean isSameType(ABook other) {
		return this.getType().equals(other.getType());
	}

	public List<Chapter> getChapters() {
		return chapters;
	}

	public int highestnumberOfPagesInAChapter() {
		int maxPage = 0;
		for (Chapter chapter : chapters) {
			if (chapter.getNumberOfPages() > maxPage) {
				maxPage = chapter.getNumberOfPages();
			}
		}
		return maxPage;
	}

	@Override
	public String toString() {
		return super.toString() + " ReferenceBook [field=" + field + ", chapters=" + chapters + "]";
	}
}
