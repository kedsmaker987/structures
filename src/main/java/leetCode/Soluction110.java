package leetCode;

/**
 * @auth hukj001
 **/
public class Soluction110 {

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


    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(Math.abs(heigth(root.left)-heigth(root.right))>1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }


    public int heigth(TreeNode node){
         if(node == null){
             return 0;
         }
         return Math.max(heigth(node.right),heigth(node.left)) +1;
    }
}
