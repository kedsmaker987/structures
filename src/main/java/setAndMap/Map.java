package setAndMap;

/**
 * The interface Map.
 *
 * @param <K>  the type parameter
 * @param <V>  the type parameter
 */
public interface Map<K,V> {

    /**
     * Add.
     *
     * @param key the key
     * @param value the value
     */
void add(K key,V value);

    /**
     * Remove v.
     *
     * @param key the key
     * @return the v
     */
V remove(K key);

    /**
     * Contains boolean.
     *
     * @param key the key
     * @return the boolean
     */
boolean contains(K key);

    /**
     * Get v.
     *
     * @param key the key
     * @return the v
     */
V get(K key);

    /**
     * Set.
     *
     * @param key the key
     * @param newValue the new value
     */
void set(K key,V newValue);

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
