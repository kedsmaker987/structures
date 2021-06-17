package leetCode;

/**
 * @auth hukj001
 **/
public class Soluction88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while (j>=0){
            // 遍历nums1到最后，而num2还没有循环完
            if(i<0){
                // 循环赋值，将nums2值全部赋给k下标
                while (j>=0){
                    nums1[k--] = nums2[j--];
                }
                return;
            }
            // 谁打,k下标就是谁
            if(nums1[i]>nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }

    }

    public static void main(String[] args){
        int[] num1 = new int[]{1,2,3,0,0,0};
        int[]  num2 = new int[]{2,5,6};
        Soluction88 soluction88 = new Soluction88();
        soluction88.merge(num1,3,num2,3);
    }
}
