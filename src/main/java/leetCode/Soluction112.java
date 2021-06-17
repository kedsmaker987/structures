package leetCode;

/**
 * @auth hukj001
 **/
public class Soluction112 {

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
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null ){
            return false;
        }

        if(root.left == null && root.right == null){
            return targetSum-root.val == 0;
        }

        int val = root.val;
        int result = targetSum - val;

        return hasPathSum(root.left,result) || hasPathSum(root.right,result);
    }

}
