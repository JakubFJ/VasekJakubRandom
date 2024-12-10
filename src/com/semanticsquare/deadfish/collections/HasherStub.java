package com.semanticsquare.deadfish.collections;

public class HasherStub<T> implements Hasher<T> {

	@Override
	public int getHashCode(T element) {
		return (Integer) element;
	}

}
