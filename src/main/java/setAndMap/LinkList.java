package setAndMap;

/**
 * 链表
 * 添加头节点
 * @param <E>  the type parameter
 */
public class LinkList<E> {

    private Node dummpHead;
    private int size;
    /**
     * Instantiates a new Link list.
     */
public LinkList(){
        dummpHead = new Node();
        size = 0;
    }

    /**
     * Size int.
     *
     * @return the int
     */
public int size(){
        return size;
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
     * @param index the index
     */
public void add(E e,int index){
        if(index<0 || index>size){
            throw new IllegalArgumentException("index out bound");
        }

        Node pre = dummpHead;
        for(int i=0;i<index;i++){
            pre = pre.next;
        }

        pre.next = new Node(e,pre.next);
        size++;
    }

    /**
     * Add first.
     *
     * @param e the e
     */
public void addFirst(E e){
        add(e,0);
    }

    /**
     * Add last.
     *
     * @param e the e
     */
public void addLast(E e){
        add(e,size);
    }

    /**
     * Get e.
     *
     * @param index the index
     * @return the e
     */
public E get(int index){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("index out bound");
        }
        Node cur = dummpHead.next;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }

        return cur.e;
    }

    /**
     * Get first e.
     *
     * @return the e
     */
public E getFirst(){
        return get(0);
    }

    /**
     * Get last e.
     *
     * @return the e
     */
public E getLast(){
        return get(size-1);
    }

    /**
     * Set.
     *
     * @param index the index
     * @param e the e
     */
public void set(int index,E e){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("index out bound");
        }

        Node cur = dummpHead.next;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * Contains boolean.
     *
     * @param e the e
     * @return the boolean
     */
public boolean contains(E e){
        Node cur = dummpHead.next;
        while (cur!=null){
            if(cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * Remove e.
     *
     * @param index the index
     * @return the e
     */
public E remove(int index){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("index out bound");
        }

        Node pre = dummpHead;
        for(int i=0;i<index;i++){
            pre = pre.next;
        }

        Node retNode = pre.next;
        pre.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    /**
     * Remove first e.
     *
     * @return the e
     */
public E removeFirst(){
        return remove(0);
    }

    /**
     * Remove last e.
     *
     * @return the e
     */
public E removeLast(){
        return remove(size-1);
    }

    /**
     * Remove element.
     *
     * @param e the e
     */
public void removeElement(E e){
        Node pre = dummpHead;
        while (pre.next!=null){
            if(pre.next.e.equals(e)){
                break;
            }
            pre = pre.next;
        }

        if(pre.next!=null){
            Node delNode = pre.next;
            pre.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    @Override
    public String toString(){
        StringBuilder res= new StringBuilder();
        Node cur = dummpHead.next;
        while (cur!=null){
            res.append(cur+"->");
            cur = cur.next;
        }

        res.append("Null");
        return res.toString();
    }

    private class Node{
        private E e;
        private Node next;
        /**
         * Instantiates a new Node.
         *
         * @param e the e
         * @param next the next
         */
public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        /**
         * Instantiates a new Node.
         *
         * @param e the e
         */
public Node(E e){
            this(e,null);
        }

        /**
         * Instantiates a new Node.
         */
public Node(){
            this(null,null);
        }
    }
}
