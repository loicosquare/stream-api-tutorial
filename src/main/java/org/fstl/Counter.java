package org.fstl;

public class Counter <T> {

    T t;

    Counter(T t){
        this.t = t;
    }

    public  void print(){
        System.out.println(t);
    }

    public <T, U> T print2(T t, U u){
        System.out.println(t);
        System.out.println(u);
        return t;
    }
}
