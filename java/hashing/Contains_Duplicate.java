
import java.util.HashSet;
import java.util.Set;

public class Contains_Duplicate {
    public static void main(String[] args) {
       int[] nums = {1,2,3};
       boolean isDuplicate = containsDuplicateOptimize(nums);
      System.out.println("isDuplicate: "+isDuplicate);
    }

    public static boolean containsDuplicateOptimize(int[] nums) {
        
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
