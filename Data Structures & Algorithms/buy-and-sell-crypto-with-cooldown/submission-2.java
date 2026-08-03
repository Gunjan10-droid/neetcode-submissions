class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[2];
        int[] prev1 = new int[2];
        int[] prev2 = new int[2];
        for(int i=n-1; i>=0; i--){
            for(int buy=0; buy<=1; buy++){
                int profit = 0;
                if(buy==0){
                    profit = Math.max(0+prev1[0], -prices[i]+prev1[1]);
                }
                if(buy==1){
                    profit = Math.max(0+prev1[1], prices[i]+prev2[0]);
                }
                dp[buy] = profit;
            }
            prev2 = prev1.clone();
            prev1 = dp.clone();
        }
        return dp[0];
    }
}
