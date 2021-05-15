package setAndMap;

/**
 * 集合
 * @param <E>
 */
public interface Set<E> {

    void add(E e);

    boolean contains(E e);

    void remove(E e);

    int getSize();

    boolean isEmpty();

}
