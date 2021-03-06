package test;

/**
 * ιζ©ζεΊ
 */
public class SelectSort {

    /**
     * Sort.
     *
     * @param <T>  the type parameter
     * @param arr the arr
     */
public static <T extends Comparable<T>> void sort(T[] arr) {
        for(int i=0;i<arr.length;i++){
            int minIndex = i;
            for(int j=i;j<arr.length;j++){
                if(arr[minIndex].compareTo(arr[j])<0){
                    minIndex = j;
                }
            }
            swap(arr,minIndex,i);
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
