package leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @auth hukj001
 * 括号问题
 **/
public class Soluction20 {

    public boolean isValid(String s) {
        Map<Character, Character> paramMap = new HashMap<>();
        paramMap.put('(',')');
        paramMap.put('{','}');
        paramMap.put('[',']');

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c: chars){
            // 开口方向
            if(paramMap.containsKey(c)){
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                // 闭口方向
                Character pop = stack.pop();// 弹出
                if(!paramMap.get(pop).equals(c)){
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }

        return true;
    }

    public static void main(String[] args){
        String s = "()";
        Soluction20 soluction20 = new Soluction20();
        soluction20.isValid(s);
    }
}
