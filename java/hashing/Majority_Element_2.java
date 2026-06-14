
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/majority-element-ii/

public class Majority_Element_2 {
    public static void main(String[] args) {
        // int[] nums = { 3, 2, 3 };
        int[] nums = { 1, 2,1};

        // List<Integer> majorityElement = majorityElement(nums);
        List<Integer> majorityElement = majorityElementAllTestCases(nums);
        System.out.println("majorityElement: " + majorityElement);
    }

    // Arrays.sort(nums);
    // return nums[nums.length / 2];

    public static List<Integer> majorityElement(int[] nums) {

        if (nums == null || nums.length == 0) {
            return List.of();
        }
        int majorityThreshold = nums.length / 3;
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            int frequency = frequencyMap.getOrDefault(num, 0) + 1;
            frequencyMap.put(num, frequency);

            if (frequency > majorityThreshold) {
                return List.of(num);
            }
        }
        return List.of();
    }

    // Some test cases is not passing in above

    public static List<Integer> majorityElementAllTestCases(int[] nums) {
    int threshold = nums.length / 3;
    System.out.println("threshold: "+threshold);

    Map<Integer, Integer> frequencyMap = new HashMap<>();
    Set<Integer> result = new HashSet<>();

    for (int num : nums) {
        int frequency = frequencyMap.getOrDefault(num, 0) + 1;
        frequencyMap.put(num, frequency);

        if (frequency > threshold) {
            result.add(num);
        }
    }

    return new ArrayList<>(result);
}

}
