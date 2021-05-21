package segment;

/**
 * 线段树融合
 */
public interface Merger<E> {

    E merge(E a,E b);
}
