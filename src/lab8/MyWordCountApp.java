package lab8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "src/asset/fitMap.txt";
	// <word, its occurences>
	private Map<String, Integer> map = new HashMap<String, Integer>();

	// Load data from fileName into the above map (containing <word, its
	// occurences>)
	// using the guide given in TestReadFile.java
	public void loadData() {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line = null;
			while (true) {
				line = reader.readLine();

				if (line == null)
					break;
				String[] tokens = line.split(" ");

				for (int i = 0; i < tokens.length; i++) {
					if (map.containsKey(tokens[i])) {
						map.put(tokens[i], map.get(tokens[i]) + 1);
					} else {
						map.put(tokens[i], 1);
					}
				}

			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Returns the number of unique tokens in the file data/hamlet.txt or fit.txt
	public int countUnique() {
		Set<String> set = new HashSet<String>();
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			set.add(it.next());
		}
		return set.size();
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		map.forEach((k, v) -> System.out.println(k + " - " + v));
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() {

		Map<String, Integer> sortMap = new HashMap<String, Integer>();
		sortMap.putAll(map);
		sortMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
	}

	public static void main(String[] args) {
		MyWordCountApp app = new MyWordCountApp();
		app.loadData();
		System.out.println("Number of unique tokens: " + app.countUnique());
		try {
			app.printWordCounts();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		app.printWordCountsAlphabet();

	}
}
