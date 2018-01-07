import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Anagrams {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of words and words: ");
		int len = in.nextInt();
		int result = 0;
		HashMap<String, MutableInt> Map = new HashMap<String, MutableInt>();
		for (int i = 0; i < len; i++) {
			char[] A = in.next().toCharArray();
			Arrays.sort(A);
			String word = new String(A);
			MutableInt count = Map.get(word);
			if (count == null)
				Map.put(word, new MutableInt(1));
			else
				count.increment();
			result = Math.max(result, Map.get(word).getValue());
		}
		in.close();
		System.out.println(result);
	}
}
