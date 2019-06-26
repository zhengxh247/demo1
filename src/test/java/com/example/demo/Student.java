package com.example.demo;

public class Student {
    private  String name;
    private  int score;

    public Student(String stuName,int stuSore){
        this.name=stuName;
        this.score=stuSore;
    }

    @Override
    public String toString(){
        return String.format("Student(name:%s,score:%d)",name,score);
    }
    public  static void main(String[] args){
        EArray<Student> array=new EArray<>();
        array.addArray(new Student("zxh",50));
        array.addArray(new Student("sda",162));
        System.out.println(array);
    }
}
