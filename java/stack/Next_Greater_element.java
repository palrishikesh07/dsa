//https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


public class Next_Greater_element {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 4};

        ArrayList<Integer> result = nextLargerElement(arr);
        System.out.println(result);
    }

    public static ArrayList<Integer> nextLargerElement(int[] arr) {
        int n  = arr.length;
        ArrayList<Integer> result  = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for (int index = n-1; index >=0; index--) {
            while (!st.isEmpty() && st.peek() <= arr[index]) {
                st.pop();
            }
            result.add(st.isEmpty() ? -1 : st.peek());
            st.push(arr[index]);
        }

        Collections.reverse(result);
        return result;
    }
}
