public class Maximum_average_sub_array_k {
   
   
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;
        int maxSum = findMaxSumSubArray(arr, k);
        System.out.println("Maximum sum of sub-array of size " + k + " is: " + maxSum);
    }

    public static int findMaxSumSubArray(int[] arr, int k) {
        if (arr.length < k) {
            throw new IllegalArgumentException("Array length must be greater than or equal to k");
        }

        int maxSumAverage = 0;
        // k = 2 
        for (int i = 0; i < k; i++) {
            maxSumAverage += arr[i]/k;
        }
        
        int currentSum = maxSumAverage;
        for (int i = k; i < arr.length; i++) {
            currentSum += arr[i] - arr[i - k];
            System.out.println("arr[i] - arr[i - k]"+arr[i]);
            System.out.println("arr[i] - arr[i - k]"+arr[i-k]);
            System.out.println("currentSum: "+currentSum);
            int currentSumAverage = currentSum/k;
            maxSumAverage = Math.max(maxSumAverage, currentSumAverage);
        }

        return maxSumAverage;
    }
}