//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2856 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums==null||nums.length<=2) {
            return Collections.emptyList();
        }

        //1、暴力枚举：三重遍历
        //a+b+c=0
        //排序后，利用Set集合的唯一性去重
//        Arrays.sort(nums);
//        Set<List<Integer>> lists = new LinkedHashSet<>();
//        for (int i = 0; i < nums.length - 2; i++) {
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
//                        lists.add(list);
//                    }
//                }
//            }
//        }
//        return new ArrayList<>(lists);

        //2、双指针夹逼，前提是有序数组
        Arrays.sort(nums);
        Set<List<Integer>> res = new LinkedHashSet<>();
        for (int k = 0; k < nums.length - 2; k++) {
            int left = k+1;
            int right = nums.length-1;
            while (left < right) {
                int sum = nums[k] + nums[left] + nums[right];
                if (0 == sum) {
                    List<Integer> list = Arrays.asList(nums[k], nums[left], nums[right]);
                    res.add(list);
                    left++;
                } else if (0 > sum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(res);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
