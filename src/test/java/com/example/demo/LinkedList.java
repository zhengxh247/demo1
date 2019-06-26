package com.example.demo;

public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }

        public  Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node dummyHead;//虚拟头结点
    private int size;

    public LinkedList(){
        dummyHead=new Node(null,null);
        size=0;
    }

    //获取链表的元素个数
    public int getSize(){
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //在index位置添加元素e
    public void add(int index,E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;
//                Node node=new Node(e);
//                node.next=prev.next;
//                prev.next=node;
            prev.next = new Node(e, prev.next);
            size++;

    }
    //在链表头添加新元素e
    public void addFirst(E e){
//      Node node=new Node(e);
//      node.next=head;
//      head=node;
//        head=new Node(e,head);
//        size++;
        add(0,e);
    }

        //链表末尾添加新的元素
        public void addLast(E e){
            add(size,e);
        }

    //链表删除index位置
    public E remove(int index){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("del failed. Illegal index");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;
        Node retNode= prev.next;
        prev.next=retNode.next;
        retNode.next=null;
        size--;
        return  retNode.e;
    }

    //删除头结点
    public E removeFirst(){
        return remove(0);
    }

    //删除尾结点
    public E removeLast(){
        return remove(size);
    }


    //获得链表index位置的元素
    public E get(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index");
        }

        Node cur=dummyHead.next;
        for (int i = 0; i <index ; i++) {
            cur= cur.next;
        }
        return cur.e;
    }

    //获得第一个元素
    public E getFirst(){
        return get(0);
    }

    //获得链表最后一个元素
    public E getLast(){
        return  get(size-1);
    }

    //修改链表
    public void set(int index,E e){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index");
        }
        Node cur =dummyHead.next;
        for (int i = 0; i <index ; i++) {
            cur=cur.next;
            cur.e=e;
        }
    }

    //是否存在元素e
    public boolean contains(E e){
        Node cur=dummyHead.next;
        while (cur!=null){
            if (cur.e.equals(e))
                return true;
                cur=cur.next;
            }
        return false;
    }


    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
//        Node cur =dummyHead.next;
//        while(cur!=null){
//            res.append(cur+"->");
//            cur=cur.next;
//        }
        for (Node cur =dummyHead.next;cur!=null;cur=cur.next)
            res.append(cur+"->");
        res.append("NULL"+"->");
        return res.toString();
    }
}
