import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int lengthCount = lengthOfLongestSubstring(s);
        System.out.println("lengthCount "+lengthCount);
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> window = new  HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
                
            // If value present in window, remove till  come to i size
            while (window.contains(s.charAt(i))) {
                window.remove(s.charAt(i));
                left++;
            }
            // Add value in window
            window.add(s.charAt(i));

            maxLength = Math.max(maxLength, i- left + 1);
        }
        return maxLength;
    }
}
