package leetCode;

/**
 * @auth hukj001
 **/
public class Soluction121 {

    // 动态规划
    public int maxProfit(int[] prices) {
        // min 前i天的最小值,max最大收益
        int min = prices[0],max = 0;

        for(int i=0;i<prices.length;i++){
            min = Math.min(min,prices[i]);
            max = Math.max(max,prices[i]-min);
        }
        return max;

    }
}
