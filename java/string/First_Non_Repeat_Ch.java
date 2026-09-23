/*
Input:
"swiss"

Output:
"w"
*/

import java.util.HashMap;
import java.util.Map;

public class First_Non_Repeat_Ch {
    public static void main(String[] args) {
        String s = "swiss";
        Solution solution = new Solution();
        System.out.println("Result: "+solution.getFirstNonRepeatChar(s));
    }
    
}

class Solution{
    public String getFirstNonRepeatChar(String s){
        int n = s.length();
        Map<Character,Integer> freqMap = new HashMap<>();
        
        for(int i=0; i<n; i++){
            int freqValue = freqMap.getOrDefault(s.charAt(i), 0);
            freqMap.put(s.charAt(i), freqValue +1);
        }
        System.out.println(freqMap);
        
        for(char ch: s.toCharArray()){
            if(freqMap.get(ch) == 1){
                return  String.valueOf(ch);
            }
        }

        return null;

    }
}
