package ArrayStack;

public class LoopQueue<E> implements Quque<E> {

    private E[] data;
    private int size;
    private int head;int tail;

    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity+1];
        head = tail = 0;
        size= 0;
    }

    public int getCapacity(){
        return data.length -1;
    }

    @Override
    public void enqueue(E e) {
        // 添加直接扩容
        if((tail+1)%data.length == head){
            resize(getCapacity()*2);
        }
        data[tail] = e;
        tail = (tail+1)%data.length;
        size++;
    }

    private void resize(int capactiy) {
        E[] newData = (E[]) new Object[capactiy+1];
        for(int i=0;i<size;i++){
            newData[i] = data[(i+head)%data.length];
        }
        data = newData;
        head= 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            return null;
        }

        E ret = data[head];
        head = (head+1)%data.length;
        size --;
        if(size<=data.length/4 && data.length/2!=0){
            resize(getCapacity()/2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            return null;
        }

        return data[head];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
//        for(int i = head ; i != tail ; i = (i + 1) % data.length){
//            res.append(data[i]);
//            if((i + 1) % data.length != tail)
//                res.append(", ");
//        }

        for(int i=head ;i!=tail; i = (i+1)%data.length){
            res.append(data[i]);
            if((i+1)%data.length !=tail){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args){

        LoopQueue<Integer> queue = new LoopQueue<Integer>(5);
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
