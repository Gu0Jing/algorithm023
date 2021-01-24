//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//
// 进阶： 
//
// 
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// 
// Related Topics 位运算 数组 分治算法 
// 👍 844 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        //1、哈希表
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int limit = nums.length >> 1;
//        for (Integer i : nums) {
//            int count = map.getOrDefault(i, 0) + 1;
//            if (count > limit) {
//                return i;
//            }
//            map.put(i, count);
//        }
//        return -1;

        //2、排序
//        Arrays.sort(nums);
//        return nums[nums.length / 2];

        //3、投票
        int tar = -1;
        int count = 0;
        for (int curr : nums) {
            if (count == 0) {
                tar = curr;
            }
            count += (curr == tar) ? 1 : -1;
        }
        return tar;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
