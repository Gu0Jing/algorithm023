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
// 👍 713 👎 0


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        //单向BFS
//        HashSet<String> visited = new HashSet<>();
//        Deque<String> queue = new ArrayDeque<>();
//        queue.offer(beginWord);
//        visited.add(beginWord);
//        int countNode = 1;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            while (size-- > 0) {
//                String currWord = queue.poll();
//                if (checkNode(currWord, endWord, queue,visited, wordSet)) {
//                    return ++countNode;
//                }
//            }
//            countNode++;
//        }
//        return 0;

        //双向BFS
        HashSet<String> visited = new HashSet<>();
        HashSet<String> beginVisited = new HashSet<>();
        HashSet<String> endVisited = new HashSet<>();
        beginVisited.add(beginWord);
        endVisited.add(endWord);
        int nodeCount=1;
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            if (beginVisited.size() > endVisited.size()) {
                HashSet<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }
            HashSet<String> newBeginVisited = new HashSet<>();
            for (String currWord : beginVisited) {
                if (doubleCheckNode(currWord, wordSet, visited, endVisited, newBeginVisited)) {
                    return ++nodeCount;
                }
            }
            beginVisited = newBeginVisited;
            nodeCount++;
        }
        return 0;

    }

    private boolean doubleCheckNode(String currd, HashSet<String> wordSet, HashSet<String> visited, HashSet<String> endVisited, HashSet<String> newBeginVisited) {
        char[] chars = currd.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char oriChar = chars[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (chars[i] == j) {
                    continue;
                }
                chars[i] = j;
                String newWord = String.valueOf(chars);
                if (wordSet.contains(newWord)) {
                    if (endVisited.contains(newWord)) {
                        return true;
                    }
                    if (!visited.contains(newWord)) {
                        visited.add(newWord);
                        newBeginVisited.add(newWord);
                    }
                }
            }
            chars[i] = oriChar;
        }
        return false;
    }

    private boolean checkNode(String currWord, String endWord, Deque<String> queue, HashSet<String> visited, HashSet<String> wordSet) {
        char[] chars = currWord.toCharArray();
        for (int i = 0; i < currWord.length(); i++) {
            char oriChar = chars[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (chars[i] == j) {
                    continue;
                }
                chars[i] = j;
                String newWord = String.valueOf(chars);
                if (wordSet.contains(newWord)) {
                    if (newWord.equals(endWord)) {
                        return true;
                    } else if (!visited.contains(newWord)) {
                        visited.add(newWord);
                        queue.add(newWord);
                    }
                }
            }
            chars[i] = oriChar;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
