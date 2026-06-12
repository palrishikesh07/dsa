public class Find_number_once_other_twice {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1,1,3,3,4};
        int number = singleNumber(nums);
        System.out.println("number: "+number);
    }

    public static int singleNumber(int[] nums) {
        int length = nums.length;
        int xorr = 0;
        for(int i=0; i<length; i++){
            xorr ^= nums[i];
        }
        return xorr;
    }
}
