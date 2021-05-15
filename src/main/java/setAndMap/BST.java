package setAndMap;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树
 * @param <E>
 */
public class BST<E extends Comparable<E>> {

    private Node root;
    private int size;
    public BST(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size ;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // 新增元素
    public void add(E e){
        root = add(root,e);
    }

    // 递归新增数据
    public Node add(Node node,E e){
        // 相等
        if(node == null){
            size++;
            return new Node(e);
        }

        if(e.compareTo(node.e)<0 ){
            node.left = add(node.left,e);
        }

        if(e.compareTo(node.e)>0){
            node.right = add(node.right,e);
        }

        return node;
    }

    // 二分树中是否包含元素
    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node node,E e){
        if(node == null){
            return false;
        }

        if(node.e.compareTo(e) == 0){
            return true;
        }

        if(e.compareTo(node.e)<0){
            return contains(node.left,e);
        }else {
            return contains(node.right,e);
        }
    }

    public void preOrder(){
        preOrder(root);
    }

    // 前序遍历
    private void preOrder(Node node){
        if(node == null){
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(){
        inOrder(root);
    }

    // 中序
    private void inOrder(Node node){
        if(node == null){
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
    }

    // 后序
    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    // 层级遍历
    public void levelOrder(){

        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()){
            Node curNode = queue.remove();
            System.out.println(curNode.e);
            if(curNode.left!=null){
                queue.add(curNode.left);
            }
            if(curNode.right!=null){
                queue.add(curNode.right);
            }
        }

    }

    // 二叉树最小值
    public E minimum(){
        if(size == 0){
            throw new IllegalArgumentException(" BST is empty");
        }

        Node minNode = minimum(root);
        return minNode.e;
    }

    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    // 最大值
    public E maximum(){
        if(size == 0){
            throw new IllegalArgumentException(" BST is empty");
        }

        Node maxNode = maximum(root);
        return maxNode.e;
    }

    // 删除最小元素
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // 删除最大元素
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    private Node maximum(Node node){
        if(node.right == null){
            return node;
        }
        return maximum(node.right);
    }

    // 从二分搜索树中删除元素为e的节点
    public void remove(E e){
        root = remove(root, e);
    }

    private Node remove(Node node,E e){
        if(node == null){
            return null;
        }

        if(e.compareTo(node.e)<0){
            node.left = remove(node.left,e);
            return node;
        } else if(e.compareTo(node.e)>0){
            node.right = remove(node.right,e);
            return node;
        }else {

            // 左侧无
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 两侧都有,右侧最小值
            Node lefMinNode = minimum(node.right);
            // 删除右侧最小值
            lefMinNode.right = removeMin(node.right);
            lefMinNode.left = node.left;
            node.left = null;
            node.right = null;
            return lefMinNode;
        }

    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateString(Node node, int depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateString(node.left, depth + 1, res);
        generateString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }

    private class Node{
        public E e;
        public Node left,right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

}
