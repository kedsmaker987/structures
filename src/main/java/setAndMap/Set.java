package setAndMap;

/**
 * 集合
 * @param <E>  the type parameter
 */
public interface Set<E> {

    /**
     * Add.
     *
     * @param e the e
     */
void add(E e);

    /**
     * Contains boolean.
     *
     * @param e the e
     * @return the boolean
     */
boolean contains(E e);

    /**
     * Remove.
     *
     * @param e the e
     */
void remove(E e);

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

}
