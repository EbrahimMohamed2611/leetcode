package com.leetcode.medium;
// https://leetcode.com/problems/next-permutation/submissions/
/*
Facebook|24 Amazon|20 Google|12 Apple|12 Adobe|8 Bloomberg|7 Microsoft|4 ByteDance|2 Uber|2 Rubrik|2 Goldman Sachs|2 Walmart Global Tech|2 DoorDash|2 */
public class NextPermutation_31 {

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Next Permutation.
Memory Usage: 42.3 MB, less than 96.09% of Java online submissions for Next Permutation.
     */
    public void nextPermutation(int[] permutation) {
        int i = permutation.length - 2;
        while (i >= 0 && permutation[i] >= permutation[i + 1]) i--;

        if (i >= 0) {
            int j = permutation.length - 1;
            while (permutation[j] <= permutation[i])
                j--;
            // swap
            int temp = permutation[j];
            permutation[j] = permutation[i];
            permutation[i] = temp;
        }

        int firstPointer = i + 1;
        int secondPointer = permutation.length - 1;
        while (firstPointer <= secondPointer) {
            int temp2 = permutation[firstPointer];
            permutation[firstPointer++] = permutation[secondPointer];
            permutation[secondPointer--] =  temp2;
        }
    }
}
