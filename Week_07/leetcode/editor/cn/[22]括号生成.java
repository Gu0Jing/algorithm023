//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1565 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    ArrayList<String> res = new ArrayList<>();
    int n;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs( "",0,0);
        return res;
    }

    private void dfs(String start, int left, int right) {
        if (left == n && right == n) {
            res.add(start);
            return;
        }

        if (left < n) {
            dfs(start + "(", left + 1, right);
        }
        if (right < left) {
            dfs(start + ")", left, right + 1);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
