//https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
import java.util.Stack;

public class C_19_Evaluate_Reverse_Polish_Notation {
    public static void main(String[] args) {
        OptimalOperandStack optimalOperandStack = new OptimalOperandStack();
        String[] tokens = {"2", "1", "+", "3", "*"};
        int result = optimalOperandStack.evalRPN(tokens);
        System.out.println("Result: " + result); // Output: Result: 9
        
    }
}

class OptimalOperandStack{
    
    public int evalRPN(String[] tokens){
        Stack<Integer> stack = new Stack<>();

        for(String token: tokens){

            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int b = stack.pop();
                int a = stack.pop();

                int result  = 0;

                switch (token) {
                    case "+":
                        result = a+b;
                        break;
                    case "-":
                        result = a-b;
                        break;
                    case "*":
                        result = a*b;
                        break;
                    case "/":
                        result = a/b;
                        break;
                }

                stack.push(result);
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }
        return  stack.pop();
    }
    
}