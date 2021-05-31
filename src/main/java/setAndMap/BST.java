package setAndMap;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树
 * @param <E>  the type parameter
 */
public class BST<E extends Comparable<E>> {

    private Node root;
    private int size;
    /**
     * Instantiates a new Bst.
     */
public BST(){
        root = null;
        size = 0;
    }

    /**
     * Get size int.
     *
     * @return the int
     */
public int getSize(){
        return size ;
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Add.
     *
     * @param e the e
     */
// 新增元素
    public void add(E e){
        root = add(root,e);
    }

    /**
     * Add node.
     *
     * @param node the node
     * @param e the e
     * @return the node
     */
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

    /**
     * Contains boolean.
     *
     * @param e the e
     * @return the boolean
     */
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

    /**
     * Pre order.
     */
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

    /**
     * In order.
     */
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

    /**
     * Post order.
     */
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

    /**
     * Level order.
     */
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

    /**
     * Minimum e.
     *
     * @return the e
     */
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

    /**
     * Maximum e.
     *
     * @return the e
     */
// 最大值
    public E maximum(){
        if(size == 0){
            throw new IllegalArgumentException(" BST is empty");
        }

        Node maxNode = maximum(root);
        return maxNode.e;
    }

    /**
     * Remove min e.
     *
     * @return the e
     */
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

    /**
     * Remove max e.
     *
     * @return the e
     */
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

    /**
     * Remove.
     *
     * @param e the e
     */
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
        /**
         * The E.
         */
public E e;
        /**
         * The Left.
         */
public Node left,/**
         * The Right.
         */
right;

        /**
         * Instantiates a new Node.
         *
         * @param e the e
         */
public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

}
