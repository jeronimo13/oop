package com.ulya.common;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    public static int factorialLoop(int number) {
        int result = 1;

        if (number < 0) {
            throw new IllegalArgumentException();
        }
        if (number > 1) {
            for (int i = 1; i <= number; i++) {
                result = result * i;
            }
        }
        return result;
    }

    public static int factorialRec(int n) {
        int result = 1;

        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n>1) {
            result = factorialRec(n - 1) * n;
        }
        return result;
    }

    public static String getRandomElement(List<String> list) {
        Collections.shuffle(list);
        return list.get((int) (Math.random() * list.size()));
    }

    public static Map<String, Integer> countVowels(List<String> words) {
        Map countVowelsInTheWord = new HashMap();
        for (int i = 0; i < words.size(); i++) {
            int countOfVowels = 0;
            for (int j = 0; j < words.get(i).length(); j++) {
                char ch = words.get(i).charAt(j);
                if (ch == 'a' || ch == 'e' || ch == 'i' ||
                        ch == 'o' || ch == 'u' || ch == 'y') {
                    countOfVowels++;
                }
            }
            countVowelsInTheWord.put(words.get(i), countOfVowels);
        }
        return countVowelsInTheWord;
    }

    public static int countVowelsString(String s) {
        int countOfVowels = 0;
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                    ch == 'o' || ch == 'u' || ch == 'y') {
                countOfVowels++;
            }
        }
        return countOfVowels;
    }
}
