package ArrayStack;

/**
 * The type Array stack.
 *
 * @param <E>  the type parameter
 */
public class ArrayStack<E> implements Stack<E> {
    private Array<E> array;

    /**
     * Instantiates a new Array stack.
     */
public ArrayStack(){
        array = new Array<E>();
    }

    /**
     * Instantiates a new Array stack.
     *
     * @param capacity the capacity
     */
public ArrayStack(int capacity){
        array = new Array<E>(capacity);
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
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }
}
