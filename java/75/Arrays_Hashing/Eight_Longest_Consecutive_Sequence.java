//HashSet

import java.util.HashSet;
import java.util.Set;

public class Eight_Longest_Consecutive_Sequence {
    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2, 5 };
        int[] nums1 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };

        // BruteForce bruteForce = new BruteForce();
        // System.out.println(bruteForce.longestConsecutive(nums));
        // System.out.println(bruteForce.longestConsecutive(nums1));


        HashSetSolution hashSetSolution = new HashSetSolution();
        System.out.println(hashSetSolution.longestConsecutive(nums));
    
    }
}

class BruteForce {
    public int longestConsecutive(int[] nums) {
        int longest = 0;

        for (int num : nums) {

            int current = num;
            int length = 1;

            // System.out.println("num: " + num + " current: " + current + " length: " +
            // length);
            while (contains(nums, current + 1)) {
                current++;
                length++;
            }
            // System.out.println("----current: " + current + " length: " + length + "
            // longest: " + longest);

            longest = Math.max(longest, length);
        }
        return longest;

    }

    // Scan the array to see if it contains the target number
    private boolean contains(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }

        return false;
    }
}

class HashSetSolution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        System.out.println("set" + set);

        int longest = 0;
        // Iterate through the set and check if the current number is the start of a sequence
        for (int num : set) {
            if (!set.contains(num-1)) { // If the set does not contain the previous number, then this is the start of a sequence    
                int currentNum = num;
                int length = 1;
                
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    length++;
                }
                System.out.println("currentNum: " + currentNum + " length: " + length + " longest: " + longest);
                longest = Math.max(longest, length);
            }
        }   
        return longest;
    }

}