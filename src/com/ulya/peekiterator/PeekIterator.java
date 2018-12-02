package com.ulya.peekiterator;

import java.util.Iterator;

public interface PeekIterator<E> extends Iterator<E> {

    boolean hasPrev();

    E prev();
}
