class Solution {
    public int maxProfit(int[] prices) {
        
        int profit = 0;
        if(prices == null || prices.length <2){
            return profit;
        }
        
        profit = prices[1] - prices[0];
        
        if(prices.length == 2 ){
            
            return profit <0 ?0: profit;
                
        }
        
        int[] profits = new int[prices.length];
        int minBuy = Math.min(prices[0],prices[1]);
        int maxProfit = profit >0 ? profit :0;
        for(int i=2;i<prices.length; i++){
           profit =  prices[i] - minBuy;
           if(profit > maxProfit){
               maxProfit = profit;
           }
            if(minBuy > prices[i]){
                minBuy = prices[i];
            }
        }
            
        return maxProfit;
    }
}