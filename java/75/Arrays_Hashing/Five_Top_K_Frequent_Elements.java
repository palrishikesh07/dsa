
//HashMap + Heap/Bucket

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Five_Top_K_Frequent_Elements {
    public static void main(String[] args) {
        int [] nums = {1,1,1,2,2,3,3,3};
        int k = 2;
        // BruteForceApproach bruteForceApproach = new BruteForceApproach();
        // int[] result = bruteForceApproach.topKFrequent(nums, k);


        BucketSortApproach bucketSortApproach = new BucketSortApproach();
        int[] result = bucketSortApproach.topKFrequent(nums, k);

        System.out.println("Top " + k + " frequent elements: ");
        for(int i = 0; i < k; i++){
            System.out.print(result[i] + " ");
        }   
        
    }
    
}

// Brute Force Approach
class BruteForceApproach{
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num: nums){
            int freqCount = freq.getOrDefault(num, 0) + 1;
            freq.put(num, freqCount);
        }
        System.out.println("Frequency map: " + freq);
        System.out.println("Frequency keySet: " + freq.keySet());
        // Just sort on descending order of frequency and return the first k elements
        
        List<Integer> sortedKeys = new ArrayList<>(freq.keySet());
        sortedKeys.sort((a, b) -> freq.get(b) - freq.get(a));
        System.out.println("Sorted keys based on frequency: " + sortedKeys);

        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = sortedKeys.get(i);
        }
        return result;
    }
}


class BucketSortApproach{
    public  int[] topKFrequent(int[] nums, int k){
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num: nums){
            int freqCount = freq.getOrDefault(num,0)+1;
            freq.put(num, freqCount);
        }

        System.out.println(freq);
        List<Integer>[] buckets = new List[nums.length + 1];
        System.out.println("buckets: " + Arrays.toString(buckets));

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            int number = entry.getKey();
            int frequency = entry.getValue();

            if(buckets[frequency] == null){
                buckets[frequency] = new ArrayList<>();
            }

            buckets[frequency].add(number);
            System.out.println("freq: "+frequency + " num: "+number);
        }
        
        int[] result = new int[k];
        int index = 0;
        System.out.println("buckets after filling: " + Arrays.toString(buckets));
        for(int i = buckets.length - 1; i >= 0 && index < k; i--){
            if(buckets[i] != null){
                System.out.println("Frequency " + i + ": " + buckets[i]);
                for(int num : buckets[i]){
                    result[index++] = num;

                    if(index == k) break; // Stop if we have filled the result array   
                }
            }

        }

        return result;
    }
}