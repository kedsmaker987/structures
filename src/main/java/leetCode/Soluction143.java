package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @auth hukj001
 **/
public class Soluction143 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private Set<ListNode> setList = new HashSet<>();
    public boolean hasCycle(ListNode head) {
        while (head!=null){
            if(setList.contains(head)){
                return true;
            }
            setList.add(head);
            head = head.next;
        }
        return false;
    }

}
