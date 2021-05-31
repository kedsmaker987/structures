package test;

/**
 * 插入排序
 */
public class InsertSort {

    /**
     * Sort.
     *
     * @param <T>  the type parameter
     * @param arr the arr
     */
public static <T extends Comparable<T>> void sort(T[] arr){

        for(int i=0;i<arr.length;i++){
            for(int j=i;j>1 &&arr[j].compareTo(arr[j-1])<0;j--){
                swap(arr,j,j-1);
            }
        }
    }

    private static <T extends Comparable<T>> void swap(T[] arr,int i,int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Main.
     *
     * @param args the args
     */
public static void main(String[] args){
        Integer[] arr = new Integer[]{1,7,9,11,24,2,5,7,8};
        InsertSort.sort(arr);
        loop(arr);
    }

    /**
     * Loop.
     *
     * @param <T>  the type parameter
     * @param arr the arr
     */
public static <T> void loop(T[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
