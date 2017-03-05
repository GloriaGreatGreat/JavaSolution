import java.util.Arrays;

public class ClassicalBinarySearch{
  public int binarySearch(int[] array, int target){
    if (array == null || array.length == 0) return -1;
    int left = 0;
    int right = array.length - 1;
    while (left <= right){ // here use <=
      int mid = left + (right - left)/2;
      if (target == array[mid]) return mid;
      else if (target < array[mid]) right = mid - 1;
      else left = mid + 1;
    }
    return -1;
  }
  public static void main(String[] args){
    ClassicalBinarySearch solution = new ClassicalBinarySearch();

    int[] array = new int[] {1, 3, 5, 6, 7};
    int result = solution.binarySearch(array, 6);
    System.out.println(result);
  }
}
