package setAndMap;

import java.util.ArrayList;

/**
 * The type Main.
 */
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<String>();
        if(FileOperatioin.readFile("1.txt",words1)){
            System.out.println("Total words: "+words1.size());
            BSTSet<String> set1 = new BSTSet<String>();
            for(String word: words1){
                set1.add(word);
            }
            System.out.println("differ words: "+set1.getSize());
        }
    }
}
