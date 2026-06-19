import java.util.PriorityQueue;

public class Sum_K1_K2 {
    public static void main(String[] args) {

        int[] arr = { 1, 3, 12, 5, 15, 11 };

        int k1 = 3;
        int k2 = 6;

        System.out.println(sumBetween(arr, k1, k2));

    }

    public static int sumBetween(int[] arr, int k1, int k2) {
        int first = kthSmallest(arr, k1);
        int second = kthSmallest(arr, k2);

        int sum = 0;

        for (int num : arr) {
            if (num > first && num < second) {
                sum += num;
            }
        }
        return sum;
    }

    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int num : arr) {
            maxHeap.add(num);

            if (maxHeap.size() > k) {
                maxHeap.poll(); // Remove max value after k, so that k smallest value can be return
            }
        }
        return maxHeap.peek(); // Returing smallest k value from top
    }

}