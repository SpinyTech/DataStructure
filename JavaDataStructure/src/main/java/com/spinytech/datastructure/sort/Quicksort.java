package com.spinytech.datastructure.sort;

import com.spinytech.datastructure.util.ArrayPrinter;
import com.spinytech.datastructure.util.UnorderedArrayGenerator;

/**
 * Created by wanglei on 2017/1/18.
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] array = UnorderedArrayGenerator.generateUnorderedArray(100,0,10000000);
        long start = System.currentTimeMillis();
        ArrayPrinter.printArray(array);
//        sort(array, 0, array.length - 1);
        sort2(array);
        ArrayPrinter.printArray(array);
        System.out.println("cost:"+(System.currentTimeMillis()-start));
    }

    public static void sort(int[] a, int start, int end) {
        // 不符合条件，不进行递归
        if (start < 0 || end > a.length - 1 || start >= end) {
            return;
        }
        int startIndex = start;
        int endIndex = end;
        // 指针是否从右往左移，true:左指针不动，右指针从右往左移；false：右指针不动，左指针从左往右移；
        boolean cursorRight2Left = true;
        for (; ; ) {
            if (cursorRight2Left) {
                //如果左指针数小于右指针数，右指针从右往左移
                if (a[start] < a[end]) {
                    end--;
                }
                //如果左指针数大于等于右指针数，两个数交换位置，左指针+1，改变模式，改成指针从左往右移
                else {
                    int temp = a[start];
                    a[start] = a[end];
                    a[end] = temp;
                    start++;
                    cursorRight2Left = false;
                }
            }
            // 与上面正相反
            else {
                if (a[start] < a[end]) {
                    start++;
                } else {
                    int temp = a[end];
                    a[end] = a[start];
                    a[start] = temp;
                    end--;
                    cursorRight2Left = true;
                }
            }
            // 左右指针相遇，退出循环，一趟快排结束，左边所有数值均小于右边所有数值
            if (start >= end) {
                break;
            }
        }
//        ArrayPrinter.printArray(a, start);
        // 递归排左边的数组
        if(startIndex<start-1){
            sort(a,startIndex,start-1);
        }
        // 递归排右边的数组
        if(start+1<endIndex){
            sort(a,start+1,endIndex);
        }
    }


    // 非递归方法 TODO
    public static void sort2(int[] array)
    {
        int leftLow, leftHeight, rightLow, rightHeight;
        int tempLow, tempHeight, key, temp;
        leftLow = 0;
        leftHeight = leftLow;
        rightLow = array.length - 1;
        rightHeight = array.length - 1;
        tempLow = -1; tempHeight = -1; key = -1;

        while (rightHeight > leftLow)
        {

            while (leftHeight + 1 < rightLow)
            {

                key = leftHeight;
                tempLow = leftHeight + 1;
                tempHeight = rightLow;

                while (tempLow < tempHeight)
                {
                    while (tempLow < rightHeight && array[tempLow] < array[key])
                    {
                        tempLow++;
                    }
                    while (leftHeight < tempHeight && array[key] <= array[tempHeight])
                    {
                        tempHeight--;
                    }
                    if (leftLow < tempHeight && tempLow < rightHeight && tempLow < tempHeight)
                    {
                        temp = array[tempLow];
                        array[tempLow] = array[tempHeight];
                        array[tempHeight] = temp;
                    }
                }
                if (rightHeight == tempHeight && leftHeight - leftLow == 0)
                {
                    temp = array[rightLow];
                    array[rightLow] = array[leftHeight];
                    array[leftHeight] = temp;
                    rightHeight--;
                    rightLow--;
                    continue;
                }
                rightLow = tempHeight;
                if (key == tempHeight)
                {
                    break;
                }
                else if (key < tempHeight && tempLow > tempHeight)
                {
                    leftHeight++;
                }

            }

            if (leftHeight != leftLow)
            {
                if (leftHeight < rightLow)
                {
                    if (array[leftHeight] < array[rightLow])
                    {
                        temp = leftHeight;
                    }
                    else
                    {
                        temp = rightLow;
                        rightLow++;
                        leftHeight++;
                    }
                }
                else
                {
                    temp = rightLow;
                    rightLow++;
                }

                key = array[temp];
                for (int i = temp; i > leftLow; i--)
                {
                    array[i] = array[i - 1];
                }
                array[leftLow] = key;
                leftLow++;

                while (rightLow <= rightHeight && array[rightLow] < array[leftHeight])
                {
                    rightLow++;
                }
                if (rightLow > rightHeight)
                {
                    rightLow--;
                }

            }

            else
            {
                rightLow = rightHeight;
                leftLow++;
                leftHeight++;
            }

        }
        if (array[rightHeight] < array[rightHeight - 1])
        {
            temp = array[rightHeight];
            array[rightHeight] = array[rightHeight - 1];
            array[rightHeight - 1] = temp;
        }
    }

}
