/*
  Print all combinations of coins that can sum up to a total value of k
  coin value = 25 10 5 1
*/

import java.util.List;
import java.util.ArrayList;

public class CombinationsOfCoins{
  public List<List<Integer>> combinations(int target, int[] coins){
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> current = new ArrayList<Integer>();
    helper(result, current, 0, coins, target);
    return result;
  }

  private void helper(List<List<Integer>> result, List<Integer> cur, int index, int[] coins, int target){
    if (index == coins.length - 1){
      if (target % coins[coins.length - 1] == 0){
        cur.add(target / coins[coins.length - 1]);
        result.add(new ArrayList<Integer>(cur));
        cur.remove(cur.size() - 1);
      }
      return;
    }
    int max = target / coins[index];
    for (int i = 0; i <= max; i++){
      cur.add(i);
      helper(result, cur, index + 1, coins, target - i * coins[index]);
      cur.remove(cur.size() - 1);
    }
  }
}
