//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 动态规划 
// 👍 1040 👎 0


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        //类比爬楼梯
        //1、广度优先遍历
        Deque<Integer> queue = new ArrayDeque<>();

        //数组来存储节点是否被访问，效率提高一个数量级
//        HashSet<Integer> visited = new HashSet<>();
        boolean[] visited = new boolean[amount + 1];

        if (amount == 0) {//特殊情况
            return 0;
        }
        queue.offer(amount);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            while (size-- > 0) {
                Integer poll = queue.poll();
                for (int coin : coins) {
                    int next = poll - coin;
                    if (next == 0) {
                        return depth;
                    }
                    //剪枝，节点第一次访问时的路径最短，重复访问的节点直接舍弃
                    //避免出现全部由面值1凑数的情况，加速，否则会超时
                    if (next > 0 && !visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }
        return -1;

        //2、DP
        //dp[i]:兑换钱数i需要的硬币数
        //dp[i] = dp[i-coin]+1
//        int[] dp = new int[amount + 1];
//        Arrays.fill(dp, amount + 1);
//        dp[0] = 0;
//        for (int i = 1; i <= amount; i++) {
//            for (int coin : coins) {
//                if (coin <= i) {
//                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
//                }
//            }
//        }
//        return dp[amount] > amount ? -1 : dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
