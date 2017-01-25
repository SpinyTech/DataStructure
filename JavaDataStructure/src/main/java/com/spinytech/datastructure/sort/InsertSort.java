package com.spinytech.datastructure.sort;

import com.spinytech.datastructure.util.ArrayPrinter;
import com.spinytech.datastructure.util.UnorderedArrayGenerator;

/**
 * Created by wanglei on 2017/1/18.
 */

public class InsertSort {

    public static void main(String[] args) {
        int[] array = UnorderedArrayGenerator.generateUnorderedArray(20,0,100);
        ArrayPrinter.printArray(array);
        sort(array);
        ArrayPrinter.printArray(array);
    }

    public static void sort(int[] array){
        int temp = 0;
        for(int i=1;i<array.length;i++){
            int j = i-1;
            temp = array[i];
            //所有比待插入值大的，统一往后移动一位
            for(;j>=0&&array[j]>temp;j--){
                array[j+1]=array[j];
            }
            array[j+1]=temp;
        }
    }
}
