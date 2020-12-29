//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1397 👎 0

//动态规划算法题
//爬到第n级楼梯之前只有两个状态：再爬1步(第n-1级楼梯)，再爬2步(第n-2级楼梯)
//定义 爬到第n级楼梯需要的方法次数 为 f(n)
//则有：f(n)=f(n-1)+f(n-2)，且有f(1)=1,f(0)=1
//根据公式可知爬n级楼梯需要的爬法f(1)到f(n)构成斐波那契数列
//解法一：根据斐波那契数列的通项公式直接计算
//解法二：利用动态规划思想发现的递归公式计算
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
    //解法二常规写法：空间复杂度O(n)
        //数组dp[n]存储第n级楼梯需要的爬法次数
        int[] dp = new int[n + 1];
        //初始值
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    //解法二优化写法：利用滚动数组，空间复杂度降至O(1)
        //长度3的数组，其中的三个元素用p、q、r表示
//        int p = 0, q = 0, r = 1;
//        for (int i = 1; i <= n; ++i) {
//            p = q;
//            q = r;
//            r = p + q;
//        }
//        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
