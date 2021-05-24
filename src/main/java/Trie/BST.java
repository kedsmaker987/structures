package Trie;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 二叉树
 * @param <E>
 */
public class BST<E extends Comparable<E>> {

    public class Node{
        public E e;
        public Node left,right;
        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 添加
     * @param e
     */
    public void add(E e){
        root = add(root,e);
    }

    /**
     * 是否包含
     * @param e
     * @return
     */
    public boolean contains(E e){
        return contains(root,e);
    }

    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);

            if(cur.left !=null){
                q.add(cur.left);
            }

            if(cur.right!=null){
                q.add(cur.right);
            }
        }
    }


    /**
     * 最小值
     * @return
     */
    public E minimum(){
        if(size == 0){
            throw new IllegalArgumentException("容器为null");
        }
        return minimum(root).e;
    }

    public E removeMin(){
        E ret = minimum();
        removeMin(root);
        return ret;
    }


    public void remove(E e){
        remove(root,e);
    }


    private Node remove(Node node,E e){

        if(node == null){
            return null;
        }

        if(node.e.compareTo(e)>0){
            node.left = remove(node.left,e);
            return node;
        }else if(node.e.compareTo(e)<0){
            node.right = remove(node.right,e);
            return node;
        }else {
            // 左侧没有值
            if(node.left == null){
                Node rightNode = node.right;
                size--;
                node.right = null;
                return rightNode;
            }

            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 左右都有值，右侧最小值
            Node minRightNode = minimum(node.right);
            minRightNode.right = removeMin(node.right);
            minRightNode.left = node.left;
            node.left = null;
            node.right = null;
            return minRightNode;
        }
    }

    /**
     * 删除最小元素
     * @param node
     * @return
     */
    private Node removeMin(Node node){

        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    public boolean contains(Node node,E e){
        if(node == null){
            return false;
        }

        if(node.e.compareTo(e)>0){
            return contains(node.left,e);
        }
        if(node.e.compareTo(e)<0){
            return contains(node.right,e);
        }else {
            return true;
        }
    }

    /**
     * 不支持添加相同元素
     * @param node
     * @param e
     * @return
     */
    public Node add(Node node,E e){
        if(node == null){
            size++;
            return new Node(e);
        }

        if(node.e.compareTo(e)>0){
            node.left = add(node.left,e);
        }else if(node.e.compareTo(e)<0){
            node.right = add(node.right,e);
        }
        return node;
    }

}
