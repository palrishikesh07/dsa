
//https://www.geeksforgeeks.org/problems/insertion-sort/1
public class InsertionSort {
    
}




// Chat GPT
class Solution {
    public void insertionSort(int arr[]) {
        
        int n = arr.length;
        
        for (int i = 1; i < n; i++) {
            
            int key = arr[i];
            int j = i - 1;
            
            // Shift elements greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            // Insert key at correct position
            arr[j + 1] = key;
        }
    }
}


/*
Memory Trick: "Pick → Shift → Insert"

Every iteration follows the same 3 steps:

Pick the current element (key)
Shift all bigger elements to the right
Insert the key into the empty spot
Template to Memorize
for (int i = 1; i < n; i++) {

    int key = arr[i];
    int j = i - 1;

    while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
    }

    arr[j + 1] = key;
}
How to remember each line
key = arr[i];        // Pick
j = i - 1;           // Look left

while (j >= 0 && arr[j] > key) {
    arr[j + 1] = arr[j];   // Shift
    j--;
}

arr[j + 1] = key;    // Insert

Remember the phrase:

"Pick, Shift, Insert."


*/