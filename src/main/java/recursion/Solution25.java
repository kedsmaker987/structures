package recursion;

/**
 * k数组反转
 */
public class Solution25 {

    /**
     * Reverse k group list node.
     *
     * @param head the head
     * @param k the k
     * @return the list node
     */
// 递归，反转
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null){
            return head;
        }

        // 计算当前链表长度
        int count = 0;
        ListNode cur = head;
        while (cur!=null){
            cur = cur.next;
            count++;
        }

        // 小于k,链表不反转
        if(count<k){
            return head;
        }

        ListNode preNode = null;// 前一个元素
        ListNode curNode = head;// 当前元素
        // 链表 0-k做反转
        for(int i=0;i<k;i++){
            ListNode temp = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = temp;
        }

        // head变成队尾
        head.next = reverseKGroup(curNode,k);
        return preNode;
    }
}
