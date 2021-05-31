package Link;

/**
 * The interface Queue.
 *
 * @param <E>  the type parameter
 */
// FIFO
public interface Queue<E> {

    /**
     * Gets size.
     *
     * @return the size
     */
int getSize();
    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
boolean isEmpty();
    /**
     * Enqueue.
     *
     * @param e the e
     */
void enqueue(E e);
    /**
     * Dequeue e.
     *
     * @return the e
     */
E dequeue();
    /**
     * Gets front.
     *
     * @return the front
     */
E getFront();
}
