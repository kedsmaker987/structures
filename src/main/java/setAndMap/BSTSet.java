package setAndMap;

/**
 * The type Bst set.
 *
 * @param <E>  the type parameter
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    /**
     * Instantiates a new Bst set.
     */
public BSTSet(){
        bst = new BST<>();
    }

    public void add(E e) {
        bst.add(e);
    }

    public boolean contains(E e) {
        return bst.contains(e);
    }

    public void remove(E e) {
        bst.remove(e);
    }

    public int getSize() {
        return bst.getSize();
    }

    public boolean isEmpty() {
        return bst.isEmpty();
    }
}

