//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 728 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (length < 4) {
            return res;
        }
        int left,right;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {continue;}
            if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3]>target){break;}
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {continue;}
            for (int j = i+1; j < nums.length - 2; j++) {
                left = j + 1;
                right = nums.length - 1;
                if (j > i+1 && nums[j] == nums[j - 1]) {continue;}
                if(nums[i] + nums[j] + nums[j+1] + nums[j+2]>target){break;}
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {continue;}
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (target == sum) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left<right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left<right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                    } else if (target > sum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
