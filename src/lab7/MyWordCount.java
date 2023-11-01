package lab7;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCount {
	// public static final String fileName = "src/asset/hamlet.txt";
	public static final String fileName = "src/asset/fit.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int countWord(String word) {
		int count = 0;
		for (int i = 0; i < this.words.size(); i++) {
			if (this.words.get(i).equals(word)) {
				count++;
			}
		}
		return count;
	}

	// Returns a set of WordCount objects that represents the number of times
	// each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens
	public List<WordCount> getWordCounts() {
		List<WordCount> result = new ArrayList<WordCount>();
		for (String word : words) {
			WordCount wc = new WordCount(word, countWord(word));
			if (!result.contains(wc)) {
				result.add(wc);
			}
		}

		return result;

	}

	// Returns the words that their appearance are 1, do not consider duplidated
	// words
	public Set<String> getUniqueWords() {
		Set<String> result = new HashSet<String>();
		for (int i = 0; i < this.getWordCounts().size(); i++) {
			if (this.getWordCounts().get(i).getCount() == 1) {
				result.add(this.getWordCounts().get(i).getWord());
			}
		}
		return result;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		Set<String> result = new HashSet<String>();
		for (int i = 0; i < this.getWordCounts().size(); i++) {
			if (this.getWordCounts().get(i).getCount() == 2) {
				result.add(this.getWordCounts().get(i).getWord());
			}
		}
		return result;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> printWordCounts() {
		Set<WordCount> result = new TreeSet<WordCount>(new Comparator<WordCount>() {
			@Override
			public int compare(WordCount wc1, WordCount wc2) {
				if (wc1.getCount() - wc2.getCount() == 0) {
					return wc1.getWord().compareToIgnoreCase(wc2.getWord());
				}
				return wc1.getCount() - wc2.getCount();
			}
		});

		for (String word : words) {
			WordCount wc = new WordCount(word, countWord(word));
			if (!result.contains(wc)) {
				result.add(wc);
			}
		}

		return result;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsByOccurence() {
		Set<WordCount> result = new TreeSet<WordCount>(new Comparator<WordCount>() {
			@Override
			public int compare(WordCount wc1, WordCount wc2) {
				if (wc1.getCount() - wc2.getCount() == 0) {
					return wc2.getWord().compareToIgnoreCase(wc1.getWord());
				}
				return wc2.getCount() - wc1.getCount();
			}
		});

		for (String word : words) {
			WordCount wc = new WordCount(word, countWord(word));
			if (!result.contains(wc)) {
				result.add(wc);
			}
		}

		return result;
	}

	// delete words begining with the given pattern (i.e., delete words begin with
	// 'A' letter
	public Set<String> filterWords(String pattern) {
		Set<String> result = new HashSet<String>();
		for (String word : words) {
			if (!word.startsWith(pattern)) {
				result.add(word);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		MyWordCount wordCount = new MyWordCount();
		List<WordCount> wc = wordCount.getWordCounts();
		for (int i = 0; i < wc.size(); i++) {
			System.out.println(wc.get(i));
		}
		System.out.println("--------------------------------------");
		for (String word : wordCount.getUniqueWords()) {
			System.out.println(word);
		}
		System.out.println("--------------------------------------");
		for (String word : wordCount.getDistinctWords()) {
			System.out.println(word);
		}
		System.out.println("--------------------------------------");
		for (WordCount word : wordCount.printWordCounts()) {
			System.out.println(word);
		}
		System.out.println("--------------------------------------");
		for (WordCount word : wordCount.exportWordCountsByOccurence()) {
			System.out.println(word);
		}
		System.out.println("--------------------------------------");
		for (String word : wordCount.filterWords("A")) {
			System.out.print(word + " ");
		}

	}
}
