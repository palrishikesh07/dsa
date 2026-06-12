
public class Left_rotate_array_by_one {
    public static void main(String[] args) {
         int[] nums = {1, 2, 3, 4, 5};
         shiftByone(nums);
        
    }

    public static void shiftByone(int[] nums){
        int temp = nums[0];
        int length = nums.length;
        for(int i=1;i<length; i++){
            nums[i-1] = nums[i];
        }
        nums[length - 1] = temp;
        for (int i = 0; i < length; i++) {
            System.out.println("new i: "+nums[i]);
        }
    }
}
