package leetcode.dp;

public class BuyAndSellStock {

	class Solution {
	    public int maxProfit(int[] prices) {
	        if(prices == null || prices.length == 0){
	            return 0;
	        }
	        int min = prices[0];
	        int maxProfit = 0;
	        for(int i = 1; i < prices.length; i++){
	            if(prices[i] > min){
	                //calculate profit.
	                int profit = prices[i]-min;
	                if(profit > maxProfit){
	                    maxProfit = profit;
	                }
	            }else if(prices[i] < min ){
	                min = prices[i];
	            }
	        }
	        return maxProfit;
	    }
	}
}
