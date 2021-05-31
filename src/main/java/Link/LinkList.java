package Link;

/**
 * The type Link list.
 *
 * @param <E>  the type parameter
 */
public class LinkList<E> {

    /**
     * The type Node.
     */
public class Node{
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
         *
         * @param node the node
         */
public Node(Node node){
            this(null,node);
        }

        /**
         * Instantiates a new Node.
         */
public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head;
    private int size;

    /**
     * Instantiates a new Link list.
     */
public LinkList(){
        head = null;
        size = 0;
    }

    /**
     * Add first.
     *
     * @param e the e
     */
// 头部增加元素
    public void addFirst(E e){
        if(this.head == null){
            this.head = new Node(e,null);
            size++;
            return;
        }
        this.head = new Node(e,this.head);
        size ++;
    }

    /**
     * Add.
     *
     * @param e the e
     * @param index the index
     */
// 指定位置添加元素
    public void add(E e,int index){
        if(index<0 || index>size){
            throw new IllegalArgumentException("index out bound");
        }

        if(index == 0){
            addFirst(e);
            return;
        }

        Node pre = head;
        for(int i=0;i<index-1;i++){
            pre = pre.next;
        }
        pre.next = new Node(e,pre.next);
        size++;
    }

    @Override
    public String toString(){
        // 遍历
        StringBuilder sb = new StringBuilder();
        Node cur = head;
        while (cur != null){
            sb.append(cur.e);
            cur = cur.next;
            if(!(cur == null)){
                sb.append(",");
            }
        }
        return sb.toString();
    }


    /**
     * Main.
     *
     * @param args the args
     */
public static void main(String[] args){
        LinkList linkList = new LinkList();
        linkList.addFirst(10);
        linkList.addFirst(2);
        linkList.addFirst(3);
        linkList.addFirst(4);
        linkList.add(20,2);
        System.out.println(linkList);
    }


}
