//https://leetcode.com/problems/sort-array-by-parity/description/

public class Sort-array-by-parity {
    
}



// Input: nums = [3,1,2,4]
// Output: [2,4,3,1]
// Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int fix_pointer = 0;

        for(int i = 0;i < nums.length ;i++) {

            if(nums[i] % 2 == 0) {

                // Replacing even number value with starting values and started value with even number replaced

                int temp = nums[fix_pointer];
                nums[fix_pointer] = nums[i];
                nums[i] = temp;

                fix_pointer++;
            }
        }
        return nums;
    }
}