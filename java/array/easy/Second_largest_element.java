
public class Second_largest_element {
    public static void main(String[] args) {
        //  int[] nums = {3, 3, 6, 1};
         int[] nums = {3, 3, 0, 99, -40,99};
         int largestElement = findSecondLargestElement(nums);
         System.out.println("Largest Element "+largestElement);
    }
    private static int findSecondLargestElement(int[] nums){
        int length = nums.length;
        int largestElement = nums[0];
        int secondLargestElement = Integer.MIN_VALUE;

        for (int i = 0; i < length; i++) {
            int element = nums[i];
           if(element > largestElement){
            secondLargestElement = largestElement;
            largestElement = element;
           }
           else if(element > secondLargestElement && element != largestElement){
            secondLargestElement = element;
           }
        }
        return secondLargestElement;
    }


}
