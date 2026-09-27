import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//HashMap

public class C_01_Two_Sum {

    public static void main(String[] args) {

        int nums[] = { 2, 7, 11, 15 };
        int target = 18;

        // BruteForceApproach bruteForceApproach = new BruteForceApproach();
        // int[] result = bruteForceApproach.twoSum(nums, target);
        // System.out.println(Arrays.toString(result));

        HashMapApproach hashMapApproach = new HashMapApproach();
        int[] result = hashMapApproach.twoSum(nums, target);
        System.out.println(Arrays.toString(result));

    }
}

class BruteForceApproach {

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }

        }
        return new int[] {};
    }
}

// Using HashMap

class HashMapApproach {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int compliment = target - nums[i];

            if (map.containsKey(compliment)) {
                return new int[] { map.get(compliment), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }

}