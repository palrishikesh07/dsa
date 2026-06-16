// https://leetcode.com/problems/repeated-string-match/description/
public class Repeated_String_Match {
    public static void main(String[] args) {

    }

    public static int repeatedStringMatch(String a, String b) {

        String repeated = a;
        int count = 1;

        while (repeated.length() < b.length()) {
            repeated += a;
            count++;
        }

        if (repeated.contains(b)) {
            return count;
        }

        repeated += a;

        if (repeated.contains(b)) {
            return count + 1;
        }

    
        return -1;
    }

    // Time: O(n²)
    // Space: O(n)

    public  static int repeatedStringMatchOptimize(String a, String b) {

        StringBuilder sb = new StringBuilder(a);

        int count = 1;

        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        if (sb.indexOf(b) != -1) {
            return count;
        }

        sb.append(a);

        if (sb.indexOf(b) != -1) {
            return count + 1;
        }

        return -1;
    }

}
