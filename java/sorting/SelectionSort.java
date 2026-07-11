//https://www.geeksforgeeks.org/problems/selection-sort/1
public class SelectionSort {
    
}





// By Mahek
class Solution {
    void selectionSort(int[] arr) {
        // code here
        int n = arr.length;
        for(int i=0; i<n; i++){
            int minIdx = i;
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[minIdx]){
                    minIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }
}