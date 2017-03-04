import java.util.Arrays;

public class SelectionSort {
  public int[] selectionSort(int[] array){
    if (array == null || array.length <= 1) { // here <= 1 is important
      return array;
    }
    for (int i = 0; i < array.length - 1; i++) { // here array.length -1 is important
      int min = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[min]){  // here compare to min but not i is important
          min = j;
        }
      }
      swap(array, min, i);
    }
    return array;
  }

  public void swap(int[] array, int x, int y){
    int temp = array[x];
    array[x] = array[y];
    array[y] = temp;
  }

  public static void main(String[] args){
    SelectionSort solution = new SelectionSort();

    int[] array = null;
    array = solution.selectionSort(array);
    System.out.println(Arrays.toString(array));

    array = new int[0];
    array = solution.selectionSort(array);
    System.out.println(Arrays.toString(array));

    array = new int[] { 1, 2, 3, 4};
    array = solution.selectionSort(array);
    System.out.println(Arrays.toString(array));

    array = new int[] { 4, 3, 2, 1};
    array = solution.selectionSort(array);
    System.out.println(Arrays.toString(array));

    array = new int[] { 2, 4, 1, 5, 3};
    array = solution.selectionSort(array);
    System.out.println(Arrays.toString(array));

  }
}
