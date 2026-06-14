import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/valid-anagram/description/
public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        boolean isAnag = isAnagram(s, t);
        if (isAnag) {
            System.out.println("This is anagram");
        } else {
            System.out.println("This is not an anagram");
        }
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sourceChars = s.toCharArray();

        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        for (int i = 0; i < sourceChars.length; i++) {
            frequencyMap.put(sourceChars[i], frequencyMap.getOrDefault(sourceChars[i], 0) + 1);
        }

        for (char targetSingleValue : t.toCharArray()) {
            Integer frequency = frequencyMap.get(targetSingleValue);
            if (frequency == null) {
                return false;
            }
            if (frequency == 1) {
                frequencyMap.remove(targetSingleValue);
            } else {
                frequencyMap.put(targetSingleValue, frequency - 1);
            }
        }
        return frequencyMap.isEmpty();

    }
}
