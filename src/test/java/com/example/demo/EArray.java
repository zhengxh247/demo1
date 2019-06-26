package com.example.demo;

public class EArray<E>{
    private E[] data;
    private int size;
    //传入数组的容量构造array
    public  EArray(int capacity){
        data=(E[])new Object[capacity];
        size=0;
    }
    //遍历数组
    public void ArrayDome(int[] arr,int size){
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+",");
        }
        System.out.println("");
    }
    //无参数的构造方法，默认10
    public EArray(){
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
    public void addArray(E a){
        if(size<getCapacity()) {
            data[size] = a;
            size++;
        }
        else{
            throw new IllegalArgumentException("addArray error");
        }
    }
    //数组插入
    public void insert(E a,int index){
        if(index>size||index<0)
            System.out.print("超出数组容量");
        //动态数组扩容
        if(size>=data.length)
        resize(2*data.length);

        for(int i=size-1;i>=index;i--){
            data[i+1]=data[i];
            data[index]=a;
            size++;
        }
    }

    public void addLast(E e){
         data[size]=e;
         size++;
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
    public E get(int index){
        if (index<0||index>size)
            throw new IllegalArgumentException("get false. index");
        return data[index];
    }

    public E getlast(){
        return get(size-1);
    }

    public E getFirst(){
        return get(0);
    }


    //修改index位置的元素
    void set(int index,E a){
        if (index<0||index>size)
            throw new IllegalArgumentException("get false. index");
        data[index-1]=a;
    }
    //查找数组中是否有元素e
    public boolean contains(E a){
        for (E s:data){
            if (s.equals(a))
                return true;
        }
        return false;
    }
    //查找数组元素所在的索引
    public int find(E a){
        if (contains(a)==true){
            for (int i=0;i<size;i++){
                if (data[i]==a)
                    return i+1;
            }
        }
        return -1;
    }
    //数组删除元素
    public E delect(int index){
        if (index<0||index>size){
            throw new IllegalArgumentException("delect false. index");
        }else{
            if (size==data.length/2)
                resize(data.length/2);
            E ret=data[index];
            for (int i=index+1;i<=size+1;i++){
                data[i-1]=data[i];
            }
            size--;
            return ret;
        }

    }
    public E removeFirst(){
        return delect(0);
    }

    public E removeLast()
    {
        return delect(size-1);
    }

    //数组扩容
    private  void resize(int newCapacity){
        E[] newDate=(E[])new Object[newCapacity];
        for(int i=0;i<size;i++)
            newDate[i]=data[i];
        //data对象引用的取代
        data=newDate;
    }
}
