//https://leetcode.com/problems/merge-sorted-array/
public class Merged_SortedArray {
    
}




class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m+n];
        int i=0, j=0, k=0;

        while(i < m && j <n){
            if(nums1[i] <= nums2[j]){
                result[k] = nums1[i];
                k++;
                i++;
            }
            else{
                result[k] = nums2[j];
                k++;
                j++;
            }
        }
        while(i<m){
            result[k] = nums1[i];
            k++;
            i++;
        }
        while(j<n){
            result[k] = nums2[j];
            k++;
            j++;
        }

        for(i=0;i< m+n; i++){
            nums1[i] = result[i];
        }
    }
}


class SolutionOptimal {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}