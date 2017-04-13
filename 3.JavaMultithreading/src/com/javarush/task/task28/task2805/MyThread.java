package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private static AtomicInteger priority = new AtomicInteger(0);

    public MyThread() {
        setMyPriority();
    }

    public MyThread(Runnable target) {
        super(target);
        setMyPriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setMyPriority();
    }

    public MyThread(String name) {
        super(name);
        setMyPriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setMyPriority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setMyPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setMyPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setMyPriority();
    }

    private void setMyPriority() {
        if (priority.get() >= Thread.MAX_PRIORITY)
            priority.set(0);
        setPriority(priority.incrementAndGet());
        if (priority.get() > getThreadGroup().getMaxPriority()) {
            setPriority(getThreadGroup().getMaxPriority());
        }
    }
}
