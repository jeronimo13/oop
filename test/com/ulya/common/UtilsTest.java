package com.ulya.common;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class UtilsTest {
    private List<String> words;

    @Before
    public void setup() {
        words = new LinkedList<>();
        words.set(0,"std");
        words.set(1,"Herman");
        words.set(2, "aaa");
    }

    @Test
    public void factorial() {
        assertTrue(Utils.factorialRec(0) == 1);
        assertTrue(Utils.factorialRec(1) == 1);
        assertTrue(Utils.factorialRec(3) == 6);
        assertTrue(Utils.factorialLoop(0) == 1);
        assertTrue(Utils.factorialLoop(1) == 1);
        assertTrue(Utils.factorialLoop(3) == 6);
    }
    @Test(expected = IllegalArgumentException.class)
    public void factorialNegative() {
        Utils.factorialRec(-1);
        Utils.factorialLoop(-2);
    }

    @Test
    public void getRandomElement() {
        assertTrue((words.contains(Utils.getRandomElement(words))==true));
    }

    @Test
    public void countVowels() {
        Map<String, Integer> countVowelsInTheWord = new HashMap<String, Integer>();
        countVowelsInTheWord.put(words.get(0),0);
        countVowelsInTheWord.put(words.get(1),2);
        countVowelsInTheWord.put(words.get(2),3);

        Assert.assertEquals(Utils.countVowels(words), countVowelsInTheWord);
    }
}