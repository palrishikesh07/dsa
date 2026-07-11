import java.util.ArrayList;
import java.util.Stack;


public class Previous_Smallest_element {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 4 };

        ArrayList<Integer> result = previousSmallestElement(arr);
        System.out.println(result);
    }

    public static ArrayList<Integer> previousSmallestElement(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int index = 0; index < n; index++) {

            // Check peek value from stack if is less the current value, then remove from stack
            while (!st.isEmpty() && st.peek() >= arr[index]) {
                st.pop();
            }

            result.add(st.isEmpty() ? -1 : st.peek());

            st.push(arr[index]);
        }
        return result;
    }
}
