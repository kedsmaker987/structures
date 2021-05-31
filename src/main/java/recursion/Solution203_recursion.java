package recursion;

/**
 * leetcode 203解决方案
 */
public class Solution203_recursion {


  /**
   * Remove elements list node.
   *
   * @param head the head
   * @param val the val
   * @return the list node
   */
// 删除链表所有val值
  public static ListNode removeElements(ListNode head, int val){

        if(head == null){
            return head;
        }
        head.next = removeElements(head.next,val);
        if(head.val == val){
            return head.next;
        }
        return head;
  }

}
