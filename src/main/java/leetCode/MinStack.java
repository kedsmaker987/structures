package leetCode;

/**
 * @auth hukj001
 **/
public class MinStack {

    private class Node{
        private Node next;
        private int value;
        // 每一个栈存最小元素
        private int min;
        public Node(){

        }

        public Node(int value,int min){
            this.value = value;
            this.min = min;
        }

        public Node(int value,int min,Node next){
            this.value = value;
            this.min = min;
            this.next = next;
        }
    }

    private Node head;

    public MinStack() {

    }

    public void push(int val) {
        if(head == null){
            head = new Node(val,val);
        }else {
            head = new Node(val,Math.min(val,head.min),head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.value;
    }

    public int getMin() {
        return head.min;
    }
}
