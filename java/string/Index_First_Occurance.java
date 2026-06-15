
//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
public class Index_First_Occurance {
    public static void main(String[] args) {
        String haystack = "asadbutsad", needle = "sad";
        // int strPosition = strStr(haystack, needle);
        int strPosition = strStrBruteForce(haystack, needle);
        System.out.println("Str Position: " + strPosition);
    }

    public static int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1 ; i++) {
                if(haystack.charAt(i) == needle.charAt(0)){

                    if(haystack.substring(i, needle.length()+i).equals(needle)){
                        return i;
                    }
                }
        }
        return -1;
    }

     public static int strStrBruteForce(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {

            int j = 0;

            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == m) {
                return i;
            }
        }

        return -1;
    }
}
