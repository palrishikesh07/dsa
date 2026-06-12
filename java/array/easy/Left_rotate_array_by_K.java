
public class Left_rotate_array_by_K {
    public static void main(String[] args) {
         int[] nums = {1, 2, 3, 4, 5};
         int k=2;
         shiftByK(nums,k);
          for (int num : nums) {
            System.out.print(num + " ");
        }
        
    }

    public static void shiftByK(int[] nums, int k){
        int n = nums.length;
        k = k%n;
        reverse(nums, 0, n-1); // 54321
        reverse(nums, 0, k-1); //  45321
        reverse(nums, k, n-1);     // 45 123

    }

    private static void reverse(int[] nums, int left, int right){
        while (left < right) {
            int temp  = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
