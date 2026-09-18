
class Thirteen_Buy_Sell_Stock {
    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        BruteForceSolution bruteForceSolution = new BruteForceSolution();
        System.out.println(bruteForceSolution.maxProfit(prices));

        SlidingWindowApproach slidingWindowApproach = new SlidingWindowApproach();
        System.out.println(slidingWindowApproach.maxProfit(prices));

    }
}

class BruteForceSolution {
    public int maxProfit(int[] nums) {
        int n = nums.length;
        int maxProfit = 0;

        for (int i = 0; i < n; i++) {

            int buyPrice = nums[i];
            for (int j = i + 1; j < n; j++) {

                int sellPrice = nums[j];

                int profit = sellPrice - buyPrice;
                maxProfit = Math.max(profit, maxProfit);
            }
        }
        return maxProfit;
    }
}

class SlidingWindowApproach {
    // int[] prices = { 7, 1, 5, 3, 6, 4 };
    public int maxProfit(int[] nums) {
        int n = nums.length;

        int minPrice = nums[0];
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {

            if (nums[i] < minPrice) {
                minPrice = nums[i];
            } else {
                int profit = nums[i] - minPrice;
                maxProfit = Math.max(profit, maxProfit);
            }

        }

        return maxProfit;
    }
}
