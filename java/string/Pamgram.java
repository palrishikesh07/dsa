public class Pamgram {
    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        boolean isPangram = checkIfPangram(sentence);
        System.out.println("Is the sentence a pangram? " + isPangram);
    }

    public static boolean checkIfPangram(String sentence) {
        // String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] ch = sentence.toCharArray();
        if(ch.length != 26){
            return false;
        }
        // for(int i=0; i < alphabet.length(); i++){
        //     if(!alphabet.contains(String.valueOf(ch))){
        //         return false;
        //     }
            // if(!sentence.contains(String.valueOf(alphabet.charAt(i)))){
            //     return false;
            // }
        // }
        boolean[] seen = new boolean[26];
        for(int i=0; i <=25; i++){
            if(Character.isLetter(ch[i])){
                int index = Character.toLowerCase(ch[i]) - 'a';
                seen[index] = true;
            }
        }
        for(boolean letterSeen : seen){
            if(!letterSeen){
                return false;
            }
        }

        return true;
    }
}




class Solution {
    public boolean checkIfPangram(String sentence) {
        
        if(sentence.length() < 26) return false;

        boolean[] seen = new boolean[26];

        for(char ch : sentence.toCharArray()) {

            if(ch >= 'a' && ch <= 'z') {

                seen[ch - 'a'] = true;
            }
        }

        for(boolean alpha : seen) {

            if(!alpha) return false;
        }
        return true;
    }
}