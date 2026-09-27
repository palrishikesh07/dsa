//https://leetcode.com/problems/generate-parentheses/description/

import java.util.ArrayList;
import java.util.List;

public class C_20_Generate_Parentheses {
    public static void main(String[] args) {
        
    }
}

class BruteForce{
    public List<String> generateParanethesis(int n){
        List<String> result = new ArrayList<>();

        generate("",2*n, result);

        return  result;
    }

    private void generate(String current, int length, List<String> result){

        if(current.length() == length){
            if(isValid(current)){
                result.add(current);
            }
            return;
        }

        generate(current+"(", length, result);
        generate(current+")", length, result);
    }

    private boolean isValid(String s){
        int balance = 0;
        for(char c: s.toCharArray()){

            if(c == '('){
                balance++;
            }
            else{
                balance--;
            }

            if(balance < 0){
                return false;
            }
        }
        return balance == 0;
    }
}



class BacktrackingSolution {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        backtrack(
            "",
            0,
            0,
            n,
            result
        );

        return result;
    }

    private void backtrack(
        String current,
        int open,
        int close,
        int n,
        List<String> result
    ) {

        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // Add opening bracket
        if (open < n) {

            backtrack(
                current + "(",
                open + 1,
                close,
                n,
                result
            );
        }

        // Add closing bracket
        if (close < open) {

            backtrack(
                current + ")",
                open,
                close + 1,
                n,
                result
            );
        }
    }
}


/*
Complexity

Number of valid combinations is the Catalan number:

C(n) = 1/(n+1) * C(2n,n)

Interview-level complexity:

Time: O(Cn × n)
Space: O(Cn × n)

*/