
//PriorityQueue<Integer> pq = new PriorityQueue<>();

import java.util.PriorityQueue;

public class MinExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(50);
        pq.add(10);
        pq.offer(60);
        pq.add(30);
        pq.add(20);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

    }
}
