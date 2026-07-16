class Solution {
    public int maxProfit(int[] prices) {
        int mini = prices[0];
        int res= 0;
        for(int i=0;i<prices.length;i++){
            if(mini>prices[i]){
                mini = prices[i];
            }
            if(mini != prices[i]){
                res = Math.max(res, (prices[i]-mini));
            }
        }
        return res;
    }
}
