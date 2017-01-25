package com.spinytech.datastructure.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by wanglei on 2017/1/18.
 */

public class UnorderedArrayGenerator {
    public static int[] generateUnorderedArray(int length,int min,int max){
        if(min>max){
            return null;
        }
        int[] result = new int[length];
        Random random = new Random(System.currentTimeMillis());
        for(int i=0;i<length;i++){
            result[i]=random.nextInt((max-min)+1)+min;
        }
        return result;
    }

    public static void generateBigUnorderedArrayToFile(String fileName,int length){
        long start = System.currentTimeMillis();
        if (length>Integer.MAX_VALUE){
            return;
        }
        File file = new File(fileName);
        if(file.exists()){
            return;
        }

        int[] array = new int[length];
        for(int i = 0 ; i < length ; i++){
            array[i] = i;
        }
        Random random = new Random(System.currentTimeMillis());
        for(int i = 0 ; i < length ; i++){
            int randomSwap = random.nextInt(length);
            int temp = array[i];
            array[i] = array[randomSwap];
            array[randomSwap]=temp;
        }
        try {
            file.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            for(int i = 0 ; i < length ; i++){
                out.write(array[i]+"\r\n");
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("time cost:"+(System.currentTimeMillis()-start)/1000);
    }
}
