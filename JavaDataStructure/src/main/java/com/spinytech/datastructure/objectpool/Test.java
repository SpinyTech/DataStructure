package com.spinytech.datastructure.objectpool;

/**
 * Created by wanglei on 2017/1/24.
 */

public class Test {

    public static void main(String[] args) {
        TestObject[] array = new TestObject[32];
        for(int i = 0 ; i < 32 ;i++){
            array[i] = new TestObject();
        }
        final ObjectPool<TestObject> objectPool = new ObjectPool<>(array);

        for(int i = 0 ; i < 50; i++){
            new Thread("Thread:"+i){
                @Override
                public void run() {
                    super.run();
                    for(int j = 0 ; j < 50 ; j++){
                        TestObject testObject = objectPool.obtain();
                        testObject.print(getName(),"--index:"+j);
                        objectPool.recycle(testObject);
                    }
                }
            }.start();
        }

    }

    static class TestObject extends ObjectPool.RecyclableObject{
        public TestObject(){
        }
        public void print(String thread, String index){
            System.out.println(thread+index);
        }
    }
}
