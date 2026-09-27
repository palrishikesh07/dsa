//Two Pointers

import java.util.Arrays;

public class C_11_Two_Sum_2_Sorted {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 26;
        // BruteForceSolution bruteForceSolution = new BruteForceSolution();
        // int[] result = bruteForceSolution.twoSum(nums, target);
        // System.out.println("Indices: " + result[0] + ", " + result[1]);


        TwoPointerSolution twoPointerSolution = new TwoPointerSolution();
        int[] result = twoPointerSolution.twoSum(nums, target);
        // System.out.println("Indices: " + result[0] + ", " + result[1]);
        System.out.println(Arrays.toString(result));

    }
}


class BruteForceSolution{
    public  int[] twoSum(int[] nums, int target){
        int n = nums.length;

        for(int i=0;i< n; i++){
            
            for(int j=i+1; j<n; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        
        return  new int[]{};
    }
}


class TwoPointerSolution{
    public int[] twoSum(int[] nums, int target){
        int n = nums.length;

        int left = 0;
        int right= n-1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if(sum < target){
                left++;
            }
            else if(sum > target){
                right--;
            }
            else{
                return new int[] {left,right};
            }
        }
        return  new int[]{};
    }
}