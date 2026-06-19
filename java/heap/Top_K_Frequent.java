import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Top_K_Frequent {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 3, 2, 2, 4,4 };
        int k = 3;

        System.out.println(topKFrequent(nums, k));
    }

    static class Pair {
        int freq;
        int num;

        Pair(int freq, int num) {
            this.freq = freq;
            this.num = num;
        }
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap  = new HashMap<>();

        for(int num:nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b)->a.freq - b.freq);

        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()){
            minHeap.add(new Pair(entry.getValue(), entry.getKey()));

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
                result.add(minHeap.poll().num);
        }
        return result;
    }

}
