// https://leetcode.com/problems/daily-temperatures/description/

import java.util.Arrays;
import java.util.Stack;

public class C_21_Daily_Temperatures {
    
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        // BruteForce bruteForce = new BruteForce();
        // int[] output = bruteForce.dailTemperatures(temperatures);
        // System.out.println(Arrays.toString(output));

        MonotonicDecreasingStack monotonicDecreasingStack = new MonotonicDecreasingStack();
        int[] output = monotonicDecreasingStack.dailTemperatures(temperatures);
        System.out.println(Arrays.toString(output));
        
        
    }
}

//For every day, search forward until finding a warmer temperature.
class BruteForce{

    public  int[] dailTemperatures(int[] temperatures){
        
        int n =temperatures.length;
        int[] result = new int[n]; // Default is zero
        // Arrays.fill(result, 0); // This in case if we want some other default value
        System.out.println(Arrays.toString(result));


        for(int i=0;i<n;i++){

            for(int j=i+1; j<n; j++){

                if(temperatures[j] > temperatures[i]){
                    result[i] = j-i;
                    break;
                }
            }
        }
        
        return result;
    }

}


class MonotonicDecreasingStack{
    
    public  int[] dailTemperatures(int[] temperatures){

        int n = temperatures.length;
        int[] result = new int[n];

        Stack<Integer> stack  =new Stack<>();

        for(int i=0; i<n; i++){

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {

                  int previousIndex = stack.pop();  
                  result[previousIndex] = i - previousIndex;
            }

            stack.push(i);
        }
        return result;

    }
}
