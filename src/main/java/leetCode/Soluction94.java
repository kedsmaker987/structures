package leetCode;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @auth hukj001
 **/
public class Soluction94 {

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
    // 中序排列
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
       Stack<TreeNode> stack = new Stack<>();
        while (root!=null){
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            result.add(tmp.val);
            TreeNode node = tmp.right;
            while (node!=null){
                stack.push(node);
                node = node.left;
            }
        }

        return  result;
    }

    // 前序排列
    public List<Integer> frontTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null){
            result.add(root.val);
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()){
            TreeNode tmp = stack.pop();

            TreeNode node = tmp.right;
            while (node!=null){
                result.add(root.val);
                stack.push(node);
                node = node.left;
            }
        }

        return  result;
    }

    // 后续排列
    public List<Integer> afterTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null){
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()){
            TreeNode tmp = stack.pop();

            TreeNode node = tmp.right;
            while (node!=null){
                result.add(root.val);
                stack.push(node);
                node = node.left;
            }
        }

        return  result;
    }


}
