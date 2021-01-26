//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
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
// 👍 2910 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> list = new LinkedList<>();

    //犹豫不决先排序，步步逼近双指针
    public List<List<Integer>> threeSum(int[] nums) {
        //1、暴力:三重循环，超时
//        Arrays.sort(nums);
//        Set<List<Integer>> lists = new HashSet<>();
//        for (int i = 0; i < nums.length - 2; i++) {
//            for (int j = i+1; j < nums.length - 1; j++) {
//                for (int k = j+1; k < nums.length; k++) {
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        lists.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                    }
//                }
//            }
//        }
//        return new ArrayList<>(lists);

        //2.1、哈希map:双重循环，2100ms
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//        HashSet<List<Integer>> setList = new HashSet<>();
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                int tar = -(nums[i] + nums[j]);
//                int index = map.getOrDefault(tar, -1);
//                if (index != -1 && index != i && index != j) {
//                //结果排序后，利用set去重
//                setList.add(sortNums(nums[i], nums[j], tar));
//                }
//            }
//        }
//        return new ArrayList<>(setList);

        //2.2、哈希set:双重循环，1900ms
//        HashSet<Integer> set = new HashSet<>();
//        HashSet<List<Integer>> setList = new HashSet<>();
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                int tar = -(nums[i] + nums[j]);
//                if (set.contains(tar)) {
//                    //结果排序后，利用set去重
//                    setList.add(sortNums(nums[i], nums[j], tar));
//                } else {
//                    set.add(nums[j]);//加入字典
//                }
//            }
//            set.clear();//清空上一层加入的字典
//        }
//        return new ArrayList<>(setList);

        //2.3、哈希set加速，130ms
//        HashSet<Integer> set = new HashSet<>();
//        Arrays.sort(nums);//加速前提，有序数组
//        //已知条件：a+b+c=0
//        for (int i = 0; i < nums.length - 1; i++) {//固定a
//            //加速1：a=nums[i],a>0不可能满足a+b+c=0
//            if (nums[i] > 0) {break;}
//            //加速2：当前数a和前一个数相同，跳过,防止结果重复
//            if (i > 0 && nums[i] == nums[i - 1]) {continue;}
//            for (int j = i + 1; j < nums.length; j++) {//固定b
//                int tar = -(nums[i] + nums[j]);//求c
//                if (set.contains(tar)) {
//                    list.add(Arrays.asList(nums[i], nums[j], tar));
//                    //加速3：当前数b和后一个数相同，跳过，防止结果重复
//                    while ((j + 1) < nums.length && nums[j] == nums[j + 1]) {
//                        ++j;
//                    }
//                } else {
//                    set.add(nums[j]);//b加入字典
//                }
//            }
//            set.clear();//清空上一层加入的字典
//        }
//        return list;

        //3、排序双指针，20ms
        Arrays.sort(nums);
        int head;
        int tail;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {//加速
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {//加速、去重
                continue;
            }
            head = i + 1;//重置头指针
            tail = nums.length - 1;//重置尾指针
            while (head < tail) {
                int sum = nums[i] + nums[head] + nums[tail];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[head], nums[tail]));
                    while (head < tail && nums[head] == nums[head + 1]) {//头指针去重
                        head++;
                    }
                    while (head < tail && nums[tail] == nums[tail - 1]) {//尾指针去重
                        tail--;
                    }
                    head++;//or tail--，进入下一轮比较
                } else if (sum > 0) {
                    tail--;
                } else {
                    head++;
                }
            }
        }
        return list;

//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 2; i++) {
//            // 加速1：c为非负数，就不能满足a+b+c=0了
//            if (nums[i] > 0) {
//                break;
//            }
//            // 加速2：跳过计算过的数据，同时防止结果重复
//            if (i != 0 && nums[i] == nums[i-1]) {
//                continue;
//            }
//            int head = i + 1;
//            int tail = nums.length - 1;
//            while (head < tail) {
//                int sum = -(nums[head] + nums[tail]);
//                if (sum == nums[i]) {
//                    list.add(Arrays.asList(nums[i], nums[head], nums[tail]));
//                    // 加速3：跳过计算过的数据，同时防止结果重复
//                    while (head < tail && nums[head] == nums[head+1]) {
//                        head++;
//                    }
//                    while (head < tail && nums[tail] == nums[tail-1]) {
//                        tail--;
//                    }
//                }
//                if (sum <= nums[i]) {
//                    tail--;
//                } else {
//                    head++;
//                }
//            }
//        }
//        return list;
    }

    private List<Integer> sortNums(int a,int b,int c) {
        List<Integer> list = Arrays.asList(a, b, c);
        list.sort(Comparator.naturalOrder());
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
