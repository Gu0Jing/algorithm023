//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 430 👎 0


import com.sun.deploy.util.ArrayUtil;

import java.util.*;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //1、排序后，利用双指针同步遍历并比较
        //创建指针赋初值
//        int index1 = 0;
//        int index2 = 0;
//        //确定指针边界
//        int length1 = nums1.length;
//        int length2 = nums2.length;
////        //创建结果数组
//        int resIndex = 0;
//        int[] res = new int[Math.min(length1, length2)];
//        //开始遍历，任意指针超出边界即终止
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        while (index1 < length1 && index2 < length2) {
//            if (nums1[index1] == nums2[index2]) {
//                res[resIndex++] = nums1[index1];
//                index1++;
//                index2++;
//            } else if (nums1[index1] > nums2[index2]) {
//                index2++;
//            } else {
//                index1++;
//            }
//        }
//        //实际结果小于等于长度小的数组，要做截取操作
//        return Arrays.copyOfRange(res,0,resIndex);

        //2、哈希表：查询时间复杂度O(1)
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length1 > length2) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        //遍历数组，以值为key，以出现次数为值，存入map
        for (Integer num : nums1) {
            if (map.containsKey(num)) {
                Integer integer = map.get(num);
                integer++;
                map.put(num, integer);
            } else {
                map.put(num, 1);
            }
        }
        int resIndex = 0;
        int[] res = new int[length1];
        //遍历数组，匹配到则出现次数-1，存入结果，知道出现次数为0
        for (Integer num : nums2) {
            if (map.containsKey(num)) {
                Integer integer = map.get(num);
                if (integer > 0) {
                    integer--;
                    map.put(num, integer);
                    res[resIndex++] = num;
                }
            }
        }
        return Arrays.copyOfRange(res, 0, resIndex);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
