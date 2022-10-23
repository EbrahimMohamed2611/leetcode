package com.leetcode.medium;

import java.util.*;

public class SearchSuggestionsSystem_1268 {
    class Node {
        char value;
        boolean isWord;
        Node[] children = new Node[26];

        public Node(char ch) {
            value = ch;
        }

    }

    Node root = new Node(' ');


    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> allWords = new ArrayList<>();
        // first we need to add all products to Trie
        for (String word : products)
            addWord(word);
        // then we need to find all words with each character individually
        StringBuilder currentPrefix = new StringBuilder();
        for (char ch : searchWord.toCharArray()) {
            List<String> currentWords = new ArrayList<>();
            currentPrefix.append(ch);
            Node lastNode = findLastNodeOf(currentPrefix.toString());

            findWordsWithPrefix(lastNode, currentWords, currentPrefix.toString());
            allWords.add(currentWords);
        }

        return allWords;
    }

    private void findWordsWithPrefix(Node lastNode, List<String> currentWords, String currentPrefix) {
        if (lastNode == null)
            return;
        if (lastNode.isWord)
            currentWords.add(currentPrefix);
        for (Node child : lastNode.children) {
            if (currentWords.size() == 3)
                return;
            if (child != null)
                findWordsWithPrefix(child, currentWords, currentPrefix + child.value);
        }

    }

    private Node findLastNodeOf(String toString) {
        Node current = root;
        for (char ch : toString.toCharArray()) {
            if (current.children[ch - 'a'] == null)
                return null;
            current = current.children[ch - 'a'];
        }
        return current;
    }

    private void addWord(String word) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            if (current.children[ch - 'a'] == null)
                current.children[ch - 'a'] = new Node(ch);
            current = current.children[ch - 'a'];
        }
        current.isWord = true;
    }

//     class Node {
//         char value;
//         boolean isWord;
//         Map<Character, Node> children = new TreeMap<>(); // to insert with sorted

//         public Node(char ch) {
//             value = ch;
//         }

//         public Node[] getChildren() {
//             return children.values().toArray(new Node[0]);
//         }
//     }

//     Node root = new Node(' ');


//     public List<List<String>> suggestedProducts(String[] products, String searchWord) {
//         List<List<String>> allWords = new ArrayList<>();
//         // first we need to add all products to Trie
//         for (String word : products)
//             addWord(word);
//         // then we need to find all words with each character individually
//         StringBuilder currentPrefix = new StringBuilder();
//         for (char ch : searchWord.toCharArray()) {
//             List<String> currentWords = new ArrayList<>();
//             currentPrefix.append(ch);
//             Node lastNode = findLastNodeOf(currentPrefix.toString());
//             findWordsWithPrefix(lastNode, currentWords, currentPrefix.toString());
//             allWords.add(currentWords);
//         }

//         return allWords;
//     }

//     private void findWordsWithPrefix(Node lastNode, List<String> currentWords, String currentPrefix) {
//         if(lastNode == null)
//             return;
//         if (lastNode.isWord)
//             currentWords.add(currentPrefix);
//         for (Node child : lastNode.getChildren()) {
//             if (currentWords.size() == 3)
//                 return;
//             findWordsWithPrefix(child, currentWords, currentPrefix + child.value);
//         }

//     }

//     private Node findLastNodeOf(String toString) {
//         Node current = root;
//         for (char ch : toString.toCharArray()) {
//             if (!current.children.containsKey(ch))
//                 return null;
//             current = current.children.get(ch);
//         }
//         return current;
//     }

//     private void addWord(String word) {
//         Node current = root;
//         for (char ch : word.toCharArray()) {
//             if (!current.children.containsKey(ch))
//                 current.children.put(ch, new Node(ch));
//             current = current.children.get(ch);
//         }
//         current.isWord = true;
//     }
}
