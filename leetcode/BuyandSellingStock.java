public class BuyandSellingStock {

    public int maxProfit(int[] prices) {
        int count =0;
        int left=0;
        int right=1;
        while(true){
            if(left>=prices.length || right>=prices.length){
                return count;
            }
            else if(prices[left]>prices[right]){
                left=right;
                right=right+1;
            }
            else{
                count=Math.max(count,prices[right]-prices[left]);
                right=right+1;
            }
        }
    }
}
