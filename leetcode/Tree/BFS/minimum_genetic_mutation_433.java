package Tree.BFS;

import java.lang.annotation.Target;
import java.util.*;

public class minimum_genetic_mutation_433 {

    /**
     * ACGT
     * 1. bfs
     * 2. start有8个位置可以变，每个位置有(4)种变化 ==> N叉树
     * 3. 终止条件：start == end
     * 4. 剪枝
     *  4.1 路径包含在 blank
     *  4.2 记录已访问路径
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation(String start, String end, String[] bank) {
        /**
         * queue = []
         * visited = []
         * vaild = blank
         * queue.add(start)
         * step = 0
         * while !queue:
         *  int len = queue.size
         *  for i in len:
         *      node = queue.pop
         *      if(start == end)
         *          return step
         *      for i in 8:
         *           start[i] = 'A'
         *           start[i] = 'C'
         *           start[i] = 'G'
         *           start[i] = 'T'
         *      if vaild.contains ** !visited.contains
         *           queue.offer
         *  step++
         *          
         */
        Set<String> bankSet = new HashSet<>();
        for (String string : bank) {
            bankSet.add(string);
        }
        if(!bankSet.contains(end)) return -1;
        Deque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        int step = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                String str = queue.poll();
                if(str.equals(end))  return step;
                for (int j = 0; j < 8; j++) {
                    filter(changeChar(j,'A',str),bankSet,visited,queue);
                    filter(changeChar(j,'C',str),bankSet,visited,queue);
                    filter(changeChar(j,'G',str),bankSet,visited,queue);
                    filter(changeChar(j,'T',str),bankSet,visited,queue);
                }
            }
            step++;
        }
        return -1;
    }

    private String changeChar(int j, char c, String str) {
        char[] old = str.toCharArray();
        old[j]= c;
        return new String(old);
    }
    
    private void filter(String str,Set<String> bankSet,Set<String> visited,Deque<String> queue) {
        if(bankSet.contains(str) && !visited.contains(str)) {
            queue.offer(str);
            visited.add(str);
        }
    }

    public static void main(String[] args) {
        minimum_genetic_mutation_433 instance = new minimum_genetic_mutation_433();
        System.out.println(instance.minMutation("AACCGGTT", "AAACGGTA",
         new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}));
    }
}