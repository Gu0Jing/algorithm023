//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2830 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        //动态规划
        //重复性：当前最大和=max(前一个最大和+当前数，当前数）
        //定义状态空间：dp[i]存储当前最大连续和
        //dp方程：dp[i] = Max(dp[i-1]+nums[i],nums[i])

        int[] dp = new int[nums.length];
        //定义初始值
        dp[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
