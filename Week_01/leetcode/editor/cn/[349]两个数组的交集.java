//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 306 👎 0


import java.util.*;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        //1、利用HashSet唯一性直接判断：3ms
//        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
//            return new int[0];
//        }
//        Set<Integer> parentSet = new HashSet<>();
//        Set<Integer> childSet = new HashSet<>();
//        for (int num : nums1) {
//            parentSet.add(num);
//        }
//        for (int num : nums2) {
//            if (parentSet.contains(num)) {
//                childSet.add(num);
//            }
//        }
//        int[] resArr = new int[childSet.size()];
//        int index = 0;
//        for (int value : childSet) {
//            resArr[index++] = value;
//        }
//        return resArr;

        //2、数组1排序后,遍历数组2,在数组1中二分查找:3ms
//        Arrays.sort(nums1);
//        //结果集利用set去重
//        Set<Integer> resSet = new HashSet<>();
//        for (int i = 0; i < nums2.length; i++) {
//            if (binarySearch(nums1, nums2[i])) {
//                resSet.add(nums2[i]);
//            }
//        }
//        int[] resArr = new int[resSet.size()];
//        int index = 0;
//        for (int value : resSet) {
//            resArr[index++] = value;
//        }
//        return resArr;

        //3、排序后双指针遍历比较
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, len2 = nums2.length;
        int[] res = new int[Math.min(len1, len2)];
        int resIndex = 0;
        int index1 = 0;
        int index2 = 0;
        while (index1 < len1 && index2 < len2) {
            int num1 = nums1[index1];
            int num2 = nums2[index2];
            if (num1 == num2) {
                //保证结果元素的唯一性
                if (resIndex == 0 || num1 != res[resIndex - 1]) {
                    res[resIndex++] = num1;
                }
                index1++;
                index2++;
            } else if (num1 > num2) {
                index2++;
            } else {
                index1++;
            }
        }
        return Arrays.copyOfRange(res, 0, resIndex);

        //4、直接调用内置api：10ms
//        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
//        return Arrays.stream(nums2).distinct().filter(set::contains).toArray();
    }

    private boolean binarySearch(int[] nums1, int target) {
        int left = 0;
        int right = nums1.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums1[mid] == target) {
                return true;
            } else if (target > nums1[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
