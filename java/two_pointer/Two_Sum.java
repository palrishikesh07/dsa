import java.util.Arrays;

class Two_Sum {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 4 };
        int target = 6;
        int[] result = twoSum(nums, target);
        // System.out.println(result.toString());
        System.out.println("result: [" + result[0] + ", " + result[1] + "]");
        System.out.println(Arrays.toString(result));

    }

    public static int[] twoSum(int[] nums, int target) {
        // Sorted array is required for two pointer approach
        Arrays.sort(nums);
        int length = nums.length;
        int left = 0;
        int right = length - 1;

        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                return new int[] { left, right };
            }
        }
        return new int[] { -1, -1 }; // Return an invalid index if no solution is found
    }
}