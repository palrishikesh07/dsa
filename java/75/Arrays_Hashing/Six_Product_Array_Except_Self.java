
//Prefix/Suffix

import java.util.Arrays;

public class Six_Product_Array_Except_Self {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        // BruteForceApproach bruteForceApproach = new BruteForceApproach();
        // int[] result = bruteForceApproach.productItSelf(nums);  


        // PrefixSuffix prefixSuffix = new PrefixSuffix();
        // int[] result = prefixSuffix.productItSelf(nums);

        LeftRightCenter leftRightCenter = new LeftRightCenter();
        int[] result = leftRightCenter.productItSelf(nums);

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



// Medium
 //       int nums[] = {1,2,3,4};
class LeftRightCenter{
    public int [] productItSelf(int[] nums){
        int n=nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        for(int i=1;i<n; i++){
            left[i] = left[i-1] * nums[i-1];
        }
        System.out.println(Arrays.toString(left));

        right[n-1]=1;
        for(int i=n-2; i>=0; i--){
            right[i] = right[i+1] * nums[i+1];

        }
        System.out.println(Arrays.toString(right));

        int[] ans = new int[n];

        for(int i=0; i<n;i++){
            ans[i] = left[i]* right[i];
        }
        return  ans;
    }
}


// Hard

class PrefixSuffix{
    
    public int[] productItSelf(int[] nums){
        int n=nums.length;
        int[] result = new int[n];

        // Prefix product

        int prefix=1;

        for(int i=0;i<n; i++){

            result[i] = prefix;

            prefix *= nums[i];
        }

        System.out.println("Result 1"+Arrays.toString(result));

        // Suffix product
        int suffix= 1;

        for(int i=n-1;i>=0;i--){
            result[i] *=suffix;
            suffix *=nums[i];
        }
        System.out.println("Result 2"+Arrays.toString(result));


        return  result;
    }
}