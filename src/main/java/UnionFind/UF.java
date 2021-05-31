package UnionFind;

/** The interface Uf. */
public interface UF {
  /**
   * Gets size.
   *
   * @return the size
   */
  int getSize();

  /**
   * Is connected boolean.
   *
   * @param p the p
   * @param q the q
   * @return the boolean
   */
  boolean isConnected(int p, int q);

  /**
   * Union elements.
   *
   * @param p the p
   * @param q the q
   */
  void unionElements(int p, int q);
}
