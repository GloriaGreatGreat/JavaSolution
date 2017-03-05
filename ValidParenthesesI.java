/*
  Find all valid permutation using the parenthesis provided
  Restriction: here is whenever we insert a new ')' we need to make sure the number of '('
  added so far is larger than the number of ')' added so far
*/

import java.util.List;
import java.util.ArrayList;

public class ValidParenthesesI{
  public List<String> validParentheses(int k){
    // here k is the number of pairs of parentheses
    List<String> result = new ArrayList<String>();
    char[] cur = new char[k * 2];
    helper(cur, k, k, 0, result);
    return result;
  }
  // left: how many "(" we still have
  // right: how many ")" we still have
  // index: the current position in cur that need to be filled with "(" or ")"
  private void helper(char[] cur, int left, int right, int index, List<String> result){
    if (left == 0 && right == 0){
      result.add(new String(cur));
      return;
    }
    if (left > 0){
      cur[index] = '(';
      helper(cur, left - 1, right, index + 1, result);
    }
    if (right > left){
      cur[index] = ')';
      helper(cur, left, right - 1, index + 1, result);
    }
  }

  public static void main(String[] args){
    ValidParenthesesI solution = new ValidParenthesesI();

    List<String> result = solution.validParentheses(2);
    System.out.println(result);
  }
}
