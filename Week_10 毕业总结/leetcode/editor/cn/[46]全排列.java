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
// 👍 1193 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<Integer> list = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int[] used = new int[nums.length];
        dfs(0,nums,used);
        return res;
    }

    private void dfs(int depth, int[] nums, int[] used) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 0) {
                used[i] = 1;
                list.add(nums[i]);
                dfs(depth + 1, nums,used);
                used[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
