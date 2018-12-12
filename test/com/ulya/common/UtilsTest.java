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
    private String s;

    @Before
    public void setup() {
        words = new LinkedList<>();
        words.add(0,"std");
        words.add(1,"Herman");
        words.add(2, "aaa");
        words.add(3, "ee");
        words.add(4, "y");
        words.add(5, "q");
        words.add(6, "Kostya");
        s = "aaa";
    }

    @Test
    public void factorial() {
        Assert.assertEquals(Utils.factorialRec(0), 1);
        Assert.assertEquals(Utils.factorialRec(1), 1);
        Assert.assertEquals(Utils.factorialRec(2), 2);
        Assert.assertEquals(Utils.factorialLoop(0), 1);
        Assert.assertEquals(Utils.factorialLoop(1), 1);
        Assert.assertEquals(Utils.factorialLoop(3), 6);
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
        countVowelsInTheWord.put(words.get(0), 0);
        countVowelsInTheWord.put(words.get(1), 2);
        countVowelsInTheWord.put(words.get(2), 3);
        countVowelsInTheWord.put(words.get(3), 2);
        countVowelsInTheWord.put(words.get(4), 1);
        countVowelsInTheWord.put(words.get(5), 0);
        countVowelsInTheWord.put(words.get(6), 3);
            Assert.assertEquals(Utils.countVowels(words).keySet(), countVowelsInTheWord.keySet());
    }
    @Test
    public void countString() {
        Assert.assertEquals(Utils.countVowelsString(s), 3);
    }
}