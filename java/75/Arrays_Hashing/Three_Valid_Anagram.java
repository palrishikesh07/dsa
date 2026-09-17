
//Frequency Map

import java.util.Arrays;

public class Three_Valid_Anagram {

    public static void main(String[] args) {
    
        String s = "anagram";
        String t = "nagaram";

        // BruteForceApproach bruteForceApproach = new BruteForceApproach();
        // boolean isAnagram = bruteForceApproach.isAnagram(s,t);
        // System.out.println(isAnagram ? "Anagram" : "Not Anagram");

        FrequencyArrayApproach frequencyArrayApproach = new FrequencyArrayApproach();
        boolean isAnagram = frequencyArrayApproach.isAnagram(s,t);
        System.out.println(isAnagram ? "Anagram" : "Not Anagram");
        
    }
    
}


class BruteForceApproach{

    boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return  false;

        char a[] = s.toCharArray();
        char b[] = t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return  Arrays.equals(a, b);

    }

}

class FrequencyArrayApproach{

    boolean isAnagram(String s, String t){

        if(s.length() != t.length()) return  false;

        int count[] = new int[26];

        int n = s.length();

        for(int i=0;i < n; i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        System.out.println(Arrays.toString(count));
        for(int value: count){
            if(value != 0) return false;
        }   


        return true;
    }
}

/*
Time:  O(n)
Space: O(1)
*/
