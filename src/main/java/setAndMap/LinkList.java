package setAndMap;

/**
 * 链表
 * 添加头节点
 * @param <E>
 */
public class LinkList<E> {

    private Node dummpHead;
    private int size;
    public LinkList(){
        dummpHead = new Node();
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

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

    public void addFirst(E e){
        add(e,0);
    }

    public void addLast(E e){
        add(e,size);
    }

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

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }

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

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

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
        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }
    }
}
