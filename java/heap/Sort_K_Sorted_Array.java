import java.util.Arrays;
import java.util.PriorityQueue;

public class Sort_K_Sorted_Array {
    public static void main(String[] args) {
        int[] arr = { 10, 9, 8, 7, 5, 70, 60, 50 };
        int k = 4;

        System.out.println("Original: " + Arrays.toString(arr));
        sortKSortedArray(arr, k);
        System.out.println("Sorted:   " + Arrays.toString(arr));
    }

    public static void sortKSortedArray(int[] arr, int k) {
        if (arr == null || k < 0)
            return;
        int length = arr.length;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // Insert first k+1 elements into the heap
        for (int i = 0; i <= k; i++) {
            minHeap.add(arr[i]);
        }

        int index = 0;
        // Process remaining elements
        for (int i = k + 1; i < length; i++) {
            // Extract min and place in sorted position
            arr[index++] = minHeap.poll();
            // Add next element to heap
            minHeap.add(arr[i]);
        }

        // Extract remaining elements from heap
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }

    }
}
