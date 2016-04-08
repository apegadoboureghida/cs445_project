package edu.iit.cs445.s2016.delectable;

import java.util.concurrent.atomic.AtomicInteger;

public class UniqueIdGenerator {
    static AtomicInteger atomicInteger = new AtomicInteger();
    public static int getUniqueID() {
        return atomicInteger.incrementAndGet();
    }
}
