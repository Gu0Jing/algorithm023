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
// 👍 1421 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        //1、动态规划
        //结果数组长度=n+2,是为了兼容n=1的情况
        //n>=2之后，数组最后一位都是空的
//        int[] res = new int[n + 2];
//        res[1] = 1;
//        res[2] = 2;
//        for (int i = 3; i <= n; i++) {
//            res[i] = res[i - 1] + res[i - 2];
//        }
//        return res[n];

        //2、动态规划空间复杂度优化
//        if (n<=2) {return n;}
//        int temp;
//        int p = 1;
//        int q = 2;
//        for (int i = 3; i <=n ; i++) {
//            temp = p;
//            p = q;
//            q = temp + p;
//        }
//        return q;

        //3、递归
        if (n == 1 || n == 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
