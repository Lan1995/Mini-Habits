package Recursion;

import java.util.ArrayList;
import java.util.List;

public class generate_parentheses_22 {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        _recursion(0, 0, n, "");
        return res;
    }

    private void _recursion(int left, int right, int max, String s) {
        //terminator
        if (left == max && right == max) {
            res.add(s);
            return;
        }
        //process cur logic
//        String s1 = s + "(";
//        String s2 = s + ")";
        //drill down
        if(left < max) {
            _recursion(left+1,right,max,s+"(");
        }
        if(left > right) {
            _recursion(left,right+1,max,s+")");
        }
        //clear state
    }

    public static void main(String[] args) {
        generate_parentheses_22 generate_parentheses_22 = new generate_parentheses_22();
        System.out.println(generate_parentheses_22.generateParenthesis(3));
    }
}
