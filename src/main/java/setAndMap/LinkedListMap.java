package setAndMap;

import java.util.ArrayList;

/**
 * The type Linked list map.
 *
 * @param <K>  the type parameter
 * @param <V>  the type parameter
 */
public class LinkedListMap<K,V> implements Map<K,V> {


    private Node dummyHead;
    private int size;
    /**
     * Instantiates a new Linked list map.
     */
public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }

    /**
     * Main.
     *
     * @param args the args
     */
public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperatioin.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            LinkedListMap<String, Integer> map = new LinkedListMap<>();
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

    private Node getNode(K key){
        Node cur = dummyHead.next;
        while (cur!=null){
            if(key.equals(cur.key)){
                break;
            }
            cur = cur.next;
        }
        return cur;
    }


    @Override
    public void add(K key, V value) {
        // map 查询是否有这个元素
        Node node = getNode(key);
        if(node== null){
            // 新增元素 头部新增
            dummyHead.next = new Node(key,value,dummyHead.next);
            size++;
        }else {
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node pre = dummyHead;
        while (pre.next!=null){
            if(pre.next.key.equals(key)){
                break;
            }
            pre = pre.next;
        }

        if(pre.next!=null){
            Node delNode = pre.next;
            pre.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key)!=null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null?null:node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if(node!=null){
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
        /**
         * The Key.
         */
public K key;
        /**
         * The Value.
         */
public V value;

        /**
         * The Next.
         */
public Node next;

        /**
         * Instantiates a new Node.
         *
         * @param key the key
         * @param value the value
         * @param next the next
         */
public Node(K key,V value,Node next){
            this.key = key;
            this.value =value;
            this.next = next;
        }

        /**
         * Instantiates a new Node.
         *
         * @param key the key
         * @param value the value
         */
public Node(K key,V value){
            this(key,value,null);
        }

        /**
         * Instantiates a new Node.
         */
public Node(){
            this(null,null,null);
        }

        public String toString(){
            return key.toString()+" : "+value.toString();
        }
    }
}
