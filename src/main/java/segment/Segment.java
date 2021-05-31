package segment;

/**
 * 线段树
 * @param <E>  the type parameter
 */
public class Segment<E> {
    private E[] data;
    private E[] tree;
    private Merger<E> merger;


    /**
     * Instantiates a new Segment.
     *
     * @param arr the arr
     * @param merger the merger
     */
public Segment(E[] arr,Merger<E> merger){
        data = (E[]) new Object[arr.length];
        for(int i=0;i<arr.length;i++){
            data[i] = arr[i];
        }
        this.merger = merger;

        tree = (E[]) new Object[4*arr.length];
        buildSegment(0,0,data.length-1);
    }

    // 构造线段树
    //treeIndex，线段树节点, 对应的数组下标 l-r
    private void buildSegment(int treeIndex,int l,int r){
        // 最后一行 划分到最底层的数组
        if(l == r){
            tree[treeIndex] =  data[l];
            return;
        }

        // 左下节点
        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);

        // 划分中间节点
        int mid = l+(r-l)/2;
        // 递归左下节点赋值
        buildSegment(leftIndex,l,mid);
        // 递归右下节点赋值
        buildSegment(rightIndex,mid+1,r);
        tree[treeIndex] = merger.merge(tree[leftIndex],tree[rightIndex]);
    }

    /**
     * Get size int.
     *
     * @return the int
     */
public int getSize(){
        return data.length;
    }

    /**
     * Get e.
     *
     * @param index the index
     * @return the e
     */
public E get(int index){
        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal.");
        return data[index];
    }

    /**
     * 查询区间 queryL-queryR的merger值
     * @param queryL the query l
     * @param queryR the query r
     * @return e
     */
public E query(int queryL,int queryR){
        if(queryL < 0 || queryL >= data.length ||
                queryR < 0 || queryR >= data.length || queryL > queryR)
            throw new IllegalArgumentException("Index is illegal.");
        return query(0,0,data.length-1,queryL,queryR);
    }

    /**
     * Query e.
     *
     * @param treeIndex the tree index
     * @param l the l
     * @param r the r
     * @param queryL the query l
     * @param queryR the query r
     * @return treeIndex为根线段树在[l, r]区间范围内, 搜索[queryL, queryR]  的值
     */
public E query(int treeIndex,int l,int r,int queryL,int queryR){
        if(l == queryL && queryR == r){
            return tree[treeIndex];
        }

        // 分割点
        int mid = l +(r-l)/2;
        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);
        if(queryR<=mid){
            return query(leftIndex,l,mid,queryL,queryR);
        }else if(queryL>=mid){
            return query(rightIndex,mid+1,r,queryL,queryR);
        }

        E leftResult = query(leftIndex, l, mid, queryL, mid);
        E rightResult = query(rightIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);
    }

    /**
     * Set.
     *
     * @param index the index
     * @param e the e
     */
public void set(int index, E e){
        if(index<0 || index>=data.length){
            throw new IllegalArgumentException("index 参数不符合要求");
        }
        data[index] = e;
        set(0,0,data.length-1,index,e);
    }

    /**
     * Set.
     *
     * @param treeIndex the tree index
     * @param l the l
     * @param r the r
     * @param index the index
     * @param e  treeIndex根节点在 [l,r]区间更新index 为e
     */
public void set(int treeIndex,int l,int r,int index,E e){
        if(l == r){
            tree[treeIndex] = e;
            return;
        }

        int mid = l + (r-l)/2;
        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);

        // 右边
        if(index>=mid+1){
            set(rightIndex,mid+1,r,index,e);
        }else {
            set(leftIndex,l,mid,index,e);
        }

        tree[treeIndex] = merger.merge(tree[leftIndex],tree[rightIndex]);
    }



    // 左下节点
    private int leftChild(int index){
        return 2*index+1;
    }

    // 右下节点
    private int rightChild(int index){
        return 2*index+2;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append('[');
        for(int i = 0 ; i < tree.length ; i ++){
            if(tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if(i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
