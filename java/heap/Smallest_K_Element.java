
import java.util.Collections;
import java.util.PriorityQueue;

public class Smallest_K_Element {
    public static void main(String[] args) {
        int[] arr = { 10, 5, 4, 3, 48, 6, 2, 33, 53, 10 };
        int k = 4;
        System.out.println("The " + k + "th smallest element is: " + kthSmallest(arr, k));

    }

    static int kthSmallest(int[] arr, int k) {
        // Create a max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // Iterate through the array elements
        for (int val : arr) {
            // Push the current element onto the max heap
            maxHeap.add(val);
            // If the size of the max heap exceeds k,
            // remove the largest element
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        // Return the kth smallest element (top of the max heap)
        return maxHeap.peek();

    }
}
