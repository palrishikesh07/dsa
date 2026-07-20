//https://leetcode.com/problems/longest-palindromic-substring/
public class Longest_Palindromic_Substring {
    public static void main(String[] args) {
        String s = "babad";
        // String longestPalindrome = longestPalindromeBruteForce(s);
        String longestPalindrome = longestPalindromeTwoPointer(s);
        System.out.println("Longest Palindromic Substring: " + longestPalindrome);

    }

    public static String longestPalindromeBruteForce(String s) {

        int n = s.length();

        String ans = "";

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                if (isPalindrome(s, i, j)) {

                    if (j - i + 1 > ans.length()) {
                        ans = s.substring(i, j + 1);
                    }

                }
            }
        }
        return ans;
    }

    private static boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }



     public static String longestPalindromeTwoPointer(String s) {
        int n = s.length();
        if(s ==null || n < 2){
            return s;
        }

        int start = 0;
        int end = 0;

        for(int i=0; i< n; i++){
            int len1 = exapnd(s,i,i,n );
            int len2 = exapnd(s, i, i+1, n);

            int len = Math.max(len1, len2);

            if(len > end - start +1){
                start = i-(len-1)/2;
                end = i+ len/2;
            }

        }
        return s.substring(start, end+1);

     }


     private static int exapnd(String s, int left, int right, int n){
        while (left >=0 && right <n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left -1;
     }
}
