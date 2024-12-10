package com.semanticsquare.deadfish.collections;

import java.util.Objects;

public class RealHasher<T> implements Hasher<T> {
    @Override
    public int getHashCode(T element) {
        return Objects.hashCode(element);
    }
}
