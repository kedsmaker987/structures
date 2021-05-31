package ArrayStack;

/**
 * The type Array queue.
 *
 * @param <E>  the type parameter
 */
public class ArrayQueue<E> implements Quque<E> {

    private Array<E> array;

    /**
     * Instantiates a new Array queue.
     *
     * @param capacity the capacity
     */
public ArrayQueue(int capacity){
        array = new Array(capacity);
    }

    /**
     * Instantiates a new Array queue.
     */
public ArrayQueue(){
        array = new Array();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.get(0);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
public static void main(String[] args) {

        ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
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
