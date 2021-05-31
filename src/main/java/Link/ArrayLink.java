package Link;

/**
 * 链表 此链表有头结点
 * @param <E>  the type parameter
 */
public class ArrayLink<E> {

    /**
     * The type Node.
     */
public class Node{
        /**
         * The E.
         */
public E e;
        /**
         * The Next.
         */
public Node next;

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

    // 虚拟节点
    private Node dummyHead;
    private int size;

    /**
     * Instantiates a new Array link.
     */
public ArrayLink(){
        dummyHead = new Node();
        size  = 0;
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
     * @param index the index
     * @param e the e
     */
// 新增元素
    public void add(int index,E e){
        Node pre = dummyHead;
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
        add(0,e);
    }

    /**
     * Add last.
     *
     * @param e the e
     */
public void addLast(E e){
        add(size,e);
    }

    /**
     * Get e.
     *
     * @param index the index
     * @return the e
     */
// 获取下标值
    public E get(int index){
        Node cur = dummyHead.next;
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
// 队列首
    public E getFirst(){
        return get(0);
    }

    /**
     * Get last e.
     *
     * @return the e
     */
// 获取最后一个
    public E getLast(){
        return get(size-1);
    }

    /**
     * Remove element.
     *
     * @param e the e
     */
// 删除元素
    public void removeElement(E e){
        Node pre = dummyHead;
        while (pre.next!=null){
            if(pre.next.e.equals(e)){
                break;
            }
            pre = pre.next;
        }

        if (pre.next!=null){
            Node res = pre.next;
            pre.next = res.next;
            size--;
        }
    }

    /**
     * Remove e.
     *
     * @param index the index
     * @return the e
     */
// 按下标删除元素
    public E remove(int index){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("参数index 超出限制");
        }

        Node pre = dummyHead;
        for(int i=0;i<index;i++){
            pre = pre.next;
        }

        Node ret = pre.next;
        pre.next = ret.next;
        size--;
        return ret.e;
    }

    /**
     * Remove first e.
     *
     * @return the e
     */
// 从链表中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    /**
     * Remove last e.
     *
     * @return the e
     */
// 从链表中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }


    /**
     * 遍历整个list
     * @return
     */
    @Override
    public String toString(){
        if(isEmpty()){
            return "list is empty";
        }
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        for(int i=0;i<size;i++){
            if(cur!=null){
                res.append(cur.e+"->");
                cur = cur.next;
            }
        }
        return res.toString();
    }


    /**
     * Main.
     *
     * @param args the args
     */
public static void main(String[] args){
        // 测试新增
        ArrayLink link = new ArrayLink();
        link.addFirst(10);
        link.addFirst(12);
        link.addLast(13);
        link.add(2,20);
//        link.removeElement(4);
//        link.remove(3);
        System.out.println(link);
    }
}
