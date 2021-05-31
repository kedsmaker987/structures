package test;

import java.util.function.Consumer;

/**
 * The type Generator.
 *
 * @param <T>  the type parameter
 */
public class Generator<T> {

    /**
     * Show key.
     *
     * @param key the key
     */
public void showKey(T key){

    }

    /**
     * Pop e.
     *
     * @param <E>  the type parameter
     * @param e the e
     * @return the e
     */
public <E> E pop(E e){
        return e;
    }


    /**
     * Test.
     */
public void test(){
        Consumer<String> consuemer = System.out::println;
        consuemer.accept("hello");
    }




}
