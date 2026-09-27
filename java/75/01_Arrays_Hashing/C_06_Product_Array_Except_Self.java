
//Prefix/Suffix

import java.util.Arrays;

public class C_06_Product_Array_Except_Self {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        // BruteForceApproach bruteForceApproach = new BruteForceApproach();
        // int[] result = bruteForceApproach.productItSelf(nums);  

        PrefixSuffix prefixSuffix = new PrefixSuffix();
        int[] result = prefixSuffix.productItSelf(nums);

        System.out.println("Result: " + Arrays.toString(result));
        
    }
}

class BruteForceApproach{

    public  int[] productItSelf(int[] nums){
        int n = nums.length;
        int[] result = new int[n];

        for(int i=0;i <n;i++){
            
            int product = 1;
            for(int j=0; j<n; j++){
                if( i!= j){
                    product *=nums[j]; // J as j is moving forward
                }
            }

            result[i] = product;
        }

        return  result;

    }
}


class PrefixSuffix{
    public  int[] productItSelf(int[] nums){

        int n = nums.length;
       
         // Product of elements to the LEFT
         int[] left = new int[n];
         left[0]=1;
         
         for(int i=1; i<n; i++){
            left[i] = left[i-1] * nums[i-1];
         }

         // Product of elements to the RIGHT
         int[] right = new int[n];
         right[n-1] = 1;
         
         for(int i=n-2;i>=0;i--){
            right[i] = right[i+1] * nums[i+1];
         }

         // Left * right;

         int[] ans = new int[n];

         for(int i=0;i<n;i++){
            ans[i] = left[i] *right[i];
         }
     
         return ans;
        
    }
}