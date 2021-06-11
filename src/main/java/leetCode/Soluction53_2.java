package leetCode;

/**
 * @auth hukj001
 * 最大子序列
 * 使用动态规划
 **/
public class Soluction53_2 {

    public void maxSubArray(int[] nums) {
       // 改进版
        int maxResult = nums[0];
        // 最大连续子序列和为 sum,默认为0
        int sum = 0;
        // 维护最大子元素 左边界,右边界
        int left = 0;
        int right = 0;
        for(int i=0;i<nums.length;i++){

            if(sum+nums[i]<nums[i]){
                left = i;
                sum = nums[i];
            }else {
                sum = sum +nums[i];
            }

            if(maxResult<sum){
                maxResult = sum;
                right = i;
            }
        }
        for(int i=left;i<=right;i++){
      System.out.println(nums[i]);
        }
        ;
    }



    public static void main(String[] args){
        int[] arrs = new int[]{ -2,1,-3,4,-1,2,1,-5,4};
        Soluction53_2 soluction = new Soluction53_2();
        soluction.maxSubArray(arrs);
    }
}
