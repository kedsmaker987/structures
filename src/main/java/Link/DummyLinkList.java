package Link;

public class DummyLinkList<E> {

    public class Node {
        private E e;
        private Node next;

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

    private Node dummyHead;
    private int size;

    public DummyLinkList() {
        dummyHead = new Node();
        size = 0;
    }

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

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public E get(int index) {
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

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


    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size -1);
    }

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

