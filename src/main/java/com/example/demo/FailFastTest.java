package com.example.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastTest {
    //public  static ArrayList<String> list = new ArrayList<>();
    public  static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        //两个线程同时对一个ArrayList进行操作
        new ThreadOne().start();
        new ThreadTwo().start();


    }

    //使用迭代器遍历
    public static void printSomething(){
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
    }
    //创建线程一: 向list中依次添加数据,并全部打印
    private static class ThreadOne extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                list.add("线程一"+i);
                printSomething();
            }
        }

    }
    //创建线程二:向list中依次添加数据,并全部打印
    private static class ThreadTwo extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                list.add("线程二"+i);
                printSomething();
            }
        }

    }
}
