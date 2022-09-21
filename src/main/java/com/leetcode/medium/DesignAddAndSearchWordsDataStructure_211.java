package com.leetcode.medium;

import java.util.*;


public class DesignAddAndSearchWordsDataStructure_211 {


    /*
    Time Limit Exceeded
    Map<Integer, Set<String>> dictionary = new HashMap<>();

    public DesignAddAndSearchWordsDataStructure_211() {

    }
        public void addWord(String word) {
        int length = word.length();
        if (dictionary.containsKey(length))
            dictionary.get(length).add(word);
        else {
            Set<String> strings = new HashSet<>();
            strings.add(word);
            dictionary.put(length, strings);
        }
    }

    public boolean search(String word) {
        int length = word.length();
        if (!dictionary.containsKey(length))
            return false;
        Set<String> strings = dictionary.get(length);
        if (strings.contains(word)) return true;
        for (String currentWord : strings) {
            int i = 0;
            while (i < currentWord.length()) {
                if (currentWord.charAt(i) == word.charAt(i) || word.charAt(i) == '.')
                    i++;
                else
                    break;
            }
            if (i == word.length()) return true;
        }
        return false;
    }
     */

    private class Node {
        private char value;
        private Map<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }
    }

    Node root = new Node(' ');

    /*
    Runtime: 1152 ms, faster than 50.39% of Java online submissions for Design Add and Search Words Data Structure.
    Memory Usage: 117.7 MB, less than 82.74% of Java online submissions for Design Add and Search Words Data Structure.
     */
    public void addWord(String word) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            if (!current.children.containsKey(ch))
                current.children.put(ch, new Node(ch));
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        return search(word, root, 0);
    }

    private boolean search(String word, Node current, int index) {
        for (int i = index; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                Set<Character> children = current.children.keySet();
                for (char child : children) {
                    Node node = current.children.get(child);
                    if (search(word, node, i + 1))
                        return true;
                }
                return false;
            } else {
                if (current.children.containsKey(ch))
                    current = current.children.get(ch);
                else
                    return false;
            }

        }
        return current.isEndOfWord;
    }


    public static void main(String[] args) {
        DesignAddAndSearchWordsDataStructure_211 wordDictionary = new DesignAddAndSearchWordsDataStructure_211();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }

}
