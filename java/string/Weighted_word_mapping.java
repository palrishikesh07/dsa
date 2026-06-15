
//https://leetcode.com/problems/weighted-word-mapping/description/
public class Weighted_word_mapping {
    public static void main(String[] args) {
        String[] words = { "abcd", "def", "xyz" };
        int[] weights = new int[] { 5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2 };
        String s  = mapWordWeights(words, weights);
        System.out.println("S: "+s);
    }

    public static String mapWordWeights(String[] words, int[] weights) {
       StringBuilder ans = new StringBuilder();
       for(String word: words){

        int sum = 0;
        for(char ch: word.toCharArray()){
            // System.out.println("ch-'a': "+ch);
            // System.out.println("ch-'a': "+(ch-'a'));
            sum +=weights[ch-'a'];
        }
        int mod = sum%26;
        // Reverse mapping
        System.out.println("mod: "+mod);
        // char mapped = (char)('a'+mod); // If it was noraml aplahbet instead of reverse
        char mapped = (char)('z'-mod);
        ans.append(mapped);
       }
       return ans.toString();
    }
}
