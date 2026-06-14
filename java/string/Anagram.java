import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        boolean isAnag = isAnagramUpdated(s, t);
        if (isAnag) {
            System.out.println("This is anagram");
        } else {
            System.out.println("This is not an anagram");
        }
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        Arrays.sort(chs);
        Arrays.sort(cht);
        return Arrays.equals(chs, cht);
    
    }


    public static boolean isAnagramUpdated(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        s = s.toLowerCase();
        t = t.toLowerCase();

        // Strip of all white space
        s = s.replace(" ", "");
        t = t.replace(" ", "");
        
        // Intialize bucket
        int[] bucket = new int[26];

        // Fill the bucket
        for(int i=0;i<s.length(); i++){
            // System.out.println(s.charAt(i));
            // System.out.println(s.charAt(i)-'a');
            int bucketPosition = s.charAt(i) - 'a';
            bucket[bucketPosition]++;
        }

        //Empty bucket
        for(int i=0;i<t.length(); i++){
            int bucketPosition = t.charAt(i)-'a';
            bucket[bucketPosition]--;
        }

        // Check if all bucket is empty
        for(int singleBucketValue: bucket){
            if(singleBucketValue != 0){
                return false;
            }
        }

        return true;
    }
}
