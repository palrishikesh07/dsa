
import java.util.Arrays;

//https://www.naukri.com/code360/problems/aggressive-cows_1082559?source=youtube&campaign=love_babbar_codestudio2

public class Aggressive_Cows {
    public static void main(String[] args) {
        
    }

}




class SolutionBruteForce {

    public int aggressiveCows(int[] stalls, int k) {

        Arrays.sort(stalls);

        int n = stalls.length;

        int ans = Integer.MIN_VALUE;

        // Try every possible placement of 3 cows
        for (int i = 0; i < n - 2; i++) {

            for (int j = i + 1; j < n - 1; j++) {

                for (int l = j + 1; l < n; l++) {

                    int d1 = stalls[j] - stalls[i];
                    int d2 = stalls[l] - stalls[j];

                    int currentMin = Math.min(d1, d2);

                    ans = Math.max(ans, currentMin);

                    System.out.println(
                            "Placement = [" +
                                    stalls[i] + ", " +
                                    stalls[j] + ", " +
                                    stalls[l] + "]" +
                                    " -> Min Distance = " + currentMin);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        SolutionBruteForce obj = new SolutionBruteForce();

        int[] stalls = {1,2,4,8,9};

        System.out.println(obj.aggressiveCows(stalls,3));
    }
}


class Solution {

    public int aggressiveCows(int[] stalls, int k) {

        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];

        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isPossible(stalls, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean isPossible(int[] stalls, int k, int minDistance) {

        int cowCount = 1;
        int lastPos = stalls[0];

        for (int i = 1; i < stalls.length; i++) {

            if (stalls[i] - lastPos >= minDistance) {

                cowCount++;
                lastPos = stalls[i];

                if (cowCount == k) {
                    return true;
                }
            }
        }

        return false;
    }
}