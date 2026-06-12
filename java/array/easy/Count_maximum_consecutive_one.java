public class Count_maximum_consecutive_one {
    public static void main(String[] args) {
          int[] nums = {1, 1, 0, 1, 1, 0,1};
        int maxNumber = findMaxConsecutiveOnes(nums);
        System.out.println("maxNumber: "+maxNumber);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int length = nums.length;
        int maxOne = 0;
        int counter = 0;
        for(int i=0;i<length; i++){
            if(nums[i] ==1){
                counter++;
            }
            else{
                counter=0;
            }
            
            maxOne = Math.max(maxOne,counter);
        }
        return maxOne;
    }
}
