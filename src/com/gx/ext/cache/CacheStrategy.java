package com.gx.ext.cache;

public interface CacheStrategy {
    Cache getCache(String name);
}
