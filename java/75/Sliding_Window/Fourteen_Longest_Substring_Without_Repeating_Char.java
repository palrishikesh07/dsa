import java.util.HashSet;

class Fourteen_Longest_Substring_Without_Repeating_Char {

    public static void main(String[] args) {

        String s = "abcabcbb";
        // BruteForceSolution bruteForceSolution = new BruteForceSolution();
        // System.out.println(bruteForceSolution.lengthOfLongestSubstring(s));
        SlidingWindowHashSet slidingWindowHashSet = new SlidingWindowHashSet();
        System.out.println(slidingWindowHashSet.lengthOfLongestSubstring(s));

    }

}

// Generate every substring and check whether it contains duplicate characters.
class BruteForceSolution {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int n = s.length();

        // String s = "abcabcbb";
        for (int i = 0; i < n; i++) {

            HashSet<Character> set = new HashSet<>();

            for (int j = i; j < n; j++) {

                char ch = s.charAt(j);

                // Duplicate found
                if (set.contains(ch)) {
                    break;
                }

                set.add(ch);
                maxLength = Math.max(maxLength, j - i + 1);

            }
        }

        return maxLength;
    }
}

class SlidingWindowHashSet {

    // String s = "abcabcbb";
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;
        int n = s.length();

        for (int right = 0; right < n; right++) {

            char ch = s.charAt(right);

            // Duplicate found

            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return  maxLength;
    }

}