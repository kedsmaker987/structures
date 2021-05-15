package setAndMap;

import java.util.ArrayList;

public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> {


    private Node root;
    private int size;

    public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperatioin.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            BSTMap<String, Integer> map = new BSTMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }

    @Override
    public void add(K key, V value) {
        root = add(root,key,value);
    }

    private Node add(Node node,K key,V value){
        if(node == null){
            size++;
            return new Node(key,value);
        }

        if(key.compareTo(node.key)<0){
             node.left = add(node.left,key,value);
        }else

        if(key.compareTo(node.key)>0){
            node.right = add(node.right,key,value);
        }else {

            // 两者相等,相当于修改
            node.value = value;

        }

        return node;
    }

    private Node getNode(Node node,K key){

        if(node == null){
            return null;
        }


        if(key.compareTo(node.key)<0){
            return getNode(node.left,key);
        }

        if(key.compareTo(node.key)>0){
            return getNode(node.right,key);
        }

        return node;

    }

    @Override
    public V remove(K key) {
        // 查询到这个元素
        Node node = getNode(root, key);
        if(node!=null){
            // 删除元素
            root = remove(root,key);
            return node.value;
        }
        return null;
    }



    @Override
    public boolean contains(K key) {
        Node node = getNode(root, key);
        return node != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null?null:node.value;
    }

    private Node minimum(Node node){
        if(node.left ==null){
            return node;
        }
        return minimum(node.left);
    }

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


    private Node remove(Node node,K key){
        if(node == null){
            return node;
        }

        if(key.compareTo(node.key)<0){
            node.left = remove(node.left,key);
            return node;
        }

        if(key.compareTo(node.key)>0){
            node.right = remove(node.right,key);
            return node;
        }

        // 以下是相等的情况
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        // 左右都有元素
        // 右侧最小值
        Node minimum = minimum(node.right);
        minimum.left = node.left;
        minimum.right = removeMin(node.right);

        node.left = null;
        node.right =null;
        return minimum;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if(node == null){

        }else {
            node.value = newValue;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class Node{
        public Node left,right;
        private K key;
        private V value;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }
}
