import java.util.PriorityQueue;

// Distance from origin (0,0):
// distance2=x2+y2
// Store (distance, x, y) in a Max Heap.

public class K_Closest {
    public static void main(String[] args) {
        int[][] points = {
                { 1, 3 },
                { -2, 2 },
                { 5, 8 },
                { 0, 1 }
        };

        int k = 2;

        int[][] result = kClosest(points, k);

        for (int[] point : result) {
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
    }

    static class Pair {
        int distance;
        int x;
        int y;

        Pair(int distance, int x, int y) {
            this.distance = distance;
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.distance - a.distance);

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            int distance = x * x + y * y;

            maxHeap.offer(new Pair(distance, x, y));

            if(maxHeap.size()>k){
                maxHeap.poll();
            }

        }

        // 
        int[][] result = new int[k][2];

        int index = 0;
        while (!maxHeap.isEmpty()) {
            Pair current = maxHeap.poll();

            result[index][0] = current.x;
            result[index][1] = current.y;

            index++;
        }

        return result;
    }
}
