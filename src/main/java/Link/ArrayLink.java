package Link;

/**
 * 链表 此链表有头结点
 * @param <E>
 */
public class ArrayLink<E> {

    public class Node{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node(Node node) {
            this(null, node);
        }

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

    public ArrayLink(){
        dummyHead = new Node();
        size  = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }

    // 新增元素
    public void add(int index,E e){
        Node pre = dummyHead;
        for(int i=0;i<index;i++){
            pre = pre.next;
        }
        pre.next = new Node(e,pre.next);
        size++;
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void addLast(E e){
        add(size,e);
    }

    // 获取下标值
    public E get(int index){
        Node cur = dummyHead.next;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        return cur.e;
    }

    // 队列首
    public E getFirst(){
        return get(0);
    }

    // 获取最后一个
    public E getLast(){
        return get(size-1);
    }

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

    // 从链表中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

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
