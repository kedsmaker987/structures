package leetCode;

import java.util.Stack;

/**
 * @auth hukj001
 **/
public class Soluction101 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {
       Stack<TreeNode> stack = new Stack<>();
       stack.push(root.left);
       stack.push(root.right);

       while (!stack.isEmpty()){
           TreeNode top1 = stack.pop();
           TreeNode top2 = stack.pop();

           if(top1 == null && top2 == null){
               continue;
           }

           if(top1 == null || top2 == null){
               return false;
           }

           if(top1.val !=top2.val){
               return false;
           }

           stack.push(top1.left);
           stack.push(top2.right);

           stack.push(top1.right);
           stack.push(top2.left);
       }

       return true;
    }






}
