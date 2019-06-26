package com.example.demo;

public interface Stack<E> {
    int getSize();
    void push(E e);
    E pop();
    E peek();
}
