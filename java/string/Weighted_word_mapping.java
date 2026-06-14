public class Weighted_word_mapping {
    public static void main(String[] args) {
        String[] words = { "abcd", "def", "xyz" };
        int[] weights = new int[] { 5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2 };

    }

    public static String mapWordWeights(String[] words, int[] weights) {
        String res = "";

        for (String w : words) {
            int sum = 0;
            for (char c : w.toCharArray()) {
                sum += weights[c - 'a'];
            }
            
            char ch = (char) ('z' - (sum % 26));
            res += ch;
        }

        return res;
    }
}
