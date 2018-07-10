package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Segregate words
 * 
 * Algo 
 * 	1. read words 
 * 	2.1. copy word 
 * 	2.2. remove duplicates from each word 
 * 	2.3. sort the word 
 *  2.4. match and put it in Map<String , List<String>> 
 *  	 (key is modified value, value is list of actual value) 
 *  3. return the values set
 * 
 * @author Shafi
 *
 */
public class SegregateWords {

	public static void main(String[] args) {
		List<String> input = new ArrayList<>();
		input.add("abcd");
		input.add("abcdcd");
		input.add("abcde");
		input.add("abcd");
		input.add("dcab");
		input.add("ecadbaced");
		Collection<List<String>> result = segerate(input);
		System.out.println(result);
	}



	/**
	 * 
	 * @param input
	 * @return
	 */
	public static Collection<List<String>> segerate(List<String> input) {
		Map<String, List<String>> mapResult = new HashMap<String, List<String>>();
		List<String> listOFWords = null;
		for (String word : input) {
			String strUniqueLetters = removeDuplicate(word);
			String strSortedUniqueLetters = sortString(strUniqueLetters);
			if (mapResult.containsKey(strSortedUniqueLetters)) {
				listOFWords = mapResult.get(strSortedUniqueLetters);
				listOFWords.add(word);
			} else {
				listOFWords = new ArrayList<String>();
				listOFWords.add(word);
				mapResult.put(strSortedUniqueLetters, listOFWords);
			}
		}
		System.out.println(mapResult);
		return mapResult.values();
	}

	/**
	 * API to remove duplicate letters from the given String
	 * 
	 * @param inputStr
	 * @return
	 */
	public static String removeDuplicate(String inputStr) {
		String resultStr = "";
		if (inputStr != null && !inputStr.isEmpty()) {
			for (char c : inputStr.toCharArray()) {
				if (resultStr.indexOf(c) == -1) {
					resultStr += c;
				}
			}
		}

		return resultStr.toString();
	}

	/**
	 * Sort the given String
	 * 
	 * @param inputStr
	 * @return
	 */
	public static String sortString(String inputStr) {
		String resultStr = "";
		char[] arrayUniqueLetters = inputStr.toCharArray();
		Arrays.sort(arrayUniqueLetters);
		resultStr = new String(arrayUniqueLetters);
		return resultStr;
	}

}
