package com.spinytech.datastructure.sort;

import com.spinytech.datastructure.util.ArrayPrinter;
import com.spinytech.datastructure.util.UnorderedArrayGenerator;

/**
 * Created by wanglei on 2017/1/18.
 */

public class ShellSort {
    public static void main(String[] args) {
        int[] array = UnorderedArrayGenerator.generateUnorderedArray(20,0,1000);
        long start = System.currentTimeMillis();
        ArrayPrinter.printArray(array);
        sort(array);
        System.out.println("cost:"+(System.currentTimeMillis()-start));
    }
    public static void sort(int[] array){
        int d = array.length;
        for(;;){
            d=d/2;
            System.out.println("d="+d);
            for(int x=0;x<d;x++)
            {
                // 插入排序，增量=d
                for(int i=x+d;i<array.length;i=i+d)
                {
                    int temp=array[i];
                    int j;
                    for(j=i-d;j>=0&&array[j]>temp;j=j-d)
                    {
                        array[j+d]=array[j];
                    }
                    array[j+d]=temp;
                }
            }

            ArrayPrinter.printArray(array);

            if(d<=1){
                break;
            }
        }
    }
}
