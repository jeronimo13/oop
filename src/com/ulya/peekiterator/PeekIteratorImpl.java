package com.ulya.peekiterator;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class PeekIteratorImpl<E> implements PeekIterator<E> {


    private Iterator<E> iterator;
    private Stack<E> stack = new Stack<>();
    private E prev;

    public PeekIteratorImpl(Iterator<E> iterator) {
        this.iterator = iterator;
    }


    @Override
    public boolean hasPrev() {
        if(prev != null){
            return true;
        }
        return false;
    }

    @Override
    public E peek() {
        if(stack.isEmpty()){
            return null;
        }

        E pop = stack.pop();

        if(stack.size() == 0){
            prev = null;
        }

        return pop;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public E next() {
        E next = iterator.next();
        stack.push(next);
        prev = next;
        return next;
    }
}
