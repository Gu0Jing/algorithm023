//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 789 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        //1、大根堆
//        PriorityQueue<int[]> heap = new PriorityQueue<>(k, (a, b) -> b[0] - a[0]);
//        //填满窗口
//        for (int i = 0; i < k; i++) {
//            heap.offer(new int[]{nums[i],i});
//        }
//        res[0] = heap.peek()[0];
//        int maxIndex = 1;
//        for (int i = k; i < nums.length; i++) {
//            heap.offer(new int[]{nums[i], i});
//            while (heap.peek()[1]<=i-k){
//                heap.poll();
//            }
//            res[maxIndex++] = heap.peek()[0];
//        }
//        return res;

        //2、单调递减队列:存储窗口元素下标
//        Deque<Integer> stack = new ArrayDeque<>();
//        for (int i = 0; i < nums.length; i++) {
//            //入栈时循环校验，保证单调性
//            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i]) {
//                stack.pollLast();
//            }
//            stack.offerLast(i);
//
//            //校验队首元素是否在窗口内
//            if (stack.peekFirst() <= i - k) {
//                stack.pollFirst();
//            }
//            //窗口填满时，开始获取结果
//            if (i + 1 >= k) {
//                res[i + 1 - k] = nums[stack.peekFirst()];
//            }
//
//        }
//        return res;

        //3、单调队列：存储窗口元素
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);

            if (i >= k) {
                if (deque.peekFirst() == nums[i - k]) {
                    deque.pollFirst();
                }
            }

            if (i + 1 >= k) {
                res[i+1-k] = deque.peekFirst();
            }
        }
        return res;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
