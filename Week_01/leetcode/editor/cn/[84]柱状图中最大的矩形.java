//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 1116 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        //1、暴力解算
        int length = heights.length;
        int max = 0;
//        for (int i = 0; i < length; i++) {
//            int left = i;
//            //找左边最后一个大的元素下标
//            while (left > 0 && heights[i] <= heights[left - 1]) {
//                left--;
//            }
//            int right = i;
//            //找右边最后一个大的元素下标
//            while (right < length - 1 && heights[i] <= heights[right + 1]) {
//                right--;
//            }
//            int width = right - left + 1;
//            max = Math.max(max, heights[i] * width);
//        }
//        return max;

        //2、单调递增栈
        //入栈元素为高度下标
        Stack<Integer> stack = new Stack<>();
        //辅助计算边界宽度
        stack.push(-1);
        for (int i = 0; i < length; i++) {
            //当栈不为空(不算-1) 且 当前高度小于栈顶元素，弹出栈顶元素，计算最大面积
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                int curArea = heights[stack.pop()] * (i - stack.peek() - 1);
                max = Math.max(max, curArea);
            }
            stack.push(i);
        }
        //清空栈剩余
        //此时右边界确定
        int right = stack.peek();
        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            int left = stack.peek();
            max = Math.max(max, height * (right - left));
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
