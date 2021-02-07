//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 930 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        //维护两个dp数组：最大、最小
//        int length = nums.length;
//        int[] maxDp = new int[length];
//        int[] minDp = new int[length];
//        maxDp[0] = nums[0];
//        minDp[0] = nums[0];
//        int max = maxDp[0];
//        for (int i = 1; i < nums.length; i++) {
//            int curr = nums[i];
//            //取【最大dp[i-1]*当前，最小dp[i-1]*当前，当前】 三者中的最大和最小
//            maxDp[i] = Math.max(maxDp[i - 1] * curr, Math.max(minDp[i - 1] * curr, curr));
//            minDp[i] = Math.min(maxDp[i - 1] * curr, Math.min(minDp[i - 1] * curr, curr));
//            max = Math.max(maxDp[i], max);
//        }
//        return max;

        //空间优化
        int maxDp = nums[0];
        int minDp = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int tempMax = maxDp;
            int tempMin = minDp;
            maxDp = Math.max(tempMax * curr, Math.max(tempMin * curr, curr));
            minDp = Math.min(tempMax * curr, Math.min(tempMin * curr, curr));
            max = Math.max(maxDp, max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
