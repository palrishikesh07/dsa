
public class C_24_Binary_Search {

    public static void main(String[] args) {
        
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        BruteForce bruteForce = new BruteForce();
        System.out.println(bruteForce.search(nums, target));

        BinarySearchApproach binarySearchApproach = new BinarySearchApproach();
        System.out.println(binarySearchApproach.search(nums, target));

    }

}

class BruteForce {
    public int search(int[] nums, int target) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }
}

class BinarySearchApproach{
    public  int search(int[] nums, int target){
        int n = nums.length;

        int left = 0;
        int right = n-1;

        while (left < right) {
            
           int mid = left + (right - left)/2;

           if(nums[mid] < target){
            left = mid+1;
           }
           else if(nums[mid] > target){
            right = mid-1;
           }
           else{
            return mid;
           }
        }

        return -1;
    }
}

