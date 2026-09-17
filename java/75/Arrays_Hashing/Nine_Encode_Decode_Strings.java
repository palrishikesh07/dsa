//String/Array

import java.util.ArrayList;
import java.util.List;

public class Nine_Encode_Decode_Strings {
    public static void main(String[] args) {

        List<String> strs = new ArrayList<>();
        strs.add("Hello");
        strs.add("World");
        strs.add("This is a test");

        Solution solution = new Solution();
        String encoded = solution.encode(strs);
        System.out.println("Encoded: " + encoded);

        List<String> decoded = solution.decode(encoded);
        System.out.println("Decoded: " + decoded);  
        
    }
}

class Solution {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        System.out.println("Encoded String: " + sb.toString());
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') {
                j++;
            }
            System.out.println("i: " + i + " j: " + j + " s.charAt(j): " + s.charAt(j)+ " s.substring(i, j): " + s.substring(i, j));
            int length = Integer.parseInt(s.substring(i, j));
            res.add(s.substring(j + 1, j + 1 + length));
            i = j + 1 + length;
        }
        return res;
    }
}   


