package greedy;

import java.util.Arrays;

public class assign_cookie_455 {
    public int findContentChildren(int[] g, int[] s) {
        if(g == null || s == null || g.length <= 0 || s.length <= 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int fill = 0;
        for (int i = 0,j=0; i < s.length && j < g.length; i++) {
            if(s[i] >= g[j]) {
                fill++;
                j++;
            }
        }
        return fill;
    }
}
