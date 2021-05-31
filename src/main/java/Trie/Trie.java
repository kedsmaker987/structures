package Trie;

import java.util.TreeMap;

/**
 * 字典树
 */
public class Trie {

    private class Node{

        /**
         * The Is word.
         */
public boolean isWord;
        /**
         * The Next.
         */
public TreeMap<Character,Node> next;

        /**
         * Instantiates a new Node.
         *
         * @param isWord the is word
         */
public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        /**
         * Instantiates a new Node.
         */
public Node(){
            this(false);
        }
    }

    private Node root;
    private int size;

    /**
     * Instantiates a new Trie.
     */
public Trie(){
        root = new Node();
        size = 0;
    }

    /**
     * Get size int.
     *
     * @return the int
     */
public int getSize(){
        return size;
    }

    /**
     * Add.
     *
     * @param word the word
     */
// 新加单词
    public void add(String word){
        Node cur = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }

        if(!cur.isWord){
            cur.isWord = true;
            size++;
        }
    }


    /**
     * Contains boolean.
     *
     * @param word the word
     * @return the boolean
     */
public boolean contains(String word){
        Node cur = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }
}
