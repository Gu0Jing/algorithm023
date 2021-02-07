//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 动态规划 
// 👍 1265 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1) {
            return len == 0 ? 0 : nums[0];
        }

        //1、dp[][]：存储多维信息可以采用数组升维的方式
        //第一维存储前i间房屋偷盗的最大金额
        //第二维存储偷不偷当前屋：0不偷，1偷
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < len; i++) {
            //不同当前房屋i，那么房屋i-1 可偷可不偷
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);

        //2、dp[]
        //dp[i]存储前i间房屋偷盗的最大金额
        //情况1：偷第i间：dp[i]=dp[i-2]+nums[i]
        //情况2：不偷i间：dp[i]=dp[i-1]
        //综上：dp[i]=max(dp[i-2]+nums[i],dp[i-1])
//        int[] dp = new int[len];
//        dp[0]=nums[0];//只有一间房
//        dp[1]=Math.max(nums[0],nums[1]);//有二间房
//        for (int i = 2; i < len; i++) {//有三间房。。。
//            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
//        }
//        return dp[len - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
