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
// 👍 900 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        //入参校验
        if (nums == null || nums.length == 0) {
            return;
        }
        //添加零元素指针指向第一个元素
        //遍历数组，如果当前元素不是0，且不和零指针重合，交换位置
        //当前元素不是0时，零指针向后移动
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (zeroIndex != i) {
                    nums[zeroIndex] = nums[i];
                    nums[i] = 0;
                }
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
