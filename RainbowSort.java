import java.util.Arrays;

/*
  We have three colors denoted as -1, 0, 1 and all the elements in the array are valid.
*/

public class RainbowSort{
  public int[] RainbowSort(int[] array){
    if (array == null || array.length <= 1) return array;
    int left = 0;
    int middle = 0;
    int right = array.length - 1;
    while (middle <= right) {
      if (array[middle] == -1) swap(array, left++, middle++);
      else if (array[middle] == 0) middle++;
      else swap(array, middle, right--); // here is very important !!!! middle cannot increment
      // stay the same position for check with the left, so NO middle++
    }
    return array;
  }

  private void swap(int[] array, int a, int b){
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }

}
