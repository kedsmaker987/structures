package avl;

import Trie.FileOperation;
import setAndMap.Map;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * avl树 @param <K> the type parameter
 *
 * @param <V> the type parameter
 */
public class AVLTree<K extends Comparable<K>, V> {

  public class Node{
    public K key;
    public V value;
    public Node left,right;
    public int height;

    public Node(K key,V value){
      this.key = key;
      this.value = value;
      left = right = null;
      height = 1;
    }

  }

  private Node root;
  private int size;

  public AVLTree(){
    root = null;
    size = 0;
  }

  public int getSize(){
    return size;
  }

  public boolean isEmpty(){
    return size == 0;
  }

  // node节点高度
  private int getHeight(Node node){
    if(node == null){
      return 0;
    }
    return node.height;
  }

  // node节点平衡因子 左-右
  private int getBalanceFactory(Node node){
    if(node == null){
        return 0;
    }
    return getHeight(node.left) - getHeight(node.right);
  }

  // 二分搜索添加元素
  public void add(K key,V value){
    root = add(root,key,value);
    if(Math.abs(getBalanceFactory(root))>1){
      System.out.println("error  : "+getBalanceFactory(root));
    }
  }

  // 递归添加元素
  private Node add(Node node,K key,V value){
    if(node == null){
      size++;
      return new Node(key,value);
    }

    // 添加到左子树
    if(node.key.compareTo(key)>0){
      node.left = add(node.left,key,value);
    }else if(node.key.compareTo(key)<0){
      node.right = add(node.right,key,value);
    }else {
      // node.key = key
      node.value = value;
    }

    // 更新node高度 (左右子树最大高度+1)
    node.height = 1+ Math.max(getHeight(node.left),getHeight(node.right));

    // 平衡因子
    int balanceFactory = getBalanceFactory(node);

    // 平衡因子是左-(减去)右,左子树平衡因子也大于0，右转
    if(balanceFactory>1 && getBalanceFactory(node.left)>=0){
        return rightRotate(node);
    }

    // 左子树,右节点,先让节点left左转,在右转节点
    if(balanceFactory>1 && getBalanceFactory(node.left)<0){
      node.left = leftRote(node.left);
      return rightRotate(node);
    }

    //rr 左转
    if(balanceFactory<-1 && getBalanceFactory(node.right)<=0){
        return leftRote(node);
    }

    // 右子树，左节点,先让节点right右转,再左转节点
    if(balanceFactory<-1 && getBalanceFactory(node.right)>0){
        node.right = rightRotate(node.right);
        return leftRote(node);
    }



    return node;
  }

  // ll 右转
  private Node rightRotate(Node y){
      Node x = y.left;
      Node t3 = x.right;
      x.right = y;
      y.left = t3;
      // 更改旋转后高度
      y.height = 1+Math.max(getHeight(y.left),getHeight(y.right));
      x.height = 1+Math.max(getHeight(x.left),getHeight(x.right));
      return x;
  }

  // rr 左转
  private Node leftRote(Node y){
      Node x = y.right;
      Node t3 = x.left;
      x.left = y;
      y.right = t3;
    // 更改旋转后高度
      // 只有y正确,x才能正确
      y.height = 1+Math.max(getHeight(y.left),getHeight(y.right));
      x.height = 1+Math.max(getHeight(x.left),getHeight(x.right));
      return x;
  }




  /**
   * 获取key对应的value
   * @param key
   * @return
   */
  public V get(K key){
    Node node = getNode(root, key);
    return node == null?null:node.value;
  }

  /**
   * 是否包含key值
   * @param key
   * @return
   */
  public boolean contains(K key){
    return getNode(root,key) == null?false:true;
  }

  public void set(K key, V newValue){
    Node node = getNode(root, key);
    if(node == null)
      throw new IllegalArgumentException(key + " doesn't exist!");

    node.value = newValue;
  }

  // 递归获取key对应的节点
  private Node getNode(Node node,K key){
    if(node == null){
        return null;
    }
    if(node.key.compareTo(key)<0){
      return getNode(node.right,key);
    }else if(node.key.compareTo(key)>0){
      return getNode(node.left,key);
    }
    // node.key = key
    return node;
  }


  /**
   * 获取已node为根的最小节点
   * @param node
   * @return
   */
  private Node minimum(Node node){
    if(node.left == null){
      return node;
    }
    return minimum(node.left);
  }

  /**
   * 递归删除最小节点
   * @param node
   * @return
   */
  private Node removeMin(Node node){

    // 最小节点
    if(node.left == null){
        Node rightNode = node.right;
        size--;
        node.right =null;
        return rightNode;
    }
    node.left = removeMin(node.left);
    return node;
  }

  // 从二分搜索树中删除键为key的节点
  public V remove(K key){

    Node node = getNode(root, key);
    if(node != null){
      root = remove(root, key);
      return node.value;
    }
    return null;
  }

  /**
   * 常规：递归删除key节点
   * @param node
   * @param key
   * @return
   */
  private Node remove(Node node,K key){
    if(node == null){
        return null;
    }

    Node retNode;
    if(node.key.compareTo(key)>0){
        node.left = remove(node.left,key);
        retNode = node;
    }else if(node.key.compareTo(key)<0){
        node.right = remove(node.right,key);
        retNode =  node;
    }else { // node.key = key
        // 左节点为null
        if(node.left == null){
            Node rightNode = node.right;
            size--;
            node.right = null;
            retNode = rightNode;
        }else

        // 右节点为null
      if(node.right == null){
          Node leftNode = node.left;
          size--;
          node.left = null;
          retNode =  leftNode;
      } else {

        // 左右子节点都不为null,取右节点最小值
        Node minRightNode = minimum(node.right);
        // 删除最小值
        minRightNode.right = removeMin(node.right);
        minRightNode.left = node.left;
        node.left = node.right = null;
        retNode = minRightNode;
      }
    }

    if(retNode == null)
      return null;

    retNode.height = 1+ Math.max(getHeight(retNode.left), getHeight(retNode.right));
    // 计算平衡因子
    int balanceFactor = getBalanceFactory(retNode);

    // 平衡维护
    // LL
    if (balanceFactor > 1 && getBalanceFactory(retNode.left) >= 0)
      return rightRotate(retNode);

    // RR
    if (balanceFactor < -1 && getBalanceFactory(retNode.right) <= 0)
      return leftRote(retNode);

    // LR
    if (balanceFactor > 1 && getBalanceFactory(retNode.left) < 0) {
      retNode.left = leftRote(retNode.left);
      return rightRotate(retNode);
    }

    // RL
    if (balanceFactor < -1 && getBalanceFactory(retNode.right) > 0) {
      retNode.right = rightRotate(retNode.right);
      return leftRote(retNode);
    }

    return retNode;

  }

  public boolean isBalanced(){
    return isBalanced(root);
  }

  // 判断是否是一棵平衡二叉树，递归算法
  private boolean isBalanced(Node node){
    if(node == null){
        return true;
    }

    int balanceFactory = getBalanceFactory(node);
    if(Math.abs(balanceFactory)>1){
      return false;
    }
    return isBalanced(node.left) && isBalanced(node.right);
  }

  public static void main(String[] args){
    System.out.println("Pride and Prejudice");

    ArrayList<String> words = new ArrayList<>();
    if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
      System.out.println("Total words: " + words.size());

      AVLTree<String, Integer> map = new AVLTree<>();
      for (String word : words) {
        if (map.contains(word))
          map.set(word, map.get(word) + 1);
        else
          map.add(word, 1);
      }

      System.out.println("Total different words: " + map.getSize());
      System.out.println("Frequency of PRIDE: " + map.get("pride"));
      System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));

//      System.out.println("is BST : " + map.isBST());
      System.out.println("is Balanced : " + map.isBalanced());

      for(String word: words){
        map.remove(word);
      }
    }
    System.out.println();
  }
}
