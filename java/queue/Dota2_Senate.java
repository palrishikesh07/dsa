//https://leetcode.com/problems/dota2-senate/

import java.util.LinkedList;
import java.util.Queue;

public class Dota2_Senate {

    public static void main(String[] args) {
        String senate = "RDD";
        String result = predictPartyVictory(senate);
        System.out.println("Result Victory : " + result);

    }

    public static String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        int n = senate.length();

        // Store indices
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.add(i);
            } else {
                dire.offer(i);
            }
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIndex = radiant.poll();
            int dIndex = dire.poll();

            if (rIndex < dIndex) {
                // Radiant bans Dire
                radiant.add(rIndex + n); // Add in queue with values
            } else {
                dire.add(dIndex + n);
            }

        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
