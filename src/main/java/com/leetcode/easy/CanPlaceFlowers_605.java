package com.leetcode.easy;


/**
 * https://leetcode.com/problems/can-place-flowers/
 */
public class CanPlaceFlowers_605 {
    public static void main(String[] args) {

        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2));
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 0, 1}, 2));
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2));
        System.out.println(canPlaceFlowers(new int[]{1, 0, 1, 0, 1, 0, 1}, 0));
        System.out.println(canPlaceFlowers(new int[]{0, 0, 1, 0, 1}, 1));
    }

    /**
     * Runtime: 1 ms, faster than 97.95% of Java online submissions for Can Place Flowers.
     * Memory Usage: 53 MB, less than 11.49% of Java online submissions for Can Place Flowers.
     *
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) { // can place?
                --n;
                if (n == 0) return true;
                flowerbed[i] = 1; // place!
            }
        }
        return false;
    }

    /**
     Runtime: 1 ms, faster than 97.95% of Java online submissions for Can Place Flowers.
     Memory Usage: 52.3 MB, less than 45.66% of Java online submissions for Can Place Flowers.
     *
     * @param flowerbed
     * @param n
     * @return
     */
//    public static boolean canPlaceFlowers3(int[] flowerbed, int n) {
//        for (int i = 0; i < flowerbed.length && n > 0; i++) {
//            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
//                n--;
//                i++;
//            }
//        }
//        return n == 0 ? true : false;
//    }

//    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
//        int numberOfZeros = 0;
//        int numberOfPlaces = 0;
//        for (int i = 0; i < flowerbed.length; i++) {
//            for (int j = i; j < flowerbed.length; j++) {
//                if (flowerbed[j] == 0) {
//                    numberOfZeros++;
//                }
//                if (j - i == 3 && numberOfZeros == 3) {
//                    numberOfZeros = 0;
//                    numberOfPlaces++;
//                }
//                if (numberOfPlaces == n)
//                    return true;
//            }
//        }
//        return false;
//    }

//    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
//        //add zero on the first and the end
//        int[] newFlowerbed = new int[flowerbed.length + 2];
//        newFlowerbed[0] = 0;
//        newFlowerbed[newFlowerbed.length - 1] = 0;
//        for (int i = 0; i < flowerbed.length; i++) {
//            newFlowerbed[i + 1] = flowerbed[i];
//        }
//
//        for (int i = 1; i < newFlowerbed.length - 1; i++) {
//            if (newFlowerbed[i] == 0 && newFlowerbed[i - 1] == 0 && newFlowerbed[i + 1] == 0) {
//                n--;
//                newFlowerbed[i] = 1;
//
//            }
//        }
//
//        return n <= 0;
//    }


}
