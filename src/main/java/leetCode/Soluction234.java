package leetCode;

/**
 * @auth hukj001
 **/
public class Soluction234 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        ListNode faster = head;
        ListNode slower = head;
        while (faster!=null && faster.next!=null){
            faster = faster.next.next;
            slower = slower.next;
        }

        // 反转链表
        slower = reserver(null,slower);
        while (slower!=null){
            if(slower.val!=head.val){
                return false;
            }
            slower = slower.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reserver(ListNode pre,ListNode node){
          if(node == null){
              return pre;
          }
          ListNode nextNode = node.next;
          node.next = pre;
          pre = node;
          return reserver(pre,nextNode);
    }
}
