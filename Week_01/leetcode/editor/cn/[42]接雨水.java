//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 
// 👍 1914 👎 0


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int length = height.length;
        //1、暴力结算，三重循环
        int res = 0;
        //遍历当前柱子
//        for (int i = 0; i < length; i++) {
//            int maxLeft = 0;
//            int maxRight = 0;
//            //遍历当前柱子左侧，找最高的柱子
//            for (int j = i; j >= 0; j--) {
//                maxLeft = Math.max(height[j], maxLeft);
//            }
//            //遍历当前柱子右侧，找最高的柱子
//            for (int j = i; j < length; j++) {
//                maxRight = Math.max(height[j], maxRight);
//            }
//            //计算当前柱子的积水面积
//            res += 1 * (Math.min(maxLeft, maxRight) - height[i]);
//        }
//        return res;

        //2、动态编程：提前存储左右侧的最大高度
        //拦截极端情况
//        if (height == null || height.length == 0) {
//            return 0;
//        }
//        int[] maxLeft = new int[length];
//        int[] maxRight = new int[length];
//        //左右最大高度数组赋初值
//        maxLeft[0] = height[0];
//        maxRight[length - 1] = height[length - 1];
//        //遍历左侧：从左往右
//        for (int i = 1; i < length; i++) {
//            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
//        }
//        //遍历由侧：从右往左
//        for (int i = length-2; i >=0; i--) {
//            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
//        }
//        //遍历当前柱子，计算积水,不算左右边界
//        for (int i = 1; i <= length-2; i++) {
//            res += Math.min(maxLeft[i], maxRight[i]) - height[i];
//        }
//        return res;

        //3、单调递减栈：利用递减栈存储可能积水的柱子下标
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            //当前高度大于栈顶元素时
            while (!stack.isEmpty() && height[i] > height[stack.peekLast()]) {
                int top = stack.pollLast();
                if (stack.isEmpty()) {
                    break;
                }
                int width = i-stack.peekLast()-1;
                int heightDiff = Math.min(height[i], height[stack.peekLast()]) - height[top];
                res += width * heightDiff;
            }
            stack.offerLast(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
