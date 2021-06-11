package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @auth hukj001
 * 使用窗口模式
 **/
public class Soluction3 {

    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }

        Map<Character,Integer> recordMap = new HashMap<>();
        // 默认左下标
        int leftIndex = 0;
        // 默认最大值
        int max = 0;
        for(int i=0;i<s.length();i++){
            // 如果包含
            if(recordMap.containsKey(s.charAt(i))){
                // 保持当前坐标还是右移动
                // 分别对应两种情况,1)在窗口外 保持leftIndex不变 2)窗口内 直接跳转到下一个
                leftIndex = Math.max(leftIndex,recordMap.get(s.charAt(i))+1);
            }
            // 记录元素下标位置
            recordMap.put(s.charAt(i),i);
            max = Math.max(max,i-leftIndex+1);

        }
        return max;
    }
}
