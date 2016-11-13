package com.google.engedu.ghost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class SimpleDictionary implements GhostDictionary {
    private ArrayList<String> words;
    private ArrayList<String> even;
    private ArrayList<String> odd;
    Boolean didCompStart;

    public SimpleDictionary(InputStream wordListStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        words = new ArrayList<>();
        even = new ArrayList<>();
        odd = new ArrayList<>();

        String line = null;
        while ((line = in.readLine()) != null) {
            String word = line.trim();
            if (word.length() >= MIN_WORD_LENGTH)
                words.add(line.trim());
            if (word.length() % 2 == 0) {
                even.add(line.trim());

                didCompStart = true;
            } else {
                odd.add(line.trim());
                didCompStart = false;
            }
        }
    }


    @Override
    public boolean isWord(String word) {

        return words.contains(word);
    }

    @Override
    public String getAnyWordStartingWith(String prefix) {
        //if it"s first time, return a random word
        if (prefix.equals("")) {
            Random random = new Random();
            return words.get(random.nextInt(10000));
        }
        return binarySearch(prefix, didCompStart);
    }


    private String binarySearch(String prefix, boolean didCompStart) {

        String dictionaryWord;

        ArrayList<String> words;
        if (didCompStart) {
            words = even;
        } else words = odd;

        int low = 0;
        int high = words.size() - 1;
        while (high >= low) {
            int middle = (high + low) / 2;
            dictionaryWord = words.get(middle);
            if (dictionaryWord.startsWith(prefix)) {
                return dictionaryWord;
            }
            if (dictionaryWord.compareTo(prefix) < 0) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return null;
    }

    public String getGoodWordStartingWith(String prefix, boolean start) {

        int word = -1;

        if (prefix.isEmpty()) {
            Random random = new Random();
            return words.get(random.nextInt(words.size()));
        }

        return "void";
    }
}


