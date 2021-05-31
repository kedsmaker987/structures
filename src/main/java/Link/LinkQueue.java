package Link;

/**
 * The type Link queue.
 *
 * @param <E>  the type parameter
 */
public class LinkQueue<E> implements Queue<E> {

    private ArrayLink<E> arrayLink;

    /**
     * Instantiates a new Link queue.
     */
public LinkQueue(){
        arrayLink = new ArrayLink<>();
    }
    @Override
    public int getSize() {
        return arrayLink.getSize();
    }

    @Override
    public boolean isEmpty() {
        return arrayLink.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        arrayLink.addLast(e);
    }

    @Override
    public E dequeue() {
        return arrayLink.removeFirst();
    }

    @Override
    public E getFront() {
        return arrayLink.getFirst();
    }
}
