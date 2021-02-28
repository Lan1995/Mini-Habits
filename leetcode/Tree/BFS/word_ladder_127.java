package Tree.BFS;

import java.util.*;
import java.util.stream.Collectors;

public class word_ladder_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int step = 0;
        if(beginWord == null || endWord == null || beginWord.length() != endWord.length()) return step;
        Set<String> wordSet = new HashSet<>(wordList);
        Deque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        
        while(!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                String node = queue.poll();
                System.out.println("step:" + step +",node:" + node);
                if(node.equals(endWord)) return step + 1;           
                for (int j = 0; j < node.toCharArray().length; j++) {
                    char[] old = node.toCharArray();
                    for(char k = 'a';k<='z';k++) {
                        if(old[j] == k) continue;
                        old[j] = k;
                        String newNode = new String(old);
                        if(wordSet.contains(newNode) && !visited.contains(newNode)) {
                            queue.offer(newNode);
                            visited.add(newNode);
                        } 
                    }
                }             
            }
            step++; 
        }
        return 0;
    }


    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }

        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);

        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);
        int step = 1;

        Set<String> visited = new HashSet<>();
        while(!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            if(beginVisited.size() > endVisited.size()) {
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }
            
            Set<String> nextLeveVisited = new HashSet<>();
            for (String node : beginVisited) {
               char[] old = node.toCharArray();
               for (int i = 0; i < old.length; i++) {
                    char originChar = old[i];
                   for (char j = 'a'; j <= 'z'; j++) {
                       if(old[i] == j) continue;
                       old[i] = j;
                       String newNode = new String(old);
                       if(wordSet.contains(newNode)) {
                            if(endVisited.contains(newNode)) return step+1;
                            if(!visited.contains(newNode)){
                                System.out.println("newNode:" + newNode);
                                nextLeveVisited.add(newNode);
                                visited.add(newNode);
                            }     
                       }
                   }
                   old[i] = originChar;
               }
            }
            beginVisited = nextLeveVisited;
            step++;
        }
        return 0;
    }

    public static void main(String[] args) {
        word_ladder_127 test = new word_ladder_127();
       // System.out.println(test.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
        System.out.println(test.ladderLength2("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
    }
}
