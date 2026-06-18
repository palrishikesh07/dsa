
// Java doesn't provide Max Heap directly.
// Use Comparator:
// PriorityQueue<Integer> pq = new PriorityQueue<>(); // Min
// PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // Max

import java.util.Collections;
import java.util.PriorityQueue;



public class MaxExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(50);
        maxHeap.add(10);
        maxHeap.offer(99);
        maxHeap.add(30);
        maxHeap.add(20);

        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }
    }
}
