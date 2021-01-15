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
// 👍 1414 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        //1、第n个数=前两个数的和：递归求斐波拉契数列
        //结果数组长度=n+2,是为了兼容n=1的情况
        //n>=2之后，数组最后一位都是空的
//        int[] res = new int[n + 2];
//        res[1] = 1;
//        res[2] = 2;
//        for (int i = 3; i <= n; i++) {
//            res[i] = res[i - 1] + res[i - 2];
//        }
//        return res[n];

        //2、动态规划递归的空间复杂度优化
        if (n <= 2) {
            return n;
        }
        int a = 1, b = 1, c = 2;
        for (int i = 3; i <= n; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;

        //3、递归:直接递归涉及大量重复计算，时间复杂度很高
//        if (n == 0 || n == 1) {
//            return 1;
//        }
//        return climbStairs(n - 1) + climbStairs(n - 2);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
