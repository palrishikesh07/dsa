//Two Pointers
public class Eleven_Two_Sum_2_Sorted {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 26;
        BruteForceSolution bruteForceSolution = new BruteForceSolution();
        int[] result = bruteForceSolution.twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}


class BruteForceSolution{
    public  int[] twoSum(int[] nums, int target){
        int n = nums.length;

        for(int i=0;i< n; i++){
            
            for(int j=i+1; j<n; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i+1,j+1};
                }
            }
        }
        
        return  new int[]{};
    }
}
