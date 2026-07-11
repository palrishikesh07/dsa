
//https://leetcode.com/problems/sort-array-by-parity/description/
public class Sort-array-by-parity {
    
}



class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int fix_pointer = 0;
        for(int i = 0;i < nums.length ;i++) {
            if(nums[i] % 2 == 0) {
                int temp = nums[fix_pointer];
                nums[fix_pointer] = nums[i];
                nums[i] = temp;
                fix_pointer++;
            }
        }
        return nums;
    }
}