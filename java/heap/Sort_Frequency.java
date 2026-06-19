import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Sort_Frequency {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 3, 2, 2, 4 };

        System.out.println(frequencySort(nums));
    }

    static class Pair{
        int freq;
        int num;

        Pair(int freq, int num){
            this.freq = freq;
            this.num = num;
        }
    }

    public static List<Integer> frequencySort(int[] nums){
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b)->b.freq - a.freq);

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            maxHeap.add(new Pair(entry.getValue(), entry.getKey()));
        }

        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            Pair current = maxHeap.poll();

            for(int i=0;i<current.freq; i++){
                result.add(current.num);
            }
        }
        return result;
    }
}
