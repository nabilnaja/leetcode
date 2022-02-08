package heap.leetcode295;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class MedianFinder {

    private final Queue<Integer> minHeap;
    private final Queue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        if (minHeap.size() == maxHeap.size()) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return (float)(minHeap.peek() + maxHeap.peek()) / 2;
        }
    }
}
