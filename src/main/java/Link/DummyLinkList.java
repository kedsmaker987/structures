package Link;

/**
 * The type Dummy link list.
 *
 * @param <E>  the type parameter
 */
public class DummyLinkList<E> {

    /**
     * The type Node.
     */
public class Node {
        private E e;
        private Node next;

        /**
         * Instantiates a new Node.
         *
         * @param e the e
         * @param next the next
         */
public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        /**
         * Instantiates a new Node.
         *
         * @param e the e
         */
public Node(E e) {
            this(e, null);
        }

        /**
         * Instantiates a new Node.
         *
         * @param node the node
         */
public Node(Node node) {
            this(null, node);
        }

        /**
         * Instantiates a new Node.
         */
public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    /**
     * Instantiates a new Dummy link list.
     */
public DummyLinkList() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * Add.
     *
     * @param index the index
     * @param e the e
     */
public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        pre.next = new Node(e, pre.next);
        size++;
    }

    /**
     * Add first.
     *
     * @param e the e
     */
public void addFirst(E e) {
        add(0, e);
    }

    /**
     * Add last.
     *
     * @param e the e
     */
public void addLast(E e) {
        add(size, e);
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Get e.
     *
     * @param index the index
     * @return the e
     */
public E get(int index) {
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * Gets first.
     *
     * @return the first
     */
public E getFirst() {
        return get(0);
    }

    /**
     * Gets last.
     *
     * @return the last
     */
public E getLast() {
        return get(size - 1);
    }

    /**
     * Contains boolean.
     *
     * @param e the e
     * @return the boolean
     */
public boolean contains(E e) {
        Node cur = dummyHead.next;
        for (int i = 0; i < size; i++) {
            if (cur.e.equals(e)) {
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
            throw new IllegalArgumentException("index out band");
        }

        Node pre = dummyHead;
        for(int i=0;i<index;i++){
            pre = pre.next;
        }
        Node retNode = pre.next;
        pre.next = retNode.next;
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
        return remove(size -1);
    }

    /**
     * Remove element.
     *
     * @param e the e
     */
public void removeElement(E e){
       Node pre = dummyHead;
       while (pre.next !=null){
            if(pre.e.equals(e)){
                break;
            }
            pre = pre.next;
       }

       if(pre.next!=null){

       }
    }


    /**
     * Set.
     *
     * @param index the index
     * @param e the e
     */
public void set(int index ,E e){
        if(index<0 || index>size){
            throw new IllegalArgumentException("index out band");
        }
        Node cur = dummyHead.next;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            if(cur!=null){
                res.append(cur+"->");
                cur = cur.next;
            }
        }
        return res.toString();
    }

}

