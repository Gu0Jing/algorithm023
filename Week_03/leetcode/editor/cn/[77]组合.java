//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 469 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    ArrayList<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        recursion(1,n,k);
        return res;
    }

    private void recursion(int start, int n, int k) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }

        //剪枝的关键
        int limit = n - (k - temp.size()) + 1;
//        limit = n;
        for (int i = start; i <= limit; i++) {
            temp.add(i);
            recursion(i + 1, n, k);

            //DFS有回头的过程，所以递归之前做了什么，递归之后需要逆向操作
            temp.remove(temp.size() - 1);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
