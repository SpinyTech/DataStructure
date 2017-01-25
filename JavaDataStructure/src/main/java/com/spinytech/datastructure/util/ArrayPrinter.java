package com.spinytech.datastructure.util;

/**
 * Created by wanglei on 2017/1/18.
 */

public class ArrayPrinter {
    public static void printArray(int[] array, int keyPoint) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < array.length; i++) {
            String comma = i==array.length-1?"":", ";
            if (i == keyPoint) {
                sb.append("**").append(array[i]).append("**").append(comma);
            } else {
                sb.append(array[i]).append(comma);
            }
        }
        sb.append("}");
        System.out.println(sb);
    }

    public static void printArray(int[] array){
        printArray(array,-1);
    }
}
