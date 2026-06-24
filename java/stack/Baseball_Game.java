import java.util.Stack;

//https://leetcode.com/problems/baseball-game/description/

public class Baseball_Game {
    public static void main(String[] args) {

        String[] operations = new String[] { "5", "2", "C", "D", "+" };
        int result = calPoints(operations);
        System.out.println(result);

    }

    public static int calPoints(String[] operations) {

        Stack<Integer> st = new Stack<>();

        for (String op : operations) {
            if (op.equals("+")) {
                int top = st.pop();
                int newScore = top + st.peek(); // Just taking value not remoing from stack

                st.push(top); // Push value taken from top
                st.push(newScore);

            } else if (op.equals("D")) {
                int doubleValue = 2 * st.peek();
                st.push(doubleValue);
            } else if (op.equals("C")) {
                st.pop();
            } else {
                st.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        while (!st.isEmpty()) {
            sum += st.pop();
        }
        
        return sum;
    }

}
