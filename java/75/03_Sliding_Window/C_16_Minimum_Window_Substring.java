//https://leetcode.com/problems/minimum-window-substring/description/
// https://www.youtube.com/watch?v=SdeaOYoPhIs
/*
Given:
s = "ADOBECODEBANC"
t = "ABC"

Find the smallest substring of s that contains A, B and C.
*/

import java.util.HashMap;

public class C_16_Minimum_Window_Substring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        SlidingWindowTwoPointer slidingWindowTwoPointer = new SlidingWindowTwoPointer();
        System.out.println(slidingWindowTwoPointer.minWindow(s, t));

    }
}

// Prefer this once more time
class SlidingWindowTwoPointer {
    public String minWindow(String s, String t) {
        int n = s.length();
        int[] mapS = new int[256];
        int[] mapT = new int[256];

        // Count characters required from t
        for (char ch : t.toCharArray()) {
            mapT[ch]++;
        }

        int left = 0;
        int right = 0;

        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        // Expand the window using right pointer
        for (; right < n; right++) {
            mapS[s.charAt(right)]++;

            // Current window contains all required characters
            while (contains(mapS,mapT)) {
                 // Update minimum window
                 if(right - left + 1 <minLen){
                    minLen = right - left +1;
                    minStart = left;
                 }

                 // Remove left character
                 mapS[s.charAt(left)]--;
                 left++;
            }
        }
         // No valid window found
         return minLen == Integer.MIN_VALUE ? "" : s.substring(minStart,minStart+ minLen);

    }

    private boolean contains(int[] mapS, int[] mapT){
        for(int i=0; i<256; i++){
            if(mapT[i]>mapS[i]){
                return false;
            }
        }
        return true;
    }
}

// #Does it contain all characters of t? update minium

class SlidingWindowSolution {

    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        // Characters required from t
        HashMap<Character, Integer> need = new HashMap<>();

        for (char ch : t.toCharArray()) {

            need.put(
                    ch,
                    need.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0;

        // Number of required characters satisfied
        int formed = 0;

        int required = need.size();

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // Add current character
            window.put(
                    ch,
                    window.getOrDefault(ch, 0) + 1);

            // Character requirement satisfied
            if (need.containsKey(ch)
                    && window.get(ch).intValue() == need.get(ch).intValue()) {

                formed++;
            }

            // Window is valid
            while (formed == required) {

                // Update minimum window
                int windowLength = right - left + 1;

                if (windowLength < minLength) {

                    minLength = windowLength;
                    start = left;
                }

                // Remove left character
                char leftChar = s.charAt(left);

                window.put(
                        leftChar,
                        window.get(leftChar) - 1);

                // Window becomes invalid
                if (need.containsKey(leftChar)
                        && window.get(leftChar) < need.get(leftChar)) {

                    formed--;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(
                start,
                start + minLength);
    }
}