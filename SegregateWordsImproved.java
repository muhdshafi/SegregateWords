package misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 
 * @author Shafi
 *
 */
public class SegregateWordsImproved {

	public static void main(String[] args) {
		List<String> input = new ArrayList<>();
		input.add("abcAd");
		input.add("abcdcd");
		input.add("ab2cde");
		input.add("abcd");
		input.add("dca?b");
		input.add("ecadbaced");
		Collection<List<String>> result = segerate(input);
		System.out.println(result);

	}

	/**
	 * 
	 * @param input
	 * @return
	 */
	private static Collection<List<String>> segerate(List<String> input) {
		Map<String, List<String>> mapResult = new HashMap<>();
		for (String word : input) {
			String strSortedUniqueLetters = getSortedUniqueLettersInWord(word);
			List<String> listOFWords = null;
			if (mapResult.containsKey(strSortedUniqueLetters)) {
				listOFWords = mapResult.get(strSortedUniqueLetters);
				listOFWords.add(word);
			} else {
				listOFWords = new ArrayList<String>();
				listOFWords.add(word);
				mapResult.put(strSortedUniqueLetters, listOFWords);
			}
		}
		return mapResult.values();
	}

	/**
	 * Return String of sorted unique letters
	 * 0-128 ASCII characters 
	 * @param word
	 * @return
	 */
	private static String getSortedUniqueLettersInWord(String word) {
		String strSortedUniqueLetters = "";
		
		boolean[] charArray = new boolean[128];
		for (char c : word.toCharArray()) {
			charArray[c] = true;
		}
		for (int i = 0; i < 128; i++) {
			if (charArray[i] == true) {
				strSortedUniqueLetters += (char)i;
			}
		}

		return strSortedUniqueLetters;
	}

}
