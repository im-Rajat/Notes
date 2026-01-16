// 121. Best Time to Buy and Sell Stock
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution
{
    public int maxProfit(int[] prices)
    {
        int len = prices.length;
        
        int curr_max = prices[len- 1];
        int ans = 0;
        
        for(int i = len - 2; i >= 0; i--)
        {
            int temp = curr_max - prices[i];
            ans = Math.max(ans, temp);
            curr_max = Math.max(curr_max, prices[i]); 
        }
        
        return ans;
    }
}
