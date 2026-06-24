//https://leetcode.com/problems/daily-temperatures/description/

import java.util.Arrays;

public class Daily_Temperatures {

    public static void main(String[] args) {
        int[] arr = {73,74,75,71,69,72,76,73};
        int[] result = dailyTemperatures(arr);
        System.out.println("Result: "+ Arrays.toString(result));
        // System.out.println("[" + String.join(", ", java.util.Arrays.stream(result).mapToObj(String::valueOf).toArray(String[]::new)) + "]");
        
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                
                if(temperatures[j] > temperatures[i]){
                    result[i] = j-i;
                    break;
                }
            }
        }
        return result;

    }
    
}
