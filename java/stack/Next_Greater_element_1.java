import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Next_Greater_element_1 {
    public static void main(String[] args) {

        // int[] nums1 = {4,1,2};
        int[] nums1 = { 4, 1, 2 };
        // int[] nums2 = {1,3,4,2};
        int[] nums2 = { 1, 3, 4, 2 };

        Next_Greater_element_1 obj = new Next_Greater_element_1();
        // int[] result = obj.nextGreaterElementBruteForce(nums1, nums2);
        int[] result = obj.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result));

    }

    public int[] nextGreaterElementBruteForce(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] ans = new int[n1];

        for (int i = 0; i < n1; i++) {
            ans[i] = -1;
            boolean findNextValue = false;

            for (int j = 0; j < n2; j++) {

                if (nums1[i] == nums2[j]) {
                    findNextValue = true;
                }

                if (findNextValue && nums2[j] > nums1[i]) {
                    ans[i] = nums2[j];
                    break;
                }
            }
        }

        return ans;
    }


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        // I will take next greater value from array 2 and store in hashmap with key as current array value and value pair as next greater element

        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        //for now add in array to check value
        // int[] sampleResult = new int[n2];

        for(int i= n2-1; i>=0; i--){

            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }

            if(st.isEmpty()){
                // sampleResult[i] = -1;
                map.put(nums2[i], -1);
            }
            else{
                //  sampleResult[i] = st.peek();
                map.put(nums2[i],  st.peek());

            }
            st.add(nums2[i]);
        }

        // System.out.println(Arrays.toString(sampleResult));
        // return sampleResult;

        int[] ans = new int[n1];

        for(int i=0;i<n1; i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;

    }

}
