
import java.util.HashSet;
import java.util.Set;

public class Contains_Duplicate {
    public static void main(String[] args) {
       int[] nums = {1,2,3};
    //    boolean isDuplicate = containsDuplicateOptimize(nums);
       boolean isDuplicate = containsDuplicateBruteForce(nums);
      System.out.println("isDuplicate: "+isDuplicate);
    }

     public static boolean containsDuplicateBruteForce(int[] nums) {
        int length = nums.length;
        if(length <=1){
            return false;
        }
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
     }

    public static boolean containsDuplicateOptimize(int[] nums) {
        if(nums.length <=1){
            return false;
        }
        Set<Integer>  seen_values = new HashSet<>();
        for(int num:nums){
            if(seen_values.contains(num)){
                return true;
            }
            seen_values.add(num);
        }
        return false;
    }
}
