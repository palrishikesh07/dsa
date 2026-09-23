 //https://leetcode.com/problems/merge-intervals/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Merge_Intervals {

    public static void main(String[] args) {

        int intervals[][] = {{1,3},{2,6,},{8,10},{9,12}};
        Solution solution = new Solution();
        int result[][] = solution.merge(intervals);
        System.out.println("result: "+Arrays.deepToString(result));


        
    }
    
}


class Solution {
    public int[][] merge(int[][] intervals) {

        if(intervals == null || intervals.length <=1){
            return intervals;
        }

        int n = intervals.length;


        Arrays.sort(intervals,(a,b)->Integer.compare(a[0], b[0]));
        System.out.println(Arrays.deepToString(intervals));

        List<int[]> result = new ArrayList<>();

          // 2. Start with first interval

          int currStart = intervals[0][0];
          int currEnd = intervals[0][1];
        for(int i=1; i<n; i++){
       // {{1,3},{2,6,},{8,10},{9,12}};

            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            // 3. Overlap?
            if(nextStart <= currEnd){
                // Merge
                currEnd = Math.max(currEnd, nextEnd);
            }
            else{
                // No overlap → save current interval
                result.add(new int[]{currStart,currEnd});

                 // Start new interval
                 currStart = nextStart;
                 currEnd = nextEnd;
            }

        }

        // 4. Add last interval, reason: it was not added in the loop
        result.add(new int[]{currStart,currEnd});

        return result.toArray(new int[result.size()][]); // Convert List to 2D array
        
    }
}