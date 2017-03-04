import java.util.Arrays;

public class MergeSort{
  public int[] mergeSort(int[] array){
    if (array == null || array.length <= 1) {
      return array;
    }
    int[] helper = new int[array.length];
    mergeSort(array, helper, 0, array.length - 1);
    return array;
  }

  private void mergeSort(int[] array, int[] helper, int left, int right){
    if (left >= right) return; // here this >= is really important !!! Or stackoverflow
    int mid = left + (right - left)/2;
    mergeSort(array, helper, left, mid);
    mergeSort(array, helper, mid + 1, right);
    merge(array, helper, left, mid, right);
  }

  private void merge(int[] array, int[] helper, int left, int mid, int right){
    for (int i = left; i <= right; i++) { // here i <= right
      helper[i] = array[i];
    }
    int leftIndex = left;
    int rightIndex = mid + 1;
    while (leftIndex <= mid && rightIndex <= right){ // here use <= 
      if (helper[leftIndex] < helper[rightIndex]){
        array[left++] = helper[leftIndex++];
      }
      else{
        array[left++] = helper[rightIndex++];
      }
    }
    while (leftIndex <= mid) {
      array[left++] = helper[leftIndex++];
    } // only need to consider the left part, the right part is already in correct place
  }

  public static void main(String[] args){
    MergeSort solution = new MergeSort();

    int[] array = null;
    array = solution.mergeSort(array);
    System.out.println(Arrays.toString(array));

    array = new int[0];
    array = solution.mergeSort(array);
    System.out.println(Arrays.toString(array));

    array = new int[] { 1, 2, 3, 4 };
    array = solution.mergeSort(array);
    System.out.println(Arrays.toString(array));

    array = new int[] { 4, 3, 2, 1 };
    array = solution.mergeSort(array);
    System.out.println(Arrays.toString(array));

    array = new int[] { 2, 4, 1, 5, 3 };
    array = solution.mergeSort(array);
    System.out.println(Arrays.toString(array));
  }

}
