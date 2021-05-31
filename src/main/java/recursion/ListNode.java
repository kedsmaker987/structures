package recursion;

/**
 * The type List node.
 */
public  class ListNode {
    /**
     * The Val.
     */
int val;
    /**
     * The Next.
     */
ListNode next;
    /**
     * Instantiates a new List node.
     */
ListNode() {}
    /**
     * Instantiates a new List node.
     *
     * @param val the val
     */
ListNode(int val) { this.val = val; }
    /**
     * Instantiates a new List node.
     *
     * @param val the val
     * @param next the next
     */
ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    /**
     * Instantiates a new List node.
     *
     * @param arr the arr
     */
public ListNode(int[] arr){
        this.val = arr[0];
        ListNode cur = this;
        for(int i=1;i<arr.length;i++){
            cur.next = new ListNode(arr[i],null);
            cur = cur.next;
        }
    }

    // 以当前节点为头结点的链表信息字符串
    @Override
    public String toString(){

        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        while(cur != null){
            s.append(cur.val + "->");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}
