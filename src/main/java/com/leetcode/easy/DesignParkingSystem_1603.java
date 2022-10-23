package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

import java.util.*;

public class DesignParkingSystem_1603 {
    /*
    Runtime: 6 ms, faster than 100.00% of Java online submissions for Design Parking System.
Memory Usage: 42.5 MB, less than 97.53% of Java online submissions for Design Parking System.
     */
    int big, medium, small;

    public DesignParkingSystem_1603(int big, int medium, int small) {
        this.big = big; this.medium = medium; this.small = small;
    }

    public boolean addCar(int carType) {
        if(carType == 1 && big > 0){
            big--; return true;
        }else if (carType == 2 && medium > 0){
            medium--; return true;
        }else if(carType == 3 && small > 0){
            small--; return true;
        }
        return false;
    }
}
