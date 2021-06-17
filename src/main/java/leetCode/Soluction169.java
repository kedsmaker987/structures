package leetCode;

/**
 * @auth hukj001
 **/
public class Soluction169 {

    public int majorityElement(int[] nums) {
        int cand_num = nums[0];
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == cand_num){
                count++;
            }else {
                count--;
                if(count == 0){
                    cand_num = nums[i];
                    count = 1;
                }
            }
        }
        return cand_num;
    }

    // 投票方案

}
