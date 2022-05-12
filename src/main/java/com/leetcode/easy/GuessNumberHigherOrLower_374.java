package com.leetcode.easy;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 * Companies [ Google, Microsoft ]
 */
public class GuessNumberHigherOrLower_374 {

    class GuessGame{
    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is higher than the picked number
     *			      1 if num is lower than the picked number
     *               otherwise return 0
     * int guess(int num);
     */
        public int guess(int num){
            return 0;
        }
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Guess Number Higher or Lower.
     * Memory Usage: 39.2 MB, less than 79.97% of Java online submissions for Guess Number Higher or Lower.
     */

    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int left = 1, right = n;
            int mid =left + (right - left)/2, result;

            while(right >= left){
                mid = left + (right - left)/2;
                result =  guess(mid);
                if(result ==0)
                    return mid;
                else if( result == -1){
                    right = mid -1;
                }else{
                    left = mid  +1;
                }
            }
            return mid;
        }
    }
}
