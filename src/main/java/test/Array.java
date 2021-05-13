package test;


public class Array<T> {

    private T[] data;

    private int size;

    public Array(int capacity){
        data = (T[]) new Object[capacity];
        this.size = 0;
    }

    public Array(){
        this(10);
    }

    // 数组长度
    public int getSize(){
        return size;
    }

    // 数组容量
    public int getCapacity(){
        return data.length;
    }

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

    // 添加队头
    public void addFirst(T t){
        add(0,t);
    }

    // 添加到队尾
    public void addLast(T t){
        add(size,t);
    }

    // 是否包含元素
    public boolean contains(T t){
        for(int i=0;i<size;i++){
            if(data[i].equals(t)){
                return true;
            }
        }
        return false;
    }

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

    public T removeFirst(){
        return remove(0);
    }

    public T removeLast(){
        return remove(size-1);
    }

    // 查找元素
    public int find(T t){
        for(int i=0;i<size;i++){
            if(data[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

    public void removeElement(T t){
        int index = find(t);
        if(index!=-1){
            remove(index);
        }
    }

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
