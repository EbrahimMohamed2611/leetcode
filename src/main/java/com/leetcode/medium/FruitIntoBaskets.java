package com.leetcode.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/fruit-into-baskets/
 */
public class FruitIntoBaskets {
    /**
     * Time O(N)
     * Space O(N)
     *
     * Runtime: 57 ms, faster than 56.40% of Java online submissions for Fruit Into Baskets.
     * Memory Usage: 52 MB, less than 75.56% of Java online submissions for Fruit Into Baskets.
     */
    public int totalFruit(int[] fruit) {
        int maxLength = 0;
        Map<Integer, Integer> fruitFrequencyMap = new HashMap<>();
        int startCount = 0;
        for (int endCount = 0; endCount < fruit.length; endCount++) {
            int currentFruit = fruit[endCount];
            fruitFrequencyMap.put(currentFruit, fruitFrequencyMap.getOrDefault(currentFruit, 0) + 1);
            while (fruitFrequencyMap.size() > 2) {
                int startFruit = fruit[startCount];
                fruitFrequencyMap.put(startFruit, fruitFrequencyMap.get(startFruit) - 1);
                if (fruitFrequencyMap.get(startFruit) == 0)
                    fruitFrequencyMap.remove(startFruit);
                startCount++;
            }
            maxLength = Math.max(maxLength, endCount - startCount + 1);
        }
        return maxLength;
    }
}
