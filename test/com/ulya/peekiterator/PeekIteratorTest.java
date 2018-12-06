package com.ulya.peekiterator;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class PeekIteratorTest {


    private List<String> nameList;

    @Before
    public void setup(){
        nameList = new LinkedList<>();
        nameList.add("Masha");
        nameList.add("Ulya");
        nameList.add(null);
        nameList.add("Gera");
    }

    @Test
    public void hasPrevTest(){
        PeekIterator<String> peekIterator = new PeekIteratorImpl<>(nameList.iterator());
        Assert.assertFalse(peekIterator.hasPrev());

        String masha = peekIterator.next();

        Assert.assertEquals("Masha", masha);

        Assert.assertTrue(peekIterator.hasPrev());
    }

    @Test
    public void prevTest(){
        PeekIterator<String> peekIterator = new PeekIteratorImpl<>(nameList.iterator());
        Assert.assertNull(peekIterator.peek());

        peekIterator.next();

        Assert.assertNotNull(peekIterator.peek());
    }

    @Test
    public void nullTest(){
        PeekIterator<String> peekIterator = new PeekIteratorImpl<>(nameList.iterator());

        peekIterator.next();
        peekIterator.next();
        peekIterator.next();

        Assert.assertFalse(peekIterator.hasPrev());
    }
    @Test
    public void peekTest(){
        PeekIterator<String> peekIterator = new PeekIteratorImpl<>(nameList.iterator());
        peekIterator.peek();
        peekIterator.peek();
        peekIterator.peek();
        peekIterator.next();


        Assert.assertTrue(peekIterator.hasPrev());
    }

}
