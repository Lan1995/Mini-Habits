package Recursion;

import java.util.HashMap;
import java.util.Map;

public class climbing_stairs_70 {
    Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        return _recursion(n);
    }

    private int _recursion(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 1) {
            map.put(n, 1);
            return map.get(n);
        }
        if (n == 2) {
            map.put(n, 2);
            return map.get(n);
        }
        map.put(n - 1, _recursion(n - 1));
        map.put(n - 2, _recursion(n - 2));
        return map.get(n - 1) + map.get(n - 2);
    }
}
