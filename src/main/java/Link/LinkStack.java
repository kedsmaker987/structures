package Link;

/**
 * The type Link stack.
 *
 * @param <E>  the type parameter
 */
public class LinkStack<E> implements Stack<E> {

    private ArrayLink<E> arrayLink;

    /**
     * Instantiates a new Link stack.
     */
public LinkStack(){
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
    public void push(E e) {
        arrayLink.addLast(e);
    }

    @Override
    public E pop() {
        return arrayLink.removeLast();
    }

    @Override
    public E peek() {
        return arrayLink.getLast();
    }
}
