package com.example.demo;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class NumTest {
    //内部枚举 枚举四大部分: 有限指定的枚举常量,私有的成员变量,满参的构造器,对外暴露的getter方法
    private enum SizeEnum {
        SMALL("S"), MEDIUM("M"), LARGE("L");
        //成员变量
        private String size;

        //构造器
        SizeEnum(String size) {
            this.size = size;
        }

        //getter
        public String size() {
            return size;
        }
    }

    //内部类的测试
    public static class InnerClass{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    /*public void testMethod(){
        //访问内部类
        InnerClass innerClass = new InnerClass();
        System.out.println(innerClass.name);
    }*/



    public static void main(String[] args) {
        //基本数据类型的装箱过程
        Integer value = Integer.valueOf(9);
        //可以这么写,但是没必要 直接Integer value=9即可(自动装箱)

        //String的valueOf()方法的使用,将其他类型转换为String类
        String s = String.valueOf(1);

        //枚举也有valueOf()方法,要求参数必须是枚举中存在的枚举常量
        //若不存在该常量,直接报非法参数异常
        /*
        SizeEnum big = SizeEnum.valueOf("BIG");
        //IllegalArgumentException: No enum constant com.example.demo.NumTest.SizeEnum.big 没有该枚举常量
        System.out.println(big);
        */

        //Phone枚举中含有"HUAWEI"枚举常量
        Phone huawei = Phone.valueOf("HUAWEI");
        System.out.println(huawei);//HUAWEI

        //另一种构造方法
        Phone xiaomi = Phone.valueOf(Phone.class, "XIAOMI");
        System.out.println(xiaomi);// XIAOMI

        //测试获取枚举常量的成员变量
        String origin = Phone.XIAOMI.origin();

        //ordinal 序数 枚举中自带的方法,获取该枚举常量的次序(从0开始)
        System.out.println(SizeEnum.MEDIUM.ordinal() );//1
        //注意SizeEnum是一个内部枚举,可以直接访问其成员,若是Phone这个枚举,那就只能通过get方法来获取了
        System.out.println( SizeEnum.SMALL.size);//S

        //据说这是一个可以避免快速失败的集合容器,普通容器在多线程对同一集合相同内容操作会出现ConcurrentModificationException
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();


        //JDK新特性检验--Optional容器
        if (Optional.ofNullable(SizeEnum.LARGE.size()).isPresent()) {
            System.out.println("成了");
        }


    }

}
