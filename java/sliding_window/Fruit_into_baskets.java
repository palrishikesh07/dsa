import java.util.HashMap;
import java.util.Map;

public class Fruit_into_baskets {
    public static void main(String[] args) {
        // int[] fruits = {1, 2, 1};
        int[] fruits = { 1, 2, 3, 2, 2 };
        // int maxFruits = totalFruit(fruits);
        int maxFruits = totalFruitOptimal(fruits);
        System.out.println("Max Fuits: " + maxFruits);
    }

    public static int totalFruit(int[] fruits) {
        int maxFruit = 0;
        int length = fruits.length;
        for (int i = 0; i < length; i++) {
            // Map to store the count of fruit types
            Map<Integer, Integer> basked = new HashMap<>();
            // Variable to track current number of fruits collected
            int currentCount = 0;
            for (int j = i; j < length; j++) {
                // Add current fruit to the basket
                basked.put(fruits[j], basked.getOrDefault(fruits[j], 0) + 1);

                if (basked.size() > 2) {
                    break;
                }

                currentCount++;
            }
            maxFruit = Math.max(maxFruit, currentCount);
        }
        return maxFruit;
    }

    public static int totalFruitOptimal(int[] fruits) {

        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxFruits = 0;

        for (right = 0; right < fruits.length; right++) {
            // Add current to basket
            // int currentCount = ;
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

            // If basket has more than 2 type of fruits,
            // start emptying the basket
            while (basket.size() > 2) {
                int fruitCount = basket.get(fruits[left]);
                if (fruitCount == 1)
                    basket.remove(fruits[left]);
                else
                    basket.put(fruits[left], fruitCount - 1);
                left++;
            }

            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        return maxFruits;

    }
}
