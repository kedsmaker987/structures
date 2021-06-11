package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @auth hukj001
 * 两数之和
 **/
public class Soluction1 {

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> recordMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(recordMap.containsKey(target-nums[i])){
                return new int[]{i,recordMap.get(target-nums[i])};
            }
            recordMap.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args){
        int[] arrs = new int[]{3,3};
        int target = 6;
        int[] result = twoSum(arrs,target);
    System.out.println("");
    }
}
