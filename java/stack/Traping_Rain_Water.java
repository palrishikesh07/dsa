import java.util.Stack;

//https://leetcode.com/problems/trapping-rain-water/
public class Traping_Rain_Water {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        // int result1 = trapBruteForce(arr);
        int result1 = trapPrefixSufix(arr);
        System.out.println("Result 1: " + result1);

    }

    public static int trapBruteForce(int[] height) {
        int n = height.length;
        int water = 0;
        if (height == null || n == 0)
            return 0;

        for (int i = 0; i < n; i++) {
            
            int leftMax = height[i];
            int rightMax = height[i];

            // Fine left max, Reverse order
            for (int j = i; j >0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }

            // Right max
            for (int j = i; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            water +=Math.min(leftMax, rightMax) - height[i];
            
        }
        return water;
    }


    public static int trapPrefixSufix(int[] height) {
        int n = height.length;

        if(n == 0){
            return 0;
        }

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Fill leftMax array
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }


        // Fill rightMax array
        rightMax[n-1] = height[n-1];
        for (int i = n -2 ; i >=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int totalWater = 0;

        // Calculate trapped water
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return totalWater;

    }

    //  public static int trap(int[] height) {
    //     Stack <Integer> stack = new Stack<>();

    //     int water = 0;

    //     for(int i=0; i< height.length; i++){

    //     }

    //  }

}
