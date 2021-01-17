
import java.util.ArrayList;//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 2887 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> list = new ArrayList<>();
    private int[] arr = new int[3];

    public List<List<Integer>> threeSum(int[] nums) {
        //1、暴力
//        HashSet<List<Integer>> lists = new HashSet<>();
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 2; i++) {
//            for (int j = i+1; j < nums.length-1; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        lists.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                    }
//                }
//            }
//        }
//        return new ArrayList<>(lists);

        //2、双指针夹逼：从有序数组中找出满足条件的两个数
        HashSet<List<Integer>> lists = new HashSet<>();
        //排序
        Arrays.sort(nums);
        //固定第一个数，从后面的数组中头尾夹逼
        for (int i = 0; i < nums.length-2; i++) {
            //当前数大于0，左右指针都在当数右侧，三数之和一定大于0，循环结束
            if (nums[i] > 0) {break;}

            //当前数去重(影响很大，不加平均耗时1000ms，加了平均耗时40ms)
            if (i > 0 && nums[i] == nums[i - 1]) {continue;}

            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return new ArrayList<>(lists);

        //3、哈希表
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//        HashSet<List<Integer>> lists = new HashSet<>();
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                Integer index = map.getOrDefault(-(nums[i] + nums[j]), -1);
//                if (index != -1 && index != i && index != j) {
//                    arr = new int[]{nums[i], nums[j], -(nums[i] + nums[j])};
//                    Arrays.sort(arr);
//                    lists.add(Arrays.asList(arr[0],arr[1],arr[2]));
//                }
//            }
//        }
//        return new ArrayList<>(lists);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
