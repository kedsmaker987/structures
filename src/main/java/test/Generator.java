package test;

import java.util.function.Consumer;

public class Generator<T> {

    public void showKey(T key){

    }

    public <E> E pop(E e){
        return e;
    }


    public void test(){
        Consumer<String> consuemer = System.out::println;
        consuemer.accept("hello");
    }




}
