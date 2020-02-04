package com.gx.ext.cache;

public interface Cache {
    <T> T get(String key);

    void set(String key, Object value);

    void remove(String key);
}
