package Recursion.BackTrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letter_combinations_of_a_phone_number_17 {

  Map<Character, String> map = new HashMap<>();

  public List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<>();
    if (digits.length() == 0) {
      return res;
    }
    StringBuilder path = new StringBuilder();
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mon");
    map.put('7', "pars");
    map.put('8', "tuv");
    map.put('9', "wxyz");
    backTrack(digits, 0,  path, res);
    return res;
  }

  private void backTrack(String digits, int level, StringBuilder path,
      List<String> res) {
    if (level == digits.length()) {
      res.add(path.toString());
      return;
    }
      String num = map.get(digits.charAt(level));
      for (int c = 0; c < num.toCharArray().length; c++) {
        StringBuilder newPath = new StringBuilder(path);
        newPath.append(num.charAt(c));
        backTrack(digits, level+1, newPath, res);
      }

  }

  public static void main(String[] args) {
    letter_combinations_of_a_phone_number_17 test = new letter_combinations_of_a_phone_number_17();
    System.out.println(test.letterCombinations("23"));
  }
}
