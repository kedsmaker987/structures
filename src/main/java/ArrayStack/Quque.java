package ArrayStack;

public interface Quque<E> {
    // 入队
    public void enqueue(E e);

    // 出队
    public E dequeue();

    // 第一个
    E getFront();

    // 队大小
    int getSize();

    // 是否为null
    boolean isEmpty();
}
