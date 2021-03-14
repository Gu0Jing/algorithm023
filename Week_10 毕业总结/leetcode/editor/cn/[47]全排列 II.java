//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 623 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp  = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        //枚举求解：回溯算法
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(0,nums,used);
        return res;

    }

    private void dfs(int idx, int[] nums, boolean[] used) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            //剪枝的关键,理解!used[i - 1]
            // nums[i] == nums[i-1] 表示当前数与前一个数重复，其可能会出现重复搜索的情况
            // not visited[i-1] 表示前一个重复数未使用
            // 对于前一个重复数未使用，说明其将会在后续的搜索中使用到，
            // 也就是说当前搜索层和之前重复数使用的时候的搜索层为同一层，会出现重复搜索，故剪枝
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            used[i] = true;
            dfs(idx + 1, nums, used);
            temp.remove(temp.size()-1);
            used[i] = false;
        }

    }


}
//leetcode submit region end(Prohibit modification and deletion)
