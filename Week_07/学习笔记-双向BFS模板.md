双向BFS模板

     //创建两个哈希表代替单向BFS的队列，存储已扩散到的节点
     HashSet<String> beginVisited = new HashSet<>();
     HashSet<String> endVisited = new HashSet<>();
     beginVisited.add(beginWord);
     endVisited.add(endWord);
     
     //两个哈希表都不为空时才能扩撒，任意哈希表为空时意味着无向图本身断连，两端不相连，无法扩散
     while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
         //始终从最小的哈希表启动扩散，使扩散交汇点在中间，剪枝效率最优
         if (beginVisited.size() > endVisited.size()) {
             HashSet<String> temp = beginVisited;
             beginVisited = endVisited;
             endVisited = temp;
         }
         //遍历哈希表，将扩散到的新节点放入新哈希表中（模拟队列出队入队）
         HashSet<String> newBeginVisited = new HashSet<>();
         for (Node currNode : beginVisited) {
             if (endVisited.contains(currNode)) {//当前节点在另一端的扩散表中，表示两端扩散相交了
                 return true;
             }
             if (!visited.contains(newWord)) {//否则如果未被扩散过，添加至新扩散表
                 visited.add(newWord);
                 newBeginVisited.add(newWord);
             }
         }
         beginVisited = newBeginVisited;
         nodeCount++;
     }
     return false;

