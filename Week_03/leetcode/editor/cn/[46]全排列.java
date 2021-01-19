//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1081 👎 0


import javax.naming.PartialResultException;
import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp  = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        //枚举求解：回溯算法
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i : nums) queue.offer(i);
        dfs(queue);
        return res;
    }

    private void dfs(Deque<Integer> queue) {
        if (queue.isEmpty()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < queue.size(); i++) {
            Integer remove = queue.poll();
            temp.add(remove);
            dfs(queue);
            queue.offer(remove);
            temp.remove(temp.size()-1);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
