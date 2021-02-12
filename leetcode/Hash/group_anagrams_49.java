package Hash;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class group_anagrams_49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = new String(chars);
            List<String> value = map.getOrDefault(sortStr, new ArrayList<>());
            value.add(str);
            map.put(sortStr, value);
        }
        List<List<String>> res = new ArrayList<>();
        map.forEach((k, v) -> res.add(v));
        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        return new ArrayList<>(Stream.of(strs).collect(Collectors.groupingBy(str-> {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) -'a']++;
            }
            //e.g. a1b2c3
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if(count[i] != 0){
                    sb.append('a' + i);
                    sb.append(count[i]);
                }
            }
            return sb.toString();
        })).values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
