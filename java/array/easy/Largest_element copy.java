
public class Largest_element {
    public static void main(String[] args) {
        //  int[] nums = {3, 3, 6, 1};
         int[] nums = {3, 3, 0, 99, -40};
         int largestElement = findLargestElement(nums);
         System.out.println("Largest Element "+largestElement);
    }
    private static int findLargestElement(int[] nums){
        int length = nums.length;
        int maxLement = nums[0];
        for (int i = 0; i < length; i++) {
            int element = nums[i];
            maxLement = Math.max(maxLement, element);
        }
        return maxLement;
    }


}
