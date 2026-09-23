import java.util.HashSet;

class C_14_Longest_Substring_Without_Repeating_Char {

    public static void main(String[] args) {

        String s = "abcdabcbb";
        // BruteForceSolution bruteForceSolution = new BruteForceSolution();
        // System.out.println(bruteForceSolution.lengthOfLongestSubstring(s));
        // SlidingWindowHashSet slidingWindowHashSet = new SlidingWindowHashSet();
        // System.out.println(slidingWindowHashSet.lengthOfLongestSubstring(s));
        Test test = new  Test();
        System.out.println(test.lengthOfLongestSubstring(s));

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
// set = a,b,c
//       1,
// Left = 3-1+1= 3, 4-2+1=3, 5-3+1=3,  
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



class Test{
     public int lengthOfLongestSubstring(String s) {
        // String s = "abcdabcbb";
        int n = s.length();
        int left = 0;
        int maxLength = 0;
        HashSet<Character> set = new HashSet<>();

        for(int right=0; right<n; right++){
            char ch = s.charAt(right); // Current character

            // System.out.println("Current character: " + ch + ", Left pointer: " + left + ", Right pointer: " + right);
           while (set.contains(ch)) { // Duplicate found
            // System.out.println("Duplicate found: " + ch + ", Removing character: " + s.charAt(left) + " from set");
            set.remove(s.charAt(left)); // Remove the leftmost character from the set
            left++; // Move the left pointer to the right
           }
            set.add(ch);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
     }
}