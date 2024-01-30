

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = "iloveabandon";
		String []dictionary = readDictionary("dictionary.txt");
		
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);
		String str = ""; 

		for ( int i = 0; i < 3000; i++) {
			str = in.readLine(); 
			dictionary[i] = str; 
		}
		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {
		boolean isExist = false; 
		for ( int i = 0; i < dictionary.length; i++) {
			if ( word.equals(dictionary[i])) {
				isExist = true; 
			}
		}
		return isExist; 
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {


		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
 
        int N = hashtag.length();
  
        for (int i = 1; i <= N; i++) {
        	

        	if (existInDictionary(hashtag.substring(0,i)  , dictionary) == true) {
        		System.out.println(hashtag.substring(0,i));
        		breakHashTag( hashtag.substring(i) , dictionary);
        	} else { 
				continue;
        		
        	}

        }
    }
	 


}
