package lab8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class TextAnalyzer {
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader reffered in file TextFileUtils.java
	public void load(String fileName) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line = null;
			int position = 0;
			try {
				while (true) {
					line = reader.readLine();
					if (line == null)
						break;
					StringTokenizer tokens = new StringTokenizer(line, " ");
					while (tokens.hasMoreTokens()) {
						String word = tokens.nextToken();
						if (map.containsKey(word)) {
							map.get(word).add(position);
						} else {
							ArrayList<Integer> list = new ArrayList<Integer>();
							list.add(position);
							map.put(word, list);

						}
						position++;
					}
					if (map.containsKey("\n")) {
						map.get("\n").add(position);
					} else {
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(position);
						map.put("\n", list);
					}
					position++;

				}
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) {
		if (map.containsKey(word)) {
			map.get(word).add(position);
		} else {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(position);
			map.put(word, list);
		}

	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
		Map<String, ArrayList<Integer>> sortedMap = new HashMap<String, ArrayList<Integer>>();
		sortedMap.putAll(map);
		sortedMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));

	}

	public int countAllWords() {
		int count = 0;
		for (String word : map.keySet()) {
			count += map.get(word).size();
		}
		System.out.println(count);
		return count;
	}

	// This method will display the content of the text file stored in the map
	public void displayText() {
		int count = countAllWords();
		String content[] = new String[count];
		for (String word : map.keySet()) {
			for (int i = 0; i < map.get(word).size(); i++) {
				content[map.get(word).get(i)] = word;
			}
		}
		for (int i = 0; i < content.length; i++) {
			System.out.print(" " + content[i]);
		}

	}

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
		int max = 0;
		String word = "";
		for (String w : map.keySet()) {
			if (map.get(w).size() > max && !w.equals("\n")) {
				max = map.get(w).size();
				word = w;
			}
		}
		return word;
	}

	public static void main(String[] args) {
		TextAnalyzer ta = new TextAnalyzer();
		ta.load("src/asset/fitMap.txt");
		ta.displayWords();
		ta.displayText();
		System.out.println("Most frequent word: " + ta.mostFrequentWord());
	}

}
