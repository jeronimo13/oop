package com.ulya.common;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    public static int factorialLoop(int number) {
        int result = 1;
        if (number == 0) {
            return 0;
        }
        if (number < 0){
            throw new IllegalArgumentException();
        }
        if (number>1) {
            for (int i = 1; i <= number; i++) {
                result = result * i;
            }
        }
        return result;
    }

    public static int factorialRec(int n) {
        int result;
        if (n == 0) {
            return 0;
        }
        if (n < 0){
            throw new IllegalArgumentException();
        }
        if (n == 1){
            return 1;
        }
        result = factorialRec(n - 1) * n;

        return result;
    }

    public static String getRandomElement(List<String> list) {
        Collections.shuffle(list);
        return list.get(1);
    }

    public static Map<String, Integer> countVowels(List<String> words) {
        Map<String, Integer> countVowelsInTheWord = new HashMap<String, Integer>();
        int countOfVowels = 0;
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                if (words.get(i).contains("o") || words.get(i).contains("a") ||
                        words.get(i).contains("i") || words.get(i).contains("u") ||
                        words.get(i).contains("e") || words.get(i).contains("y")) {
                    countOfVowels++;
                    countVowelsInTheWord.put(words.get(1), countOfVowels);

                }
            }
        }
        return countVowelsInTheWord;
    }
}
