package leetCode;

/**
 * @auth hukj001
 * 最大子序列
 * 使用动态规划
 **/
public class Soluction53 {

    public int maxSubArray(int[] nums) {
        int maxResult = 0;
        for(int i=0;i<nums.length;i++){
            if(i == 0){
                maxResult = getMax(nums,0);
            }
            int result = getMax(nums,i);
            if(result>maxResult){
                maxResult = result;
            }
        }
        return maxResult;
    }

    // 获取最大值,动态规划
    public int getMax(int[] nums,int i){
        if(i == 0){
            return nums[0];
        }
        // 因为要判断是否是连续，不能跳过，所以比较两者大小
        return Math.max(getMax(nums,i-1)+nums[i],nums[i]);
    }

    public static void main(String[] args){
        int[] arrs = new int[]{ -2,1,-3,4,-1,2,1,-5,4};
        Soluction53 soluction = new Soluction53();
        System.out.println(soluction.maxSubArray(arrs));
    }
}
