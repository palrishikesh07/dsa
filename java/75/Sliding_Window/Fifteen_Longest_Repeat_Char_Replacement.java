public class Fifteen_Longest_Repeat_Char_Replacement {
    /*
     * s = "AABABBA"
     * k = 1
     */
    public static void main(String[] args) {

        String s = "AABABBA";
        Solution solution = new Solution();
        System.out.println(solution.characterReplacement(s, 1));

    }

}


class Solution {

    public int characterReplacement(String s, int k) {

        int[] frequency = new int[26];

        int left = 0;
        int maxFrequency = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            frequency[ch - 'A']++;

            // Most frequent character in current window
            maxFrequency = Math.max(
                maxFrequency,
                frequency[ch - 'A']
            );

            int windowLength = right - left + 1;

            int replacements =
                windowLength - maxFrequency;

            // Window is invalid
            while (replacements > k) {

                char leftChar = s.charAt(left);

                frequency[leftChar - 'A']--;

                left++;

                windowLength = right - left + 1;

                replacements =
                    windowLength - maxFrequency;
            }

            maxLength = Math.max(
                maxLength,
                windowLength
            );
        }

        return maxLength;
    }
}

//Sixteen_Minimum_Window_Substring