
public class SpellChecker {

	public static void main(String[] args) {
		// String word = args[0];
		// int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		// String correction = spellChecker(word, threshold, dictionary);
		// System.out.println(correction);
		// System.out.println(tail("hey"));
		int lev = levenshtein("hey", "bey");
		System.out.println(lev + " ----- the first test -----");

		String spell = spellChecker("hell0", 1, dictionary);
		System.out.println(spell + " ------ thre second test----");

	}

	public static String tail(String str) {
		String s1 = ""; //define empty string 
		if (str.length() == 1) {
			return s1;
		} else {
			// #feedback - you can use substring to take the string without its first character.
			for (int i = 0; i < str.length() - 1; i++) {
				s1 += (str.charAt(i + 1));
			}
		}
		return s1;
	}

	public static int levenshtein(String word1, String word2) {
		//make sure that the arguments will be lowercase 
		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();

		if (word2.length() == 0) {
			return word1.length();

		} else if (word1.length() == 0) {
			return word2.length();

		} else if (word1.charAt(0) == word2.charAt(0)) {
			return levenshtein(tail(word1), tail(word2));

		} else {
			int min = Math.min(levenshtein(tail(word1), word2), levenshtein(word1, tail(word2)));
			return 1 + Math.min(min, levenshtein(tail(word1), tail(word2)));
		}

	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		String str = "";

		for (int i = 0; i < 3000; i++) {
			str = in.readLine();
			dictionary[i] = str;
		}

		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		int min = 1 + threshold;
		String correct = word;

		for (int i = 0; i < dictionary.length; i++) {
			int distance = levenshtein(word, dictionary[i]);
			if (distance < min) {
				min = distance;
				correct = dictionary[i];

			}
		}
		return correct;
	}

}
