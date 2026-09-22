import java.util.Stack;

public class C_17_Valid_Parentheses {
    public static void main(String[] args) {
        String s = "([]){}";
        Solution solution = new Solution();
        System.out.println(solution.isValid(s) ? "Valid " : "Not valid");
        
    }
}

class Solution{

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()){
            if(ch == '(' || ch =='{' || ch == '['){
                stack.push(ch);
            }
            else{

                if(stack.isEmpty()){
                    return false;
                }

                char topValue = stack.pop();
                if(ch == ')' && topValue != '(' || ch =='}' && topValue !='{' || ch == ']' && topValue !='['){
                    return false;
                }
            }
        }

        return  true;

    }

}