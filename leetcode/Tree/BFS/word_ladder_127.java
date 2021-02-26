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
        Set<Character> changeCharSet = new HashSet<>();
        for (Character character : beginWord.toCharArray()) {
            changeCharSet.add(character);
        }

        for (Character character : endWord.toCharArray()) {
            changeCharSet.add(character);
        }
        wordList.forEach(e -> {
            for (Character character : e.toCharArray()) {
                changeCharSet.add(character);
            } 
        });
        List<Character> changeChar = new ArrayList<>(changeCharSet);
        
        while(!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                String node = queue.poll();
                System.out.println("step:" + step +",node:" + node);
                if(node.equals(endWord)) return step + 1;           
                for (int j = 0; j < node.toCharArray().length; j++) {
                    for (int k = 0; k < changeChar.size(); k++) {
                        char[] old = node.toCharArray();
                        old[j] = changeChar.get(k);
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
    public static void main(String[] args) {
        word_ladder_127 test = new word_ladder_127();
        System.out.println(test.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
    }
}
