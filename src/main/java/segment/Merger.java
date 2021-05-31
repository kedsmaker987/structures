package segment;

/**
 * 线段树融合
 *
 * @param <E> the type parameter
 */
public interface Merger<E> {

  /**
   * Merge e.
   *
   * @param a the a
   * @param b the b
   * @return the e
   */
  E merge(E a, E b);
}
