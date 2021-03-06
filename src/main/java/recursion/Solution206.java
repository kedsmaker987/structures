package recursion;

/**
 * 反转链表
 */
public class Solution206 {

    /**
     * Reverse list list node.
     *
     * @param head the head
     * @return the list node
     */
// 方法1:双指针
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode tempNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tempNode;
        }
        return pre;
    }

    /**
     * Reverse list 2 list node.
     *
     * @param head the head
     * @return the list node
     */
public static ListNode reverseList2(ListNode head){
        return reverseList2(null,head);
    }

    /**
     * Reverse list 2 list node.
     *
     * @param pre the pre
     * @param cur the cur
     * @return the list node
     */
public static ListNode reverseList2(ListNode pre,ListNode cur){
        if(cur == null){
            return pre;
        }
        ListNode next = cur.next;
        cur.next = pre;
        return reverseList2(cur,next);

    }

    /**
     * Main.
     *
     * @param args the args
     */
public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4,5};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
        ListNode node = reverseList(listNode);
        System.out.println(node);
    }


}
