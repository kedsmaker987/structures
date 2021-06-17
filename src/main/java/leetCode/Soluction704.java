package leetCode;

/**
 * @auth hukj001
 * 二分查找
 **/
public class Soluction704 {
    public int search(int[] nums, int target) {
        return search(nums,0,nums.length-1,target);
    }

    public int search(int[]nums,int left,int right,int target){
        if(left>right){
            return -1;
        }
        int mid = left +(right-left)/2;
        if(nums[mid] == target){
            return mid;
        }

        if(nums[mid]>target){
            return search(nums,left,mid-1,target);
        }else {
            return search(nums,mid+1,right,target);
        }
    }

    public static void main(String[] args){
        int[]  num2 = new int[]{-1,0,3,5,9,12};
        Soluction704 soluction704 = new Soluction704();
        soluction704.search(num2,9);
    }
}
