import java.util.PriorityQueue;

public class Ropes_Minimise_Cost {
    public static void main(String[] args) {
        int[] ropes = {4, 3, 2, 6};

        System.out.println(minCost(ropes));
    }

     public static int minCost(int[] ropes) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int rope: ropes){
            minHeap.add(rope);
        }

        int cost=0;

        while (minHeap.size()>1) {
            int first =  minHeap.poll();
            int second = minHeap.poll();

            int currentCost = first + second;

            cost +=currentCost;

            minHeap.add(currentCost);
        }

        return cost;
     }
}
