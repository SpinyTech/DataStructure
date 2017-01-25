package com.spinytech.datastructure.sort;

import com.spinytech.datastructure.util.ArrayPrinter;


/**
 * Created by wanglei on 2017/1/18.
 */

public class HeapSort {

    public static void main(String[] args) {
//        int[] array = UnorderedArrayGenerator.generateUnorderedArray(10,0,100);
        int[] array = {76, 52, 18, 29, 40, 62, 80, 98, 27, 55};
        long start = System.currentTimeMillis();
        ArrayPrinter.printArray(array);
        sort(array);
        System.out.println("cost:"+(System.currentTimeMillis()-start));
    }

    public static void sort(int[] array){
        int length = array.length;
        for(int i = 0;i<length-1;i++){
            buildMaxHeap(array,length-1-i);
            ArrayPrinter.printArray(array);
            swap(array,0,length-1-i);
        }
    }

    private static void swap(int[] data, int i, int j) {
        int tmp=data[i];
        data[i]=data[j];
        data[j]=tmp;
    }

    //对data数组从0到lastIndex建大顶堆
    private static void buildMaxHeap(int[] data, int lastIndex) {
        //从lastIndex处节点（最后一个节点）的父节点开始（最后一个非叶子节点），一直到跟节点进行循环

        for(int i=(lastIndex-1)/2;i>=0;i--){
            //k保存正在判断的节点
            int k=i;
            //如果当前k节点的子节点存在（K不是叶子）
            while(k*2+1<=lastIndex){
                //k节点的左子节点的索引
                int biggerIndex=2*k+1;
                //如果K节点左右双全（如果左节点=lastIndex，说明只有做节点）
                if(biggerIndex<lastIndex){
                    //若果右子节点的值较大
                    if(data[biggerIndex]<data[biggerIndex+1]){
                        //biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }

                //如果k节点的值小于其较大的子节点的值
                if(data[k]<data[biggerIndex]){
                    //交换他们
                    swap(data,k,biggerIndex);
                    //将biggerIndex赋予k，再次进入循环，保证交换完成之后，他的子树依然是大顶堆。
                    k=biggerIndex;
                }else{
                    break;
                }
            }
        }
    }
}