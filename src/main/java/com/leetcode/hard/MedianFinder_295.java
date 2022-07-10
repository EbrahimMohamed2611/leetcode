package com.leetcode.hard;

import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/find-median-from-data-stream/
public class MedianFinder_295 {
    /**
     Runtime: 148 ms, faster than 82.71% of Java online submissions for Find Median from Data Stream.
     Memory Usage: 120.9 MB, less than 74.37% of Java online submissions for Find Median from Data Stream.
     */
    Queue<Integer> maxHeap; // to peek the largest
    Queue<Integer> minHeap; // to peek the smallest

    public MedianFinder_295(){
        this.minHeap = new PriorityQueue<>((element1, element2) -> element1 - element2);
        this.maxHeap = new PriorityQueue<>((element1, element2) -> element2 - element1);

    }
    public void addNum(int number) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= number)
            maxHeap.add(number);
        else
            minHeap.add(number);

        if (minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());

        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
    }

    public double findMedian() {

        if (minHeap.size() == maxHeap.size())
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        else
            return maxHeap.peek();
    }
}
