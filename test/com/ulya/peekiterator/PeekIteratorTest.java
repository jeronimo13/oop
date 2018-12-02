package com.ulya.peekiterator;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PeekIteratorTest {


    private List<String> nameList;

    @Before
    public void setup(){
        nameList = new ArrayList<>();
        nameList.add("Masha");
        nameList.add("Ulya");
        nameList.add("Gera");
    }

    @Test
    public void hasPrevTest(){
        PeekIterator<String> peekIterator = new PeekIteratorImpl<>(nameList.iterator());
        Assert.assertFalse(peekIterator.hasPrev());

        peekIterator.next();

        Assert.assertTrue(peekIterator.hasPrev());
    }

    @Test
    public void prevTest(){
        PeekIterator<String> peekIterator = new PeekIteratorImpl<>(nameList.iterator());
        Assert.assertNull(peekIterator.prev());

        peekIterator.next();

        Assert.assertNotNull(peekIterator.prev());
    }

    //TODO: add more tests

}
