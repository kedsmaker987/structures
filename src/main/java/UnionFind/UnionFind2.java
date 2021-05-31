package UnionFind;

/** The type Union find 2. */
public class UnionFind2 implements UF {

    private int[] parent; // 记录每一个元素对应的父坐标，和元素实际值没有关系

  /**
   * Instantiates a new Union find 2.
   *
   * @param size the size
   */
  // 默认赋值
  public UnionFind2(int size) {
       parent = new int[size];
       for(int i=0;i<size;i++){
           parent[i] = i;
       }
    }
    @Override
    public int getSize() {
        return parent.length;
    }

    // 查找p对应合集编码
    private int find(int p){
        if(p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");

        while (p!=parent[p]){
            p =parent[p];
        }
        return p;
    }



    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if(pId == qId){
            return;
        }
        // 遍历所有元素
       parent[pId] = qId;
    }
}
