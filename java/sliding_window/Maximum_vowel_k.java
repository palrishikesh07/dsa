
https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
public class Maximum_vowel_k {
    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        int vowelCount = maxVowels(s,k);
        System.out.println("vowelCount: "+vowelCount);
    }

    public static int maxVowels(String s, int k) {
        int currentVowel = 0;
        int maxVowel = 0;

        // First k window
        for(int i=0; i< k;i++){
            if(isVowel(s.charAt(i))){
                currentVowel++;
            }
        }
        maxVowel = currentVowel;
        for(int i=k;i<s.length(); i++){

            // Add next Char vowel
            if(isVowel(s.charAt(i))){
                currentVowel++;
            }
            // Remove if started/first is vowel
            if(isVowel(s.charAt(i-k))){
                currentVowel--;
            }
            maxVowel = Math.max(maxVowel,currentVowel);
        }
        return maxVowel;
    }

    private static boolean isVowel(char ch){
        char lowerCh = Character.toLowerCase(ch);
        return lowerCh == 'a' 
        || lowerCh == 'e' 
        || lowerCh == 'i' 
        || lowerCh == 'o' 
        || lowerCh == 'u';
    }
}