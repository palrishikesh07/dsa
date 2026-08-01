public class Buy_Sell_Stock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        int profit = maxProfit(prices);
        System.out.println("Profit :"+profit);
        
    }

     public static int maxProfitBruteForce(int[] prices) {
        int maxProfit = 0;
        int n= prices.length;
        for(int i=0; i<n; i++){
            int buyPrice = prices[i];

            for(int j=i+1; j<n;j++){

                if(prices[j] > buyPrice){

                    int profit = prices[j] - buyPrice;
                    maxProfit = Math.max(maxProfit, profit);
                }
            }
        }

        return maxProfit;
    }

    // public static int maxProfit(int[] prices) {
    //     int minPrice = prices[0];
    //     int maxProfit = 0;
    //     int n = prices.length;

    //     for(int i=1;i<n; i++){

    //         int profit = prices[i] - minPrice;
    //         minPrice = Math.min(minPrice, prices[i]);
    //         maxProfit = Math.max(maxProfit, profit);
    //     }

    //     return maxProfit;
    // }






//int[] prices = {7,1,5,3,6,4};
 public static int maxProfit(int[] prices) {

    int n= prices.length;
    int minPrice = prices[0];
    int maxProfit = 0;
    for(int i=1; i< n; i++){
        int profit = prices[i] - minPrice;
        maxProfit = Math.max(maxProfit, profit);
        minPrice = Math.min(minPrice, prices[i]);
    }
    return maxProfit;
       
}









}
