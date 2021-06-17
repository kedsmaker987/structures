package leetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @auth hukj001
 **/
public class Soluction104 {

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

    // bfs 广度优先,先遍历每一层
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        // 记录层数
        int level = 0;
        // 先进先出 fifo队列记录
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            // 当前层数所有元素
            int size = queue.size();
            // 进入下一层
            level++;
            for(int i=0;i<size;i++){
                // 清空本层所有元素
                TreeNode node = queue.poll();
                if(node.left !=null){
                    queue.add(node.left);
                }

                if(node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        return level;
    }



}
