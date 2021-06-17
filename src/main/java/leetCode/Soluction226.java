package leetCode;

import java.util.Stack;

/**
 * @auth hukj001
 **/
public class Soluction226 {

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

    // 反转二叉树
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        return root;
    }




}