
//https://www.geeksforgeeks.org/problems/quick-sort/1

public class QuickSort {
    public static void main(String[] args) {
        
    }
}



/* 

Quick Sort is one of the most common interview questions. The easiest way to remember it is:

Choose a Pivot → Put smaller elements on the left → Put larger elements on the right → Repeat recursively.

*/


class Solution {
    public void quickSort(int[] arr, int low, int high) {
        // code here
        if(low < high){
            int p = partition(arr,low ,high);
            
            quickSort(arr,low, p-1);
            quickSort(arr,p+1, high);
        }
        
    }

    private int partition(int[] arr, int low, int high) {
        // code here
        
        int pivot = arr[high];
        int i = low-1;
        
        for(int j = low; j<high; j++){
            if(arr[j] < pivot){
                i++;
                
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                
            }
        }
        
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
}


/*

Easy Memory Trick
Step 1: Pick Pivot
8 4 7 2 5
        ↑
      Pivot

Choose the last element as the pivot (5).

Step 2: Move Smaller Elements Left
8 4 7 2 5

↓

4 2 | 5 | 8 7

Now 5 is in its correct position.

Step 3: Repeat

Sort:

4 2

and

8 7

until the array is sorted.

Dry Run

Input:

10 7 8 9 1 5

Pivot = 5

After partition:

1 5 8 9 10 7

Pivot index = 1

Now sort

Left:

1

Right:

8 9 10 7

Repeat the same process.

Time Complexity
Case	Complexity
Best	O(n log n)
Average	O(n log n)
Worst	O(n²) (when pivot is always the smallest or largest element)
Space Complexity
Average: O(log n) (recursive call stack)
Worst: O(n)
Interview Memory Formula

Remember these 5 lines:

pivot = arr[high];
i = low - 1;

for (j = low; j < high; j++)
    if (arr[j] < pivot)
        swap(++i, j);

swap(i + 1, high);
return i + 1;
Easy Story to Remember

Imagine the pivot is a teacher standing at the end of a line.

Students shorter than the teacher stand on the left.
Students taller stand on the right.
Once everyone is arranged, the teacher stands in the correct place.
Then repeat the process for the left and right groups.

This story makes it easy to reconstruct the algorithm during an interview.

Quick Sort = Pick Pivot → Partition → Recursively sort Left and Right.

*/