package leetCode;

/**
 * @auth hukj001
 **/
public class Soluction22 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  // 快慢指针
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode front = head;
        ListNode later = head;
        // front先提前
        for (int i=0;i<k;i++){
            front = front.next;
        }

        while (front!=null){
            front = front.next;
            later = later.next;
        }

        return later;
    }
}
