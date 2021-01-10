//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 908 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        //1、双指针
//        int left = 0;
//        int right = 0;
//        while (right < nums.length) {
//            if (nums[right] != 0) {
//                swap(nums, left, right);
//                left++;
//            }
//            right++;
//        }
        //2、零指针
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (zeroIndex != i) {
                    //当前元素不为零且不和零指针重叠，交换
                    swap(nums, zeroIndex, i);
                }
                //当前元素不为零时，零指针右移
                zeroIndex++;
            }
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
