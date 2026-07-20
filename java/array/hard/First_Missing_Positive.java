public class First_Missing_Positive {
    public static void main(String[] args) {

        // int[] nums = {1,2,0};
        int[] nums = {1,2,7,8,9,11,12};
        int result = firstMissingPositive(nums);
        System.out.println("First Missing Positive: " + result);

    }

    public static int firstMissingPositive(int[] nums) {

        int n = nums.length;

        for(int i =1; i<=n; i++){
            boolean found = false;

            for(int num: nums){

                if(num == i){
                    found = true;
                    break;
                }
            }

            if(found == false){
                return i;
            }
        }
        
        return n+1;
    }

    public static int firstMissingPositiveOptimal(int[] nums) {
        int n = nums.length;
        int i=0;

        while (i<n) {
            int correct = nums[i] - 1;
            
            if(nums[i] > 0 && nums[i] <= n && nums[i] != nums[correct]){

                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }
            else{
                i++;
            }
        }

        for(i=0;i<n; i++){
           if(nums[i] != i+1){
            return i+1;
           } 
        }

        return n+1;
    }
}
