import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/find-players-with-zero-or-one-losses/description/
public class Player_Zero_One_losses {
    public static void main(String[] args) {
        int[][] matches = { { 1, 3 }, { 2, 3 }, { 3, 6 }, { 5, 6 }, { 5, 7 }, { 4, 5 }, { 4, 8 }, { 4, 9 }, { 10, 4 },
                { 10, 9 } };
        // int[][] matches ={{2,3},{1,3},{5,4},{6,4}};
        // List<List<Integer>> winners = findWinnersBruteForce(matches);
        List<List<Integer>> winners = findWinnersHashMap(matches);
        System.out.println("Winners: " + winners);
    }


    // Foucs on player lost count, if it "0" count means winner if "1" count put in one loss, other than that ignore
    public static List<List<Integer>> findWinnersBruteForce(int[][] matches) {
        Set<Integer> allPlayers = new HashSet<>();

        for (int[] matche : matches) {
            allPlayers.add(matche[0]); // Never lost matches
            allPlayers.add(matche[1]); // Lost at least once mathces
        }
        // System.out.println("allPlayers: "+allPlayers); // All player recorded

        List<Integer> winnerList = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();
        for (int player : allPlayers) {
            int loses = 0;

            for (int[] matche : matches) {
                // Check and compare loses player with index 1
                if (matche[1] == player) {
                    loses++;
                }
            }

            if (loses == 0) {
                winnerList.add(player);
            } else if (loses == 1) {
                oneLoss.add(player);
            }
        }
        Collections.sort(winnerList);
        Collections.sort(oneLoss);

        return Arrays.asList(winnerList, oneLoss);
    }

    // Optimal way
    public static List<List<Integer>> findWinnersHashMap(int[][] matches) {

        Map<Integer, Integer> matchLossFrequency = new HashMap<>();
        Set<Integer> allPlayers = new HashSet<>();
        List<Integer> winnerList = new ArrayList<>();
        List<Integer> oneLossList = new ArrayList<>();

        for(int[] match: matches){
            int lossPlayer = match[1];
            matchLossFrequency.put(lossPlayer, matchLossFrequency.getOrDefault(lossPlayer, 0)+1);
            allPlayers.add(match[0]);
            allPlayers.add(lossPlayer);
        }

        for(int player: allPlayers){
            System.out.println("Player lossCount: "+ player + " : " +matchLossFrequency.get(player));
            if(matchLossFrequency.get(player) == null){
                winnerList.add(player);
            }
            else if(matchLossFrequency.get(player) == 1){
                oneLossList.add(player);
            }
        }

        Collections.sort(winnerList);
        Collections.sort(oneLossList);

        return Arrays.asList(winnerList, oneLossList);
    }

}