//https://leetcode.com/problems/car-fleet/description/

import java.util.Arrays;
import java.util.Stack;

public class C_22_Car_Fleet {
    public static void main(String[] args) {

        BruteForce bruteForce = new BruteForce();
        int target = 12;
        int[] position = { 10, 8, 0, 5, 3 };
        int[] speed = { 2, 4, 1, 1, 3 };
        int result = bruteForce.carFleet(target, position, speed);
        System.out.println(result);

    }

}

/*
 * A straightforward Bruteforce approach is:
 * 
 * Calculate the arrival time for every car.
 * Sort cars by position.
 * Start from the car closest to the target.
 * Compare the arrival time of the car behind with the fleet ahead.
 * If the behind car arrives earlier or at the same time, it catches the fleet.
 * Otherwise, it creates a new fleet.
 * 
 * We can do this with an array after sorting.
 */
class BruteForce {

    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;
        // Store position and arrival time
        double[][] cars = new double[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }
        System.out.println("Cars: ");
        // for(int i=0; i<n; i++){
        // System.out.println("Position: " + cars[i][0] + ", Arrival Time: " +
        // cars[i][1]);
        // }
        // System.out.println("Sorted :"+ Arrays.deepToString(cars));
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));
        // System.out.println("Sorted :"+ Arrays.deepToString(cars));

        int fleets = 0;

        for (int i = 0; i < n; i++) {
            double currentTime = cars[i][1];
            // Compare with cars ahead
            int j = i + 1;

            while (j < n) {
                double aheadTime = cars[j][1];
                if (currentTime <= aheadTime) {
                    // Current car catches the fleet ahead
                    currentTime = aheadTime;
                }
                else{
                     // Cannot catch
                     fleets++;
                     break;
                }
                j++;
            }
            if(j==n){
                fleets++;
            }
            i = j-1;
        }

        return fleets;
    }
}


/*
Sorting + Monotonic Stack
We don't actually need to simulate cars moving.
We only need:
arrival time
Sort cars by their position from closest to target → farthest from target.
Then process them from front to back.
*/

class SortingMonotonicStack{

     public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;
        // Store position and arrival time
        double[][] cars = new double[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }
        System.out.println("Cars: ");
        // System.out.println("Sorted :"+ Arrays.deepToString(cars));
        // Sort by position: closest to target first
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));
        // System.out.println("Sorted :"+ Arrays.deepToString(cars));

        Stack<Double> stack = new Stack<>();

        for(int i=0; i<n; i++){
            double time = cars[i][1];

            if(stack.isEmpty() ||  time > stack.peek()){

                stack.push(time);
            }
        }
        
        return  stack.size();
    }
}