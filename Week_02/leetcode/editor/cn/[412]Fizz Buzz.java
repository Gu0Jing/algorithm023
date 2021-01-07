//写一个程序，输出从 1 到 n 数字的字符串表示。 
//
// 1. 如果 n 是3的倍数，输出“Fizz”； 
//
// 2. 如果 n 是5的倍数，输出“Buzz”； 
//
// 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。 
//
// 示例： 
//
// n = 15,
//
//返回:
//[
//    "1",
//    "2",
//    "Fizz",
//    "4",
//    "Buzz",
//    "Fizz",
//    "7",
//    "8",
//    "Fizz",
//    "Buzz",
//    "11",
//    "Fizz",
//    "13",
//    "14",
//    "FizzBuzz"
//]
// 
// 👍 78 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        //1、已知判断条件，直接遍历
//        for (int i = 1; i <= n; i++) {
//            if (i % 3 == 0 && i % 5 == 0) {
//                res.add("FizzBuzz");
//            } else if (i % 3 == 0) {
//                res.add("Fizz");
//            } else if (i % 5 == 0) {
//                res.add("Buzz");
//            } else {
//                res.add(String.valueOf(i));
//            }
//        }
//        return res;

        //2、使用哈希表存储映射关系,即利用哈希表存储字典
        //注意字典的插入顺序与题干一致，需要使用LinkedHashMap保证顺序
        Map<Integer, String> dictionary = new LinkedHashMap<>();
        dictionary.put(3, "Fizz");
        dictionary.put(5, "Buzz");
        for (int i = 1; i <= n; i++) {
            StringBuilder resStr = new StringBuilder();
            for (Map.Entry<Integer, String> key : dictionary.entrySet()) {
                if (i % key.getKey() == 0) {
                    resStr.append(key.getValue());
                }
            }
            if (resStr.length() == 0) {
                resStr.append(i);
            }
            res.add(resStr.toString());
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
