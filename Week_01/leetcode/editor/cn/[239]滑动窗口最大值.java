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
// 👍 767 👎 0


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if(len==0){
            return new int[0];
        }
        //1、暴力解算：双重循环
        int[] maxArr = new int[len - k + 1];
//        int max;
//        for (int i = 0; i <= len - k; i++) {
//            max = nums[i];
//            for (int j = i+1; j < i+k; j++) {
//                max = Math.max(max, nums[j]);
//            }
//            maxArr[i] = max;
//        }
//        return maxArr;

        //2、单调递减双端队列：
        // 每移动一次窗口，队尾比较添加一个元素，队头比较删除一个元素
        // 每次队列操作完成后，队头元素即为当前窗口最大值
//        Deque<Integer> deque = new LinkedList<>();
//        int maxIndex= 0;
//        //初始填充队列
//        for (int i = 0; i < k; i++) {
//            //添加元素时比大小，保证队列从头到尾递减
//            //如果新加入的元素比队尾大，队尾出队
//            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
//                deque.pollLast();
//            }
//            deque.offerLast(nums[i]);
//        }
//        maxArr[maxIndex++] = deque.peekFirst();
//        //移动窗口，每次加入一个元素，删除一个元素
//        for (int i = k; i < len; i++) {
//            //校验队头元素是否在窗口中，不在则出队
//            //即队头元素是否刚刚退出窗口
//            if (deque.peekFirst() == nums[i - k]) {
//                deque.pollFirst();
//            }
//            //校验队尾元素大小
//            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
//                deque.pollLast();
//            }
//            deque.offerLast(nums[i]);
//            maxArr[maxIndex++] = deque.peekFirst();
//        }
//
//        return maxArr;

        //第二遍：
        //1、暴力解算
//        int [] res = new int[len-k+1];
//        int max = 0;
//        for(int i = 0 ; i<=len-k ; i++){
//            max = nums[i];
//            for(int j=i+1;j<i+k;j++){
//                max = Math.max(nums[j],max);
//            }
//            res[i]=max;
//        }
//        return res;

        //2、单调递减双端队列
        int resIndex = 0;
        int[] res = new int[len - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        //填充窗口队列，窗口长度k
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
        }
        res[resIndex++] = deque.getFirst();

        //移动窗口
        for (int i = k; i < len; i++) {
            //退出窗口的元素nums[i-k] 是否还在队列中，是则弹出
            if (deque.peekFirst() == nums[i - k]) {
                deque.pollFirst();
            }
            //队列+1
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
            res[resIndex++] = deque.getFirst();
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
