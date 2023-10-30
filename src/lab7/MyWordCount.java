package lab7;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCount {
	// public static final String fileName = "src/asset/hamlet.txt";
	public static final String fileName = "src/asset/hamlet.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Returns a set of WordCount objects that represents the number of times
	// each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens
	public List<WordCount> getWordCounts() {
		List<WordCount> result = new ArrayList<WordCount>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			if (map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
			} else {
				map.put(word, 1);
			}
		}
		for (String key : map.keySet()) {
			result.add(new WordCount(key, map.get(key)));
		}
		return result;

	}

	// Returns the words that their appearance are 1, do not consider duplidated
	// words
	public Set<String> getUniqueWords() {
		Set<String> result = new HashSet<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			if (map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
			} else {
				map.put(word, 1);
			}
		}
		result = new HashSet<String>();
		for (String key : map.keySet()) {
			if (map.get(key) == 1) {
				result.add(key);
			}
		}
		return result;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		Set<String> result = new HashSet<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			if (map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
			} else {
				map.put(word, 1);
			}
		}
		result = new HashSet<String>();
		for (String key : map.keySet()) {
			if (map.get(key) == 2) {
				result.add(key);
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
				return wc2.getCount() - wc1.getCount();
			}
		});
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			if (map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
			} else {
				map.put(word, 1);
			}
		}

		for (String key : map.keySet()) {
			result.add(new WordCount(key, map.get(key)));
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
				return wc2.getCount() - wc1.getCount();
			}
		});
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			if (map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
			} else {
				map.put(word, 1);
			}
		}

		for (String key : map.keySet()) {
			result.add(new WordCount(key, map.get(key)));
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
		for (WordCount word : wordCount.getWordCounts()) {
			System.out.println(word);
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
