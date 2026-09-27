https://www.geeksforgeeks.org/problems/longest-repeating-character-replacement/1
//https://www.youtube.com/watch?v=ExY8svHF_Eo

public class C_15_Longest_Repeat_Char_Replacement {
    /*
     * s = "AABABBA"
     * k = 1
     */
    public static void main(String[] args) {

        String s = "AABABBA";
        Solution solution = new Solution();
        System.out.println(solution.characterReplacement(s, 3));

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
            maxFrequency = Math.max( maxFrequency, frequency[ch - 'A']);


            int windowLength = right - left + 1;

            // If the windowLength - max frequency > k
            // then we need to shrink the window
            if(windowLength - maxFrequency > k){
                frequency[s.charAt(left) - 'A']--;
                left++;
            }

            windowLength  = right - left+1;
            maxLength  = Math.max(maxLength, windowLength);

        }

        return maxLength;
    }
}

