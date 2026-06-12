import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lognest_substring_wihtout_repeating_character {
    public static void main(String[] args) {
        String s = "abcdabcbb";
        // int length = lengthOfLongestSubstringBruteforce(s);
        int length = lengthOfLongestSubstringOptimal(s);
        System.out.println("Length of the longest substring without repeating characters: " + length);
    }

    // Brute force approach
    public static int lengthOfLongestSubstringBruteforce(String s) {
        int n = s.length();
        int maxLen = 0;
        // Iterate through all possible starting points
        for (int i = 0; i < n; i++) {
            int[] hash = new int[256]; // For extended ASCII
            Arrays.fill(hash, 0);

            for (int j = i; j < n; j++) {
                if (hash[s.charAt(j)] == 1)
                    break; // Found repeated
                hash[s.charAt(j)] = 1;
                int len = j - i + 1;
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;

    }

    // Optimal Approach
    public static int lengthOfLongestSubstringOptimal(String s) {

        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int left = 0;
        int n = s.length();
        
        for (int right = 0; right < n; right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;

    }

    public static int lengthOfLongestSubstringBruteforce_2(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isUnique(s, i, j)) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }

    private static boolean isUnique(String s, int start, int end) {
        boolean[] visited = new boolean[256];
        for (int i = start; i <= end; i++) {
            char ch = s.charAt(i);
            if (visited[ch]) {
                return false;
            }
            visited[ch] = true;
        }
        return true;
    }

    // public static int lengthOfLongestSubstring(String s) {
    // int maxLength = 0;
    // int left = 0;
    // Map<Character, Integer> charIndexMap = new HashMap<>();

    // for (int right = 0; right < s.length(); right++) {
    // char currentChar = s.charAt(right);

    // if (charIndexMap.containsKey(currentChar)) {
    // left = Math.max(left, charIndexMap.get(currentChar) + 1);
    // }

    // charIndexMap.put(currentChar, right);
    // maxLength = Math.max(maxLength, right - left + 1);
    // }

    // return maxLength;
    // }
}
