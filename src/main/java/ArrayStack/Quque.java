package ArrayStack;

/**
 * The interface Quque.
 *
 * @param <E>  the type parameter
 */
public interface Quque<E> {
    /**
     * Enqueue.
     *
     * @param e the e
     */
// 入队
    public void enqueue(E e);

    /**
     * Dequeue e.
     *
     * @return the e
     */
// 出队
    public E dequeue();

    /**
     * Gets front.
     *
     * @return the front
     */
// 第一个
    E getFront();

    /**
     * Gets size.
     *
     * @return the size
     */
// 队大小
    int getSize();

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
// 是否为null
    boolean isEmpty();
}
