import java.util.HashSet;
import java.util.Set;

public class Remove_duplicate_from_sorted_array {
    public static void main(String[] args) {
         int[] nums = {0,0,1,1,1,2,2,3,3,4};
        //  int k = removeDuplicateBruteForce(nums);
         int k = removeDuplicateOptimal(nums);
         System.out.println("K: "+k);
            for (int i = 0; i < k; i++) {
                System.out.print(nums[i]+" ");
            }

    }
    public static int removeDuplicateBruteForce(int[] nums){
        Set<Integer> seen = new HashSet<>();
        int length = nums.length;
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (!seen.contains(nums[i])) {
                seen.add(nums[i]);
                nums[index] = nums[i];
                index++;

            }
        }
        return index;
    }


    public static int removeDuplicateOptimal(int[] nums){
        int length = nums.length;
        if(length == 0) return 0;
        int i=0;
        for(int j=1;j < length; j++){

            if(nums[i] != nums[j]){
                i++;
                nums[i]= nums[j];
            }
        }
        return i+1;
    }
}
