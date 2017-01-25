package com.spinytech.datastructure.objectpool;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wanglei on 2017/1/24.
 */

public final class ObjectPool<OBJECT extends ObjectPool.RecyclableObject> {
    private OBJECT[] mTable;
    private AtomicInteger mOrderNumber;
    public static int RESET_NUM = 1000;

    public ObjectPool(OBJECT[] inputArray) {
        mOrderNumber = new AtomicInteger(0);
        mTable = inputArray;
        if (mTable == null) {
            throw new NullPointerException("The input array is null.");
        }
        int length = inputArray.length;
        if ((length & length - 1) != 0) {
            throw new RuntimeException("The length of input array is not 2^n.");
        }
    }

    public void recycle(OBJECT object) {
        object.isIdle.set(true);
    }


    public OBJECT obtain() {
        int index = mOrderNumber.getAndIncrement();
        if (index > RESET_NUM) {
            mOrderNumber.compareAndSet(index, 0);
            if (index > RESET_NUM * 2) {
                mOrderNumber.set(0);
            }
        }

        int num = index & (mTable.length - 1);

        OBJECT target = mTable[num];

        if (target.isIdle.compareAndSet(true, false)) {
            return target;
        } else {
            return obtain();
        }
    }

    public abstract static class RecyclableObject {
        AtomicBoolean isIdle = new AtomicBoolean(true);
    }
}


