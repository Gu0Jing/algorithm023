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
// 👍 697 👎 0


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private HashSet<String> wordDic;
    private HashSet<String> visited;
    private Deque<String> queue = new ArrayDeque<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //1、单向BFS
        //思路：起始单词作为头节点，每个和头节点相差一个字母的单词都是其字节点。。。
        //如此扩散到终止单词
        //检查每个子节点：子节点要在wordList中，且指访问一次，避免回波
        // 如果子节点在wordList中，且等于endWord，结束；否则作为下一个头节点扩散
//        wordDic = new HashSet<>(wordList);
//        visited = new HashSet<>();
//        if (!wordDic.contains(endWord)) {
//            return 0;
//        }
//        queue.offer(beginWord);
//        visited.add(beginWord);
//        int nodeCount = 1;
//
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            while (size-- > 0) {
//                String currWord = queue.poll();
//                if (currWord != null) {
//                    if (checkNode(currWord, endWord)) {
//                        return ++nodeCount;
//                    }
//                }
//            }
//            nodeCount++;
//        }
//        return 0;

        //2、双向BFS
        wordDic = new HashSet<>(wordList);//创建字典
        visited = new HashSet<>();//创建已访问节点结合
        if (!wordDic.contains(endWord)) {
            return 0;
        }
        //创建始末扩散结合代替单向BFS的队列
        HashSet<String> beginVisited = new HashSet<>();
        HashSet<String> endVisited = new HashSet<>();
        beginVisited.add(beginWord);
        endVisited.add(endWord);

        int nodeCount = 1;//扩散到的节点数，头节点算第一个
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            //始终从长度最小的哈希表扩散，剪枝效率最优
            if (beginVisited.size() > endVisited.size()) {
                HashSet<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }
            //遍历哈希表，将扩散到的新节点放入新哈希表中（模拟队列出队入队）
            HashSet<String> newBeginVisited = new HashSet<>();
            for (String currWord : beginVisited) {
                if (doubleCheckNode(currWord, newBeginVisited, endVisited)) {
                    return ++nodeCount;
                }
            }
            beginVisited = newBeginVisited;
            nodeCount++;
        }
        beginVisited.forEach(System.out::println);
        System.out.println("--------");
        endVisited.forEach(System.out::println);
        System.out.println("--------");
        visited.forEach(System.out::println);

        return 0;
    }

    private boolean doubleCheckNode(String currWord, HashSet<String> newBeginVisited, HashSet<String> endVisited) {
        char[] chars = currWord.toCharArray();
        for (int i = 0; i < currWord.length(); i++) {
            char oriChar = chars[i];
            for (char j = 'a'; j <= 'z'; j++) {
                chars[i] = j;
                String newWord = String.valueOf(chars);
                if (wordDic.contains(newWord)) {
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

    private boolean checkNode(String currWord, String endWord) {
        char[] chars = currWord.toCharArray();
        for (int i = 0; i < currWord.length(); i++) {
            char oriChar = chars[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (oriChar == j) {//跳过自己，加速
                    continue;
                }
                chars[i] = j;
                String newWord = String.valueOf(chars);
                if (wordDic.contains(newWord)) {
                    if (newWord.equals(endWord)) {
                        return true;
                    }
                    if (!visited.contains(newWord)) {
                        queue.offer(newWord);
                        visited.add(newWord);
                    }
                }
            }
            chars[i] = oriChar;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
