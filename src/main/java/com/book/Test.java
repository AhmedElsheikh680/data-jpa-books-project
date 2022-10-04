package com.book;

public class Test {
    static void print() {
        while (true){
            System.out.println("Hello World");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {

        print();
    }
}
