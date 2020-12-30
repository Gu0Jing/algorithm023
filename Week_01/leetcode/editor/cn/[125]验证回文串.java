//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 307 👎 0


import com.sun.deploy.util.StringUtils;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        //过滤字符串,只保留字母和数字
        StringBuilder filterStr = filterString(s);
        String string = filterStr.toString();

        //方法一：反转字符串后比较是否相等
//        //反转字符串
//        String reverseStr = filterStr.reverse().toString();
//
//        //比较是否相等
//        return string.equals(reverseStr);

        //方法二：前后指针比较字符是否相等
        int left = 0;
        int right = string.length()-1;
        while (left < right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    private StringBuilder filterString(String string) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <string.length(); i++) {
            char c = string.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
