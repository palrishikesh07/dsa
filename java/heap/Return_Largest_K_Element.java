import java.util.PriorityQueue;

public class Return_Largest_K_Element {
    public static void main(String[] args) {
        int[] arr = { 10, 5, 4, 3, 48, 6, 2, 33, 53, 10 };
        int k = 4;
        int[] largestKElements = findKLargest(arr, k);
        System.out.println("The " + k + " largest elements are:");
        for (int num : largestKElements) {
            System.out.print(num + " ");
        }
    }

    public static int[] findKLargest(int[] nums, int k) {
        if (nums == null || k <= 1)
            return new int[0];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element
            }
        }

        int[] result = new int[k];

        // Descending order
        // for (int i = k - 1; i >= 0; i--) {
        //     result[i] = minHeap.poll();
        // }
    
        // To get in ascending order
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }

}
