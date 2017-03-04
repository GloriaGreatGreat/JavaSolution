import java.util.Arrays;

public class QuickSort{
  public int[] quickSort(int[] array){
    if (array == null || array.length <= 1) return array;
    quickSort(array, 0, array.length - 1);
    return array;
  }

  public void quickSort(int[] array, int left, int right){
    if (left >= right) return;
    int pivot = partition(array, left, right);
    quickSort(array, left, pivot - 1);
    quickSort(array, pivot + 1, right);
  }

  private int partition(int[] array, int left, int right){
    int pivotindex = pivotIndex(left, right);
    int pivotValue = array[pivotindex];
    swap(array, right, pivotindex);
    int leftBound = left;
    int rightBound = right - 1; // here because pivot value is at index right
    while (leftBound <= rightBound) { // here the <= is needed !!!!!
      if (array[leftBound] <= pivotValue) leftBound++; // here <= could be < as well
      else if (array[rightBound] >= pivotValue) rightBound--; // here >= could be > as well
      else swap(array, leftBound++, rightBound--);
    }
    swap(array, leftBound, right);
    return leftBound;
  }

  private void swap(int[] array, int left, int right){
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }

  private int pivotIndex(int left, int right){
    return left + (int)(Math.random() * (right - left + 1));
  }

  public static void main(String[] args){
    QuickSort solution = new QuickSort();

    int[] array = null;
    array = solution.quickSort(array);
    System.out.println(Arrays.toString(array));

    array = new int[0];
    array = solution.quickSort(array);
    System.out.println(Arrays.toString(array));

    array = new int[] { 1, 2, 3, 4 };
    array = solution.quickSort(array);
    System.out.println(Arrays.toString(array));

    array = new int[] { 4, 3, 2, 1 };
    array = solution.quickSort(array);
    System.out.println(Arrays.toString(array));

    array = new int[] { 2, 5, 3, 1, 4 };
    array = solution.quickSort(array);
    System.out.println(Arrays.toString(array));
  }

}
