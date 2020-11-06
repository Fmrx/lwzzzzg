package com.lwzzzzg.service;

public interface RedisService {

    String get(String key);
    void set(String key, String value);
}
