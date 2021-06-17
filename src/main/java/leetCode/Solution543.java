package leetCode;

/**
 * @auth hukj001
 **/
public class Solution543 {

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

    private int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        height(root);
        return max;
    }

    public int height(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        max = Math.max(left+right,max);
        return Math.max(left,right) +1;
    }
}
