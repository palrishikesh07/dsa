public class Longest_sub_array_sum_k {
    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;
        int length = longestSubarraySumK(nums, k);
        System.out.println("length: "+length);
    }

    public static int longestSubarraySumK(int[] nums, int k) {
        int length = nums.length;
        int maxLength = 0;
        for(int i=0; i<length; i++){
            int sum = 0;
            for(int j=i; j<length; j++){
                sum += nums[j];
                if(sum == k){
                    maxLength = Math.max(maxLength, j-i+1);
                }
            }
        }
        return maxLength;
    }

    
}
