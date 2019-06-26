package com.example.demo;

public class Array{
    private int[] data;
    private int size;
    //传入数组的容量构造array
    public  Array(int capacity){
        data=new int[capacity];
        size=0;
    }
    //遍历数组
    public void ArrayDome(int[] arr,int size){
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+",");
        }
        System.out.println("");
    }
    //无参数的构造方法，默认7
    public Array(){
        this(7);
    }
    //获取数组的元素个数
    public int getSize() {
        return size;
    }
    //获取数组容量
    public int getCapacity(){
        return data.length;
    }
    //添加新元素
    public void addArray(int e){
        if(size<getCapacity()) {
            data[size] = e;
            size++;
        }
        else{
            throw new IllegalArgumentException("addArray error");
        }
    }
    //数组插入
    public void insert(int a,int index){
        if(size>=getCapacity())
            throw new IllegalArgumentException("addArray error");
        if(index>size||index<0)
            System.out.print("超出数组容量");
        for(int i=size-1;i>=index;i--){
            data[i+1]=data[i];
            data[index]=a;
            size++;
        }
    }
    //数组的toString方法实现
    @Override
    public String toString(){
        StringBuilder res =new StringBuilder();
        res.append(String.format("Array:size=%d,capacity=%d\n",size,data.length));
        res.append("[");
        for(int i=0;i<size;i++){
            res.append(data[i]);
            if(i!=size-1)
                res.append(",");
        }
        res.append("]");
        return res.toString();
    }
    //获取索引位置的元素
    int get(int index){
        if (index<0||index>size)
            throw new IllegalArgumentException("get false. index");
        return index;
    }
    //修改index位置的元素
    void set(int index,int a){
        if (index<0||index>size)
            throw new IllegalArgumentException("get false. index");
        data[index-1]=a;
    }
    //查找数组中是否有元素e
    public boolean contains(int a){
        for (int s:data){
            if (s==a)
                return true;
        }
        return false;
    }
     //查找数组元素所在的索引
    public int find(int a){
        if (contains(a)==true){
            for (int i=0;i<size;i++){
               if (data[i]==a)
                   return i+1;
            }
        }
        return -1;
    }
    //数组删除元素
    public void delect(int index){
        if (index<0||index>size){
            throw new IllegalArgumentException("delect false. index");
        }else{
            for (int i=index+1;i<=size+1;i++){
                data[i-1]=data[i];
            }
            size--;
        }
    }
    public static void main(String[] args){
        Array array =new Array();
        array.ArrayDome(array.data,array.size);
        array.addArray(20);
        array.addArray(12);
        array.addArray(50);
        array.addArray(33);
        array.ArrayDome(array.data,array.size);
        array.insert(10,3);
        array.ArrayDome(array.data,array.size);
        System.out.println(array);
        array.get(5);
        array.set(2,105);
        System.out.println(array.contains(235));
        System.out.println(array.find(50));
        array.delect(2);
        array.ArrayDome(array.data,array.size);
    }
}
