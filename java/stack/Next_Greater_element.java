//https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;


public class Next_Greater_element {
    public static void main(String[] args) {
        // int[] arr = { 1, 3, 2, 4};
        int[] arr = { 5,5};

        // ArrayList<Integer> result = nextLargerElement(arr);
        ArrayList<Integer> result = nextLargerElementMonotonicStack(arr);
        // ArrayList<Integer> result = nextLargerElementBruteForce(arr);
        System.out.println(result);
    }

  



//  we are traversing array from back, as for more warmer temperature it works as greater then current temperature
// through monotonic stack with back traversing we can get index of next warmer temperature

// when traversing if stack empty then no warmer temperature than current so 0 days

// if stack not empty we check if top element in stack is greater than current temperature then pop that temperature continue this till stack get empty or we get greater than current temperature.

// then top will be idx of warmer temperature
// days = warmer temp. idx - current idx


 public static ArrayList<Integer> nextLargerElementBruteForce(int[] arr) {
      int n  = arr.length;
     ArrayList<Integer> result  = new ArrayList<>();
     for(int i=0; i<n; i++){
            int firstNumber = arr[i];
            int secondNumber= -1;

        for(int j=i+1; j<n;j++){
            
            if(firstNumber < arr[j]){
                secondNumber = arr[j];
                break;
            }
        }
        result.add(secondNumber);
     }


     return result;
 }

    public static ArrayList<Integer> nextLargerElementMonotonicStack(int[] arr) {
        int n  = arr.length;
        ArrayList<Integer> result  = new ArrayList<>();
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

         
        for(int i=n-1; i>=0; i--){

            while (!st.isEmpty() && st.peek() <= arr[i] ) {

                st.pop();
            }

            // 
            if(st.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = st.peek();
            }
            st.add(arr[i]);
        }

        for (int num : ans) {
            result.add(num);
        }
        return result;
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
