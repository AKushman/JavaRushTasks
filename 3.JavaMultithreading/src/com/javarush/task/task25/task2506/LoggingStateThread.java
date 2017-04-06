package com.javarush.task.task25.task2506;


public class LoggingStateThread extends Thread {
    Thread thread;
    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        setDaemon(true);
    }

    @Override
    public void run() {
        State state = thread.getState();
        System.out.println(state);
        while (thread.getState() != State.TERMINATED) {
            State newState = thread.getState();
            if (state != newState) {
                state = newState;
                System.out.println(state);
            }
        }

    }
}
