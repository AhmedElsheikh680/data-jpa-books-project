package com.book.javase;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SingletonClass {
    private static final   SingletonClass instance = new SingletonClass();

    private SingletonClass() {

    }
    public static SingletonClass getInstance() {
        return instance;
    }


}
