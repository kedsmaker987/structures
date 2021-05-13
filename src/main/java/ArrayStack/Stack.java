package ArrayStack;

public interface Stack<E> {

    /**数据量**/
    int getSize();

    /****/
    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
