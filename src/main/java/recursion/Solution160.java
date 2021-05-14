package recursion;

/**
 * 两条链表相交问题
 */
public class Solution160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // 判断两表的长度
        ListNode listA = headA;
        int countA = 0;
        while (listA!=null){
            listA = listA.next;
            countA++;
        }

        ListNode listB = headB;
        int countB = 0;
        while (listB!=null){
            listB = listB.next;
            countB++;
        }

        // 调整两链表数据一致
        if(countA>countB){

            for(int i=0;i<(countA-countB);i++){
                headA = headA.next;
            }
        }

        if(countB>countA){
            for(int i=0;i<(countB-countA);i++){
                headB = headB.next;
            }
        }

        // 对比两表数据

        while (headA!=null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;

    }

}
