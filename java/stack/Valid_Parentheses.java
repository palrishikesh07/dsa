import java.util.Stack;

public class Valid_Parentheses {
    public static void main(String[] args) {
        String s = "()[]{}";
        boolean result = isValid(s);
        System.out.println(result);
        
    }
    public static boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) return false; // If empty of lenght is odd ie. something is not closing

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                st.push(c);

            } else {

                if (st.isEmpty()) return false; // If closing bracket is found but stack is empty ie. no opening bracket found
                
                char top = st.pop();

                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        return st.isEmpty();
    }

}
