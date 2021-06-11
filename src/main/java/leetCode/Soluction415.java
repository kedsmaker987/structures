package leetCode;

/**
 * @auth hukj001
 * 字符串相加
 **/
public class Soluction415 {

    public String addStrings(String num1, String num2) {

        // 记录每一位的值
        StringBuilder sb = new StringBuilder();

        // 字符串最后坐标
        int i = num1.length()-1;
        int j = num2.length()-1;
        // 进位
        int carry = 0;

        // 反向相加
        while (i>=0 || j>=0){
            // 不足未添加0
            int n = i>=0?  num1.charAt(i) - '0':0;
            //
            int m = j>=0? num2.charAt(j) - '0':0;
            // 相加
            int tmp = n + m +carry;
            // 进位
            carry = tmp/10;
            // 本位值
            sb.append(tmp%10);
            i--;
            j--;
        }

        if(carry == 1){
            sb.append(1);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args){
        Soluction415 soluction415 = new Soluction415();
        String a = "123";
        String b = "456";
    System.out.println(soluction415.addStrings(a,b));

    }
}
