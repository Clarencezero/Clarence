package leetcode;

import java.util.PriorityQueue;

public class NO_4_findMedianSortedArrays {
    public static void main(String[] args) {
        NO_4_findMedianSortedArrays go = new NO_4_findMedianSortedArrays();
        int[] nums1 = {2, 3}, nums2 = {1};
        System.out.println(go.findMedianSortedArrays(nums1, nums2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 小根堆保留大数，大根堆保留小数
        PriorityQueue<Integer> smallQueue = new PriorityQueue<>();
        PriorityQueue<Integer> bigQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));

        // 所以小根堆里面的数全部都大于大根堆里面的数
        // 如果为奇数的话，则先添加到小根堆，然后从小根堆取出最小值放入大根堆
        // 如果为偶数的话，则添加到小根堆中

        for (int i = 0; i < nums1.length; i++) {
            if (smallQueue.size() >= bigQueue.size()) {
                smallQueue.add(nums1[i]);
                bigQueue.add(smallQueue.poll());
            } else {
                bigQueue.add(nums1[i]);
                smallQueue.add(bigQueue.poll());
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (smallQueue.size() >= bigQueue.size()) {
                smallQueue.add(nums2[i]);
                bigQueue.add(smallQueue.poll());
            } else {
                bigQueue.add(nums2[i]);
                smallQueue.add(bigQueue.poll());
            }
        }
        if (smallQueue.size() == bigQueue.size()) {
            return (smallQueue.poll() + bigQueue.poll()) / 2.0;
        } else {
            return smallQueue.size() > bigQueue.size() ? smallQueue.peek() : bigQueue.peek();
        }
    }
}
