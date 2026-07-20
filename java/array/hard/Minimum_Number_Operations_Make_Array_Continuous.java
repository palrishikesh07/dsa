//https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/submissions/2073654353/
import java.util.Arrays;

public class Minimum_Number_Operations_Make_Array_Continuous {
    public static void main(String[] args) {
        // int[] arr = {4,2,5,3};
        // int[] arr = {1,2,3,5,6};
        // int[] arr = {1,10,100,1000};
        int[] arr = {8,5,9,9,8,4};
        int result = minOperations(arr);
        System.out.println("Result is "+result);
        
    }

    public static int minOperations(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int n = nums.length;

        //Remove duplicates
        int[] unique = new int[n];

        int m=0;

        for(int num:nums){
            if(m==0 || unique[m-1] != num){
                unique[m++]=num;
            }
        }
    // System.out.println(Arrays.toString(unique));

        int maxKeep = 0;
        int left = 0;


        // Sliding window
        for (int right = 0; right < m; right++) {

            while (unique[right] - unique[left] >= n) {
                left++;
            }

            maxKeep = Math.max(maxKeep, right - left + 1);
        }

        return n - maxKeep;


    }
}
