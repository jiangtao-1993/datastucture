package com.example.demo;

import javax.lang.model.SourceVersion;

public class NumTest {
    private enum SizeEnum{SMALL,MEDIUM,LARGE};

    public static void main(String[] args) {
        Integer value = Integer.valueOf(9); //可以这么写,但是没必要 直接Integer value=9即可
        String s = String.valueOf(1); //将其他类型转换为String类
        //SizeEnum abc = SizeEnum.valueOf("abc");
        //System.out.println("abc = " + abc);
//Exception in thread "main" java.lang.IllegalArgumentException:
// No enum constant com.example.demo.NumTest.SizeEnum.abc 没有该枚举常量
        Phone huawei = Phone.valueOf("HUAWEI");
        System.out.println("huawei = " + huawei);
        //huawei = HUAWEI
        Phone xiaomi = Phone.valueOf(Phone.class, "XIAOMI");
        String origin = Phone.XIAOMI.origin();
        System.out.println("xiaomi = " + xiaomi);
        //xiaomi = XIAOMI
        //ordinal 序数
        System.out.println(SizeEnum.MEDIUM.ordinal());// 1
    }

}
