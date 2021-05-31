package ArrayStack;


/**
 * The type Array.
 *
 * @param <T>  the type parameter
 */
public class Array<T> {

    private T[] data;

    private int size;

    /**
     * Instantiates a new Array.
     *
     * @param capacity the capacity
     */
public Array(int capacity){
        data = (T[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * Instantiates a new Array.
     */
public Array(){
        this(10);
    }

    /**
     * Get size int.
     *
     * @return the int
     */
// 数组长度
    public int getSize(){
        return size;
    }

    /**
     * Get capacity int.
     *
     * @return the int
     */
// 数组容量
    public int getCapacity(){
        return data.length;
    }

    /**
     * Add.
     *
     * @param index the index
     * @param t the t
     */
// 添加标准元素
    public void add(int index,T t){
        if(index>size || index<0){
            throw new IllegalArgumentException("Add fail, Request index >=0 and index <= size. ");
        }

        for(int i= size -1;i>=index;i--){
            data[i+1] = data[i];
        }

        data[index] = t;
        size++;
        if(size==getCapacity()){
            resize(getCapacity()*2);
        }
    }

    /**
     * Add first.
     *
     * @param t the t
     */
// 添加队头
    public void addFirst(T t){
        add(0,t);
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
public boolean isEmpty(){
        return size ==0;
    }

    /**
     * Add last.
     *
     * @param t the t
     */
// 添加到队尾
    public void addLast(T t){
        add(size,t);
    }

    /**
     * Contains boolean.
     *
     * @param t the t
     * @return the boolean
     */
// 是否包含元素
    public boolean contains(T t){
        for(int i=0;i<size;i++){
            if(data[i].equals(t)){
                return true;
            }
        }
        return false;
    }

    /**
     * Get t.
     *
     * @param index the index
     * @return the t
     */
public T get(int index){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("Remove fail, method doesn't support index out range ");
        }
        return data[index];
    }

    /**
     * Remove t.
     *
     * @param index the index
     * @return the t
     */
// 删除元素
    public T remove(int index){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("Remove fail, method doesn't support index out range ");
        }
        T t = data[index];
        for(int i=index;i<size;i++){
            data[i] = data[i+1];
        }

        size--;
        if(size <=getCapacity()/4 && getCapacity()/2!=0){
            resize(getCapacity()/2);
        }
        data[size] = null;
        return t;
    }

    /**
     * Remove first t.
     *
     * @return the t
     */
public T removeFirst(){
        return remove(0);
    }

    /**
     * Remove last t.
     *
     * @return the t
     */
public T removeLast(){
        return remove(size-1);
    }

    /**
     * Find int.
     *
     * @param t the t
     * @return the int
     */
// 查找元素
    public int find(T t){
        for(int i=0;i<size;i++){
            if(data[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Remove element.
     *
     * @param t the t
     */
public void removeElement(T t){
        int index = find(t);
        if(index!=-1){
            remove(index);
        }
    }

    /**
     * Get last t.
     *
     * @return the t
     */
public T getLast(){
        return data[size-1];
    }

    /**
     * Resize.
     *
     * @param newCapacity the new capacity
     */
// 扩容
    public void resize(int newCapacity){
        T[] newData = (T[]) new Object[newCapacity];
        for(int i=0;i<size;i++){
            newData[i] = data[i];
        }
        this.data = newData;
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

}
