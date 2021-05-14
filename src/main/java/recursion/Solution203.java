package recursion;

/**
 * leetcode 203解决方案
 */
public class Solution203 {



  // 删除链表所有val值
  public static ListNode removeElements(ListNode head, int val){
        // 使用头结点
      ListNode dummpHead = new ListNode(-1);
      dummpHead.next = head;

      ListNode pre = dummpHead;
      while (pre.next!=null){
          if(pre.next.val == val){
              pre.next = pre.next.next;
          }else {
              pre = pre.next;
          }
      }
      return dummpHead.next;
  }

}
