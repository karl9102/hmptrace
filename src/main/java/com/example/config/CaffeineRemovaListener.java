package com.example.config;

import com.github.benmanes.caffeine.cache.RemovalCause;
import com.github.benmanes.caffeine.cache.RemovalListener;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * @author: wangY
 * @date: 2021/11/18
 * @description:
 */
public class CaffeineRemovaListener implements RemovalListener {
    @Override
    public void onRemoval(@Nullable Object o, @Nullable Object o2, @NonNull RemovalCause removalCause) {

    }
}
