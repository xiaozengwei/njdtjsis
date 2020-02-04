package com.gx.ext.message;

public interface Subscribable<T> {
    void handleMessage(T message);

    boolean isTopic();

    String getName();
}
