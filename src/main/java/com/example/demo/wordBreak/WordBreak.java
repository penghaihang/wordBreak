package com.example.demo.wordBreak;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        String word = "ilikeicecreamandmango";

        wordBreak(word);

    }

    static Set<String> dictSet = new HashSet<>();
    static {
        String dictionary[] = { "mobile", "samsung", "sam", "sung", "man",
                "mango", "icecream", "and", "go", "i", "like", "ice", "cream" };
        int n = dictionary.length;
        for (int i = 0; i < n; i++){
            dictSet.add(dictionary[i]);
        }
    }

    public static void wordBreak(String word) {
        wordBreakUtil(word, word.length(), "");
    }

    public static void wordBreakUtil(String word, int length, String result) {

        for(int i=1; i<=length; i++)
        {
            String prefix = word.substring(0, i);
            if (dictSet.contains(prefix))
            {
                // if no more elements are there, print it
                if (i == length)
                {
                    // add this element to previous prefix
                    result += prefix;
                    System.out.println(result);
                    return;
                }
                wordBreakUtil(word.substring(i, length), length-i, result + prefix + " ");
            }
        }
    }
}
