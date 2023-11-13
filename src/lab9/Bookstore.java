package lab9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Bookstore {
	private List<ABook> books;

	public Bookstore(List<ABook> books) {
		this.books = books;
	}

	public double totalAmountOfTheBookstore() {
		double total = 0;
		for (ABook book : books) {
			total += book.getPrice();
		}
		return total;
	}

	public ABook referencebooksHavetheMostChapters() {
		ABook maxPage = new ReferenceBook("", 0, 0, "", 0, "", new ArrayList<Chapter>());
		for (ABook book : books) {
			if (book instanceof ReferenceBook) {
				if (((ReferenceBook) book).highestnumberOfPagesInAChapter() > ((ReferenceBook) maxPage)
						.highestnumberOfPagesInAChapter()) {
					maxPage = book;
				}
			}
		}
		return maxPage;
	}

	public boolean isContainsAMagazine(String magazineName) {
		for (ABook book : books) {
			if (book instanceof Magazine) {
				if (((Magazine) book).sameMagazineName(magazineName)) {
					return true;
				}
			}
		}
		return false;
	}

	public List<ABook> booksPublishedDuringtheYear(int year) {
		List<ABook> booksPublishedDuringtheYear = new LinkedList<ABook>();
		for (ABook book : books) {
			if (book.isSameYearPublished(year)) {
				booksPublishedDuringtheYear.add(book);
			}
		}
		return booksPublishedDuringtheYear;
	}

	// /Sort publications ascending by title and descending by year of publication
	// (history using the Comparable or Comparator interface)
	public List<ABook> ascendingByTitleanddescendingbyyearofpublication() {
		List<ABook> sortedBooks = new ArrayList<ABook>(books);
		sortedBooks.sort(new Comparator<ABook>() {
			@Override
			public int compare(ABook o1, ABook o2) {
				if (o1.compareToTitle(o2) == 0) {
					return o2.compareToYear(o1);
				}
				return o1.compareToTitle(o2);
			}
		});
		return sortedBooks;
	}

	// Statistics on the number of products published by year. For example 2020: 5,
	// 2021: 10, … In 2020 there were 5 publications, in 2021 there were 10
	// publications.
	public Map<Integer, List<ABook>> numberOfProductsPublishedByYear() {
		Map<Integer, List<ABook>> map = new HashMap<Integer, List<ABook>>();
		for (ABook book : books) {
			if (map.containsKey(book.getYearPublished())) {
				map.get(book.getYearPublished()).add(book);
			} else {
				List<ABook> list = new ArrayList<ABook>();
				list.add(book);
				map.put(book.getYearPublished(), list);
			}
		}
		return map;
	}

	public static void main(String[] args) {
		List<ABook> books = new ArrayList<ABook>();

		Magazine magazine1 = new Magazine("Magazine1", 100, 2023, "Author1", 100, "Magazine1");
		Magazine magazine2 = new Magazine("Magazine2", 100, 2020, "Author2", 120, "Magazine2");
		Magazine magazine3 = new Magazine("Magazine3", 100, 2020, "Author3", 140, "Magazine3");
		Magazine magazine4 = new Magazine("Magazine3", 10, 2025, "Author4", 80, "Magazine4");

		Chapter chapter1 = new Chapter("Chapter1", 100);
		Chapter chapter2 = new Chapter("Chapter2", 400);
		Chapter chapter3 = new Chapter("Chapter3", 300);

		List<Chapter> chapters = new ArrayList<Chapter>();
		List<Chapter> chapters2 = new ArrayList<Chapter>();
		chapters.add(chapter1);
		chapters.add(chapter2);

		chapters2.add(chapter3);

		ReferenceBook referenceBook1 = new ReferenceBook("ReferenceBook1", 100, 2020, "Author1", 100, "ReferenceBook1",
				chapters);

		ReferenceBook referenceBook2 = new ReferenceBook("ReferenceBook2", 100, 2021, "Author2", 100, "ReferenceBook2",
				chapters2);

		books.add(magazine1);
		books.add(magazine2);
		books.add(magazine3);
		books.add(magazine4);

		books.add(referenceBook1);
		books.add(referenceBook2);

		Bookstore bookstore = new Bookstore(books);
		// System.out.println(bookstore.totalAmountOfTheBookstore());

		// System.out.println(bookstore.referencebooksHavetheMostChapters().getTitle());

		// System.out.println(bookstore.isContainsAMagazine("Magazine1"));
		// System.out.println(bookstore.isContainsAMagazine("Magazine100"));

		// System.out.println(bookstore.booksPublishedDuringtheYear(2020).size());

		// System.out.println(bookstore.ascendingByTitleanddescendingbyyearofpublication());

		System.out.println(bookstore.numberOfProductsPublishedByYear());

	}

}
