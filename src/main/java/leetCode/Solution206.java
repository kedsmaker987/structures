package leetCode;

/**
 * @auth hukj001
 * leetcode 206 反转链表
 **/
public class Solution206 {

    public class Node{
        private int val;
        private Node next;
        public Node(int val,Node next){
            this.val = val;
            this.next = next;
        }
        public Node(){

        }

        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    public Node reverseList(Node node){
        return reverseList(null,node);
    }

    /**
     *
     * @param pre 链表前驱
     * @param cur 链表当前节点
     * @return
     */
    private Node reverseList(Node pre,Node cur){
       if (cur == null){
           return pre;
       }

       Node nextNode = cur.next;
       cur.next = pre;
       pre = cur;
       return reverseList(pre,nextNode);

    }
}
