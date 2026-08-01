public class Max_Consecutive_Ones {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 0, 1, 1, 1 };
        int result = findMaxConsecutiveOnesSelf(nums);
        System.out.println("Result: " + result);

    }

    public static int findMaxConsecutiveOnesSelf(int[] nums) {
        int n = nums.length;
    
        int maxCount = 0;

        for (int i = 0; i < n; i++) {

            if (nums[i] == 0) {
                continue;
            }
            int iCount = 0;
            while (i < n &&  nums[i] == 1) {
                i++;
                iCount++;
            }
            maxCount = Math.max(maxCount, iCount);
        }

        return maxCount;

    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        
        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < n; i++) {

            if (nums[i] == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            }
            else{
                count=0;
            }
            
        }

        return maxCount;
    }

}
