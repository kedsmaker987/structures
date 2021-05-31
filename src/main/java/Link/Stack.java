package Link;

/**
 * 栈，FILO
 * @param <E>  the type parameter
 */
public interface Stack<E> {

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
     * Push.
     *
     * @param e the e
     */
void push(E e);
    /**
     * Pop e.
     *
     * @return the e
     */
E pop();
    /**
     * Peek e.
     *
     * @return the e
     */
E peek();
}
