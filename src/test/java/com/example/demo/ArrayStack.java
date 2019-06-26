package com.example.demo;

public class ArrayStack<E> implements Stack<E>{

    EArray<E> array;
    public  ArrayStack(int capacity){
        array=new EArray<>(capacity);
    }

    public ArrayStack(){
        array=new EArray<>();
    }

    @Override
    public int getSize(){
        return array.getSize();
    }

    public int getCapacity(){
        return  array.getCapacity();
    }

    @Override
    public void push(E e){
        array.addLast(e);
    }

    @Override
    public  E pop(){
       return array.removeLast();
    }

    @Override
    public E peek(){
        return array.getlast();
    }

    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for(int i=0;i<array.getSize();i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1)
                res.append(", ");
        }
            res.append("] top");
            return res.toString();
    }
}
