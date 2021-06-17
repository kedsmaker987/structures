package leetCode;

/**
 * @auth hukj001
 **/
public class Soluction70 {

    // 典型的动态规划
    // f(n) = f(n-1) + f(n-2)
    public int climbStairs(int n) {
      if(n==1 || n ==2){
          return n;
      }

      int[] dp = new int[n+1];
      dp[1] = 1;
      dp[2] = 2;
      for(int i=3;i<dp.length;i++){
          dp[i] = dp[i-1] + dp[i-2];
      }

      return dp[n];

    }

    public static void main(String[] args){
        Soluction70 soluction70 = new Soluction70();
    System.out.println(soluction70.climbStairs(3));

    }


}
