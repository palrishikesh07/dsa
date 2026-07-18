//https://leetcode.com/problems/koko-eating-bananas/
public class Koko_eating_bananas {

    public static void main(String[] args) {

    }

    public static int minEatingSpeedBruteForce(int[] piles, int h) {
        int max = 0;

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        for (int speed = 1; speed <= max; speed++) {
            long hours = 0;

            for (int pile : piles) {
                hours += (int) Math.ceil(pile * 1.0 / speed);
            }

            if (hours <= h) {
                return speed;
            }

        }

        return max;
    }

    public int minEatingSpeedBinary(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int pile:piles){
            high = Math.max(pile, high);
        }

        while (low < high) {

            int mid = low + (high-low)/2;

            if(canFinsh(piles, h, mid)){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        return low;

    }

    private static boolean canFinsh(int[] piles, int h, int speed){
        long hours=0;

        for(int pile:piles){
            hours += (int) Math.ceil(pile * 1.0 / speed);
        }

        return hours <= h;
    }

}

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (MinSpeed(piles, mid, h))
                right = mid - 1;
            else
                left = mid + 1;

        }
        return left;
    }

    public boolean MinSpeed(int piles[], int k, int h) {

        int no_of_hours_count = 0;

        for (int pile : piles) {
            int divide = pile / k;
            no_of_hours_count += divide;
            if (pile % k != 0)
                no_of_hours_count++;
        }

        return no_of_hours_count <= h;
    }
}

class SolutionSachin {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (MinSpeed(piles, mid, h))
                right = mid - 1;
            else
                left = mid + 1;

        }
        return left;
    }

    public boolean MinSpeed(int piles[], int k, int h) {

        int no_of_hours_count = 0;

        for (int pile : piles) {
            int divide = pile / k;
            no_of_hours_count += divide;
            if (pile % k != 0)
                no_of_hours_count++;
        }

        return no_of_hours_count <= h;
    }
}


/*
A simple rule to remember

When solving Binary Search on Answer problems for the minimum valid value:

If mid works → keep it and search left:

high = mid;

If mid doesn't work → discard it and search right:

low = mid + 1;

This pattern is used in many interview questions such as Koko Eating Bananas, Capacity to Ship Packages Within D Days, Minimum Speed to Arrive on Time, and Split Array Largest Sum. Once you recognize this pattern, these problems become much easier to solve.

*/