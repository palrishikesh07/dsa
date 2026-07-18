//https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
public class Allocate_minimum_number_pages {


    public static void main(String[] args) {
        // SolutionBruteForce sol = new SolutionBruteForce();
        Solution sol = new Solution();
        // Call solution methods here and print results
        int[] pages = { 12, 34, 67, 90 };
        int k = 2;
        System.out.println(sol.findPages(pages, k));

    }

}

/*
 * 
 * List of Similar Questions :
 * 
 * Capacity To Ship Packages Within D Days Problem ID: 1011
 * Split Array Largest Sum Problem ID: 410
 * Minimize Maximum Pair Sum in Array Problem ID: 1877
 * Maximize Sweetness of Chocolate Problem ID: 1231
 */


class SolutionBruteForce {

    public int findPages(int[] arr, int k) {
        int n = arr.length;
        int ans = Integer.MAX_VALUE;

        // Try every partition
        for (int i = 0; i < n-1; i++) {

            int student1 = 0;
            int student2 = 0;

            // Sum left side (1st half)
            for (int j = 0; j <= i; j++) {
                student1 += arr[j];
            }

            // Sum right side (1nd half)

            for (int j = i + 1; j < n; j++) {
                student2 += arr[j];
            }

            // Find max
            int currentMax = Math.max(student1, student2);
            ans = Math.min(ans, currentMax);
            System.out.println(
                    "Partition after index " + i +
                            " -> Left = " + student1 +
                            ", Right = " + student2 +
                            ", Max = " + currentMax);


        }

         return ans;

    }

}

class Solution {

     public int findPages(int[] arr, int k) {
        int n = arr.length;
        if(k > n){
            return -1;
        }

        int minPage=0;
        int maxPage =0;

        for(int page: arr){
            minPage = Math.min(minPage, maxPage);
            maxPage +=page;
        }

        int ans = -1;   

        while (minPage <= maxPage) {
            int mid = minPage + (maxPage - minPage)/2;
            if(isPossible(arr, n, k, mid)){
                ans = mid;
                maxPage = mid-1;
            }
            else{
                minPage = mid+1;
            }

             System.out.println(
                    "Partition after index " + "" +
                            " -> Min = " + minPage +
                            ", Max = " + maxPage +
                            ", mid = " + mid);

        }
        return ans;
     }

     private boolean isPossible(int[] arr, int n,int students,int maxPages){
        int studentCount = 1;
        int pageSum = 0;

        for(int i=0;i<n;i++){

            if(pageSum + arr[i] <= maxPages){
                pageSum +=arr[i];
            }
            else{

                studentCount++;
                if(studentCount > students || arr[i] > maxPages){
                    return false;
                }

                pageSum = arr[i];
            }
        }

        return true;
     }

}