package leetCode;

/**
 * @auth hukj001
 * 两者相交
 **/
public class Soluction160 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    // 将两链表设置为相等
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        int countA = 0;
        ListNode listA = headA;
        while (listA!=null){
            listA = listA.next;
            countA++;
        }

        int countB = 0;
        ListNode listB = headB;
        while (listB!=null){
            listB = listB.next;
            countB++;
        }

        if(countA>countB){
            for(int i=0;i<(countA-countB);i++){
                headA = headA.next;
            }
        }

        if(countA< countB){
            for(int i=0;i<(countB-countA);i++){
                headB = headB.next;
            }
        }

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
