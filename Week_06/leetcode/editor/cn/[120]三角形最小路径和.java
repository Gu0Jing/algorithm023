//给定一个三角形 triangle ，找出自顶向下的最小路径和。 
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -104 <= triangle[i][j] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
// Related Topics 数组 动态规划 
// 👍 685 👎 0


import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private final HashMap<Pair<Integer,Integer>, Integer> map = new HashMap<>();
    private Integer[][] memory;
    public int minimumTotal(List<List<Integer>> triangle) {
        //1.1 递归+记忆化搜索 (map:pair)，自上而下
//        return dfs1(triangle,0,0);

        //1.2 递归+记忆化搜索 (int[i][j])，自上而下 --时间复杂度最优--
//        memory = new Integer[triangle.size()][triangle.size()];
//        return dfs2(triangle,0,0);

        //2、动态规划，自下而上，递推
//        重复性:当前位置的最小路径和是下一行左右两个最小的路径和加上当前的值
        int size = triangle.size();
        int[][] dp = new int[size + 1][size + 1];//dp长度=size+1，等于在三角最下方加一个全是0的辅助层
        for (int i = size - 1; i >= 0; i--) {//从真实底层开始向上
            for (int j = 0; j < triangle.get(i).size(); j++) {
                //最开始是真实底层，每个位置的最小路径=辅助层相邻位置的值（全是0）+ 自身值
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    private int dfs1(List<List<Integer>> triangle, int depth, int j) {
        //termination
        if (depth >= triangle.size()) {
            return 0;
        }
        Pair<Integer,Integer> pair = new Pair<>(depth, j);
        if (map.containsKey(pair)) {
            return map.get(pair);
        }
        //process
        int max = triangle.get(depth).get(j);
        int sum1 = dfs1(triangle, depth + 1, j);
        int sum2 = dfs1(triangle, depth + 1, j+1);

        max += Math.min(sum1, sum2);
        map.put(new Pair<>(depth, j), max);
        return max;
    }

    private int dfs2(List<List<Integer>> triangle, int depth, int j) {
        //termination
        if (depth >= triangle.size()) {
            return 0;
        }
        if (memory[depth][j] != null) {
            return memory[depth][j];
        }
        //process
        int max = triangle.get(depth).get(j);
        int sum1 = dfs2(triangle, depth + 1, j);
        int sum2 = dfs2(triangle, depth + 1, j+1);

        memory[depth][j] = Math.min(sum1, sum2) + max;
        return memory[depth][j];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
