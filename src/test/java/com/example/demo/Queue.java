package com.example.demo;

public interface Queue <E>{
    int getSize();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
