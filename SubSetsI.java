/*
  Print all subsets of a set S
  Assumption: there are no duplicate characters in the given string.
*/
import java.util.List;
import java.util.ArrayList;

public class SubSetsI{
  /*
    Method 1: DFS solution
  */
  public List<String> subSetsI(String set){
    List<String> result = new ArrayList<String>();
    if (set == null) return result;
    char[] arraySet = set.toCharArray();
    StringBuilder sb = new StringBuilder();
    helperI(arraySet, sb, 0, result);
    return result;
  }

  private void helperI(char[] arraySet, StringBuilder sb, int index, List<String> result){
    if (index == arraySet.length){
      result.add(sb.toString());
      return;
    }
    helperI(arraySet, sb, index + 1, result);
    helperI(arraySet, sb.append(arraySet[index]), index + 1, result);
    sb.deleteCharAt(sb.length() - 1);
  }

  /*
    Method 2: Another DFS solution
  */
  public List<String> subSetsII(String set){
    List<String> result = new ArrayList<String>();
    if (set == null) return result;
    char[] arraySet = set.toCharArray();
    StringBuilder sb = new StringBuilder();
    helperII(arraySet, sb, 0, result);
    return result;
  }

  private void helperII(char[] arraySet, StringBuilder sb, int index, List<String> result){
    result.add(sb.toString());
    for(int i = index; i < arraySet.length; i++){
      sb.append(arraySet[i]);
      helperII(arraySet, sb, i + 1, result); //  important!!!! here is i+1!!!!!!!!!
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  public static void main(String[] args){
    SubSetsI solution = new SubSetsI();
    String test = "abc";

    List<String> result = solution.subSetsI(test);
    System.out.println(result);

    result = solution.subSetsII(test);
    System.out.println(result);
  }

}
