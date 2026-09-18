/*
Given:
s = "ADOBECODEBANC"
t = "ABC"

Find the smallest substring of s that contains A, B and C.
*/

import java.util.HashMap;

public class Sixteen_Minimum_Window_Substring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        SlidingWindowSolution slidingWindowSolution = new SlidingWindowSolution();
        System.out.println(slidingWindowSolution.minWindow(s, t));

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