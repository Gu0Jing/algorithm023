//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列： 
//
// 
// 序列中第一个单词是 beginWord 。 
// 序列中最后一个单词是 endWord 。 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典 wordList 中的单词。 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中
//的 单词数目 。如果不存在这样的转换序列，返回 0。 
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
// Related Topics 广度优先搜索 
// 👍 684 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private Set<String> visited;
    private Set<String> wordDic;
    private Deque<String> queue = new ArrayDeque<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //抽象成：求无向图的最短路径，广度优先（类比同心圆，圆心是出发点，见图片）
        wordDic = new HashSet<>(wordList);//初始化字典集合
        visited = new HashSet<>();

        queue.offer(beginWord);//广度优先遍历出发点
        visited.add(beginWord);//已遍历集合

        int nodeCount = 1;//求的是节点数，beginWord自身为第1个节点
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String currWord = queue.poll();
                //临近点查找：找到终点直接返回true；否则入队途经点同时标记，防止再次遍历
                if (replaceAndCompare(currWord, endWord)) {
                    return ++nodeCount;
                }
            }
            ++nodeCount;
        }
        return 0;
    }

    /* 临近点查找：
     * 首先将所有的字符存到结构为HashSet的dic字典里去，然后将当前单词的每一位挨个从a变到z,
     * 在变化的时候实时去字典里查，因为是hashset，所以复杂度是O(1)，非常快。*/
    private boolean replaceAndCompare(String currWord, String endWord) {
        char[] chars = currWord.toCharArray();
        //将当前单词的每一位挨个从a变到z
        for (int i = 0; i < currWord.length(); i++) {//遍历每一位
            char oriChar = chars[i];//保存初值，下次循环前还原
            for (char j = 'a'; j <= 'z'; j++) {//26个字母挨个替换当前位
                if (j == oriChar) {
                    continue;
                }
                chars[i] = j;
                String newWord = String.valueOf(chars);
                //新单词存在于字典中
                if (wordDic.contains(newWord)) {
                    if (newWord.equals(endWord)) {//新单词就是终点
                        return true;
                    }
                    if (!visited.contains(newWord)) {//新单词不是终点，且未被遍历过
                        queue.offer(newWord);
                        visited.add(newWord);
                    }
                }
            }
            chars[i] = oriChar;//还原初值
        }
        return false;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
