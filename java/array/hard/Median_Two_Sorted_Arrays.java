import java.util.Arrays;

public class Median_Two_Sorted_Arrays {
    public static void main(String[] args) {
        // int[] nums1 = { 1, 3 };
        // int[] nums2 = { 2 };
        int[] nums1 = { 1, 2 };
        int[] nums2 = { 3, 4 };
        Median_Two_Sorted_Arrays median = new Median_Two_Sorted_Arrays();
        // double medianValue = median.findMedianSortedArraysBruteForce(nums1, nums2);
        double medianValue = median.findMedianSortedArraysTwoPointer(nums1, nums2);
        System.out.println("Median: " + medianValue);
    }

    public double findMedianSortedArraysBruteForce(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int sumLength = n1 + n2;
        int[] mergedArray = new int[sumLength];
        int n1Index = 0;
        int n2Index = 0;
        int kIndex = 0;

        while (n1Index < n1 && n2Index < n2) {
            if (nums1[n1Index] < nums2[n2Index]) {
                mergedArray[kIndex] = nums1[n1Index];
                n1Index++;
                kIndex++;
            } else {
                mergedArray[kIndex] = nums2[n2Index];
                n2Index++;
                kIndex++;
            }
        }

        while (n1Index < n1) {
            mergedArray[kIndex] = nums1[n1Index];
            n1Index++;
            kIndex++;
        }
        while (n2Index < n2) {
            mergedArray[kIndex] = nums2[n2Index];
            n2Index++;
            kIndex++;
        }

        System.out.println(Arrays.toString(mergedArray));

        double midValue = 0;

        if (sumLength % 2 == 0) {
            int midTerm = sumLength / 2;
            midValue = (double) (mergedArray[midTerm - 1] + mergedArray[midTerm]) / 2;
        } else {
            int midTerm = (sumLength + 1) / 2;
            midValue = (double) mergedArray[midTerm - 1];
        }
        System.out.println("midValue: " + midValue);
        return midValue;
    }

    /**
     * Finds the median of two sorted arrays using a two-pointer approach.
     * 
     * This method merges two sorted arrays conceptually by iterating through them
     * with two pointers and finds the median value without actually creating a new
     * array.
     * 
     * Time Complexity: O(m + n) where m and n are the lengths of nums1 and nums2
     * Space Complexity: O(1) - only uses a constant amount of extra space
     * 
     * @param nums1 the first sorted array
     * @param nums2 the second sorted array
     * @return the median of the two sorted arrays as a double value
     * 
     *         Algorithm:
     *         - Uses two pointers (n1Index, n2Index) to traverse both arrays
     *         - Iterates up to the middle position of the combined array
     *         - At each step, picks the smaller element from the current positions
     *         - Keeps track of previous and current elements
     *         - If total length is even, returns average of two middle elements
     *         - If total length is odd, returns the middle element
     * 
     *         Part 1: n2Index == n2
     *         Meaning: nums2 is exhausted (no elements left).
     * 
     *         If you’ve already used every element of nums2, you must take from
     *         nums1.
     *         You cannot safely read nums2[n2Index] anymore, so this check comes
     *         first and short-circuits the rest.
     *         Example: nums1 = [1, 3, 5], nums2 = [2] — after taking 2, n2Index ==
     *         1 == n2, so later picks come only from nums1.
     */
    public double findMedianSortedArraysTwoPointer(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int totalLength = n1 + n2;
        int halfLength = totalLength / 2;

        int n1Index = 0;
        int n2Index = 0;

        int prev = 0;
        int curr = 0;

        for (int i = 0; i <= halfLength; i++) {

            prev = curr;

            // If n2 index is used all then simpley add all nums1 value other wise compare n1 with n2
            if (n2Index == n2 || (n1Index < n1 && nums1[n1Index] <= nums2[n2Index])) {
                curr = nums1[n1Index];
                n1Index++;
            } else {
                curr = nums2[n2Index];
                n2Index++;
            }

        }

        if (totalLength % 2 == 0) {
            return (prev + curr) / 2.0;
        }
        return curr;

    }
}
