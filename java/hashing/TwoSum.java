
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        // int[] result = twoSum(nums, target);
        int[] result = twoSumMap(nums, target);
        System.out.println("result: " + Arrays.toString(result));

    }

    public static int[] twoSumTwoPointer(int[] nums, int target) {

        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            if (nums[left] + nums[right] < target) {
                right--;
            } else if (nums[left] + nums[right] > target) {
                left++;
            } else {
                return new int[] { right, left };
            }

        }

        return new int[] {};
    }

    public static int[] twoSumMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}
