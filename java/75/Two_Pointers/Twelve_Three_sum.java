
//Sorting + Two Pointers

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Twelve_Three_sum {
    public static void main(String[] args) {

        int[] nums = { -1, 0, 1, 2, -1, -4 };
        // BruteForceSolution bruteForceSolution = new BruteForceSolution();
        // List<List<Integer>> result = bruteForceSolution.threeSum(nums);

        SortingTwoPointerSolution sortingTwoPointerSolution = new SortingTwoPointerSolution();
        List<List<Integer>>  result = sortingTwoPointerSolution.threeSum(nums);
        System.out.println("Triplets: " + result);

    }
}

class BruteForceSolution {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                for (int k = j + 1; k < n; k++) {

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        result.add(triplet);
                    }
                }
            }
        }

        return result;
    }
}

class SortingTwoPointerSolution {
    public List<List<Integer>> threeSum(int[] nums) {
       
        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;

        // Step 1: Sort the array
        Arrays.sort(nums);
    
        
        // Step 2: Fix first number

        for(int i=0; i<n-2; i++){

            // Find other two elements
            int left = i+1;
            int right = n-1;


            while (left  <right) {
                int sum = nums[i] + nums[left] + nums[right];

                if(sum ==0 ){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                }
                else if(sum < 0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }

    
        return new ArrayList<>(result);

    }
}
