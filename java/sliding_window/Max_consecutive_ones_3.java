public class Max_consecutive_ones_3 {
    public static void main(String[] args) {
        int[] nums = { 1, 0, 1, 1, 0,1,1,1 };
        int k = 1;
        int result = longestOnes(nums, k);
        System.out.println("Longest consecutive ones with at most " + k + " flips: " + result);
    }

    public static int longestOnes(int[] nums, int k) {
        // Left pointer of the sliding window
        int left = 0;
        // Counter for zeros in the window
        int zeroCount = 0;
        // Variable to store maximum window length
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
