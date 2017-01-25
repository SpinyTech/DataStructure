package com.spinytech.datastructure.sort;

import com.spinytech.datastructure.util.ArrayPrinter;
import com.spinytech.datastructure.util.UnorderedArrayGenerator;

/**
 * Created by wanglei on 2017/1/18.
 */

public class SelectSort {
    public static void main(String[] args) {

        int[] array = UnorderedArrayGenerator.generateUnorderedArray(20,0,1000);
        long start = System.currentTimeMillis();
        ArrayPrinter.printArray(array);
        sort(array);
        System.out.println("cost:"+(System.currentTimeMillis()-start));
    }
    public static void sort(int[] array){
        for(int i=0;i<array.length;i++){
            int max=Integer.MIN_VALUE;
            int index = 0;
            for(int j=i;j<array.length;j++){
                if(array[j]>max){
                    max=array[j];
                    index = j;
                }
            }
            array[index]=array[i];
            array[i]=max;

            ArrayPrinter.printArray(array);
        }
    }
}
