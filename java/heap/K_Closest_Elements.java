import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;


public class K_Closest_Elements {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 4;
        int x = 3;
        System.out.println(findKClosest(arr, k, x));
    }


    static class Pair{
        int diff;
        int value;

        Pair(int diff,int value){
            this.diff = diff;
            this.value = value;
        }
    }

    public static List<Integer> findKClosest(int[] arr, int k, int x) {
        // Max-Heap storing pairs of (absolute difference, value)
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b)->b.diff - a.diff); // (a,b) -> b.diff - a.diff is the comparator for max-heap

        for(int num: arr){
            int diff = Math.abs(num -x);

            maxHeap.add(new Pair(diff, num));
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll().value);
        }

        // Collections.sort(result);
        return result;
    }
}
