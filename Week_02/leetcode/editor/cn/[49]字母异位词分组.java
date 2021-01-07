//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 624 👎 0


import java.util.*;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //哈希表
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());

        //stream 的 groupingBy 效率略低
//        return new ArrayList<>(Arrays.stream(strs)
//                .collect(Collectors.groupingBy(str -> {
//                    // 返回 str 排序后的结果。
//                    // 按排序后的结果来grouping by，算子类似于 sql 里的 group by。
//                    char[] array = str.toCharArray();
//                    Arrays.sort(array);
//                    return new String(array);
//                })).values());

    }
}
//leetcode submit region end(Prohibit modification and deletion)
