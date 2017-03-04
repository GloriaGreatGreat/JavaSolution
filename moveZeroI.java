import java.util.Arrays;

/*
  Move Os to the right end of the array, no need to keep the relative order of the elements
  in the original array.
*/

public class moveZeroI{
  public int[] moveZeroI(int[] array){
    if (array == null || array.length <= 1) return array;
    int left = 0;
    int right = array.length - 1;
    while (left <= right){
      if (array[left] != 0) left++;
      else if (array[right] == 0) right--;
      else swap(array, left++, right++);
    }
    return array;
  }

  private void swap(int[]array, int left, int right){
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
