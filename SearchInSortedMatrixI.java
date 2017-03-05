/*
  Search in sorted matrix, each row of the matrix is sorted in ascending order,
  and the first element of the row is equals to or larger than the last element
  of the previous row
*/
import java.util.Arrays;

public class SearchInSortedMatrixI{
  /*
    Method 1: find row first then find col
    return {-1, -1} if not found
  */
  public int[] searchI(int[][] matrix, int target){
    int[] result = new int[] {-1, -1};
    if (matrix.length == 0 || matrix[0].length == 0) return result;
    int row = findRow(matrix, 0, matrix.length - 1, target);
    if (row == -1) return result;
    int col = findCol(matrix[row], 0, matrix[0].length - 1, target);
    if (col == -1) return result;
    result[0] = row;
    result[1] = col;
    return result;
  }
  private int findRow(int[][] matrix, int left, int right, int target){
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (matrix[mid][0] > target) right = mid - 1;
      else left = mid + 1;
    }
    return right; // why?
  }
  private int findCol(int[] array, int left, int right, int target){
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) return mid;
      else if (array[mid] < target) left = mid + 1;
      else right = mid - 1;
    }
    return -1;
  }

  /*
    Method 2: convert the 2D array to 1D array and do binary search
    return {-1, -1} if not found
  */
  public int[] searchII(int[][] matrix, int target){
    int m = matrix.length;
    int n = matrix[0].length;
    if(m == 0 || n == 0) return new int[] {-1, -1};
    int left = 0;
    int right = m * n - 1;
    while (left <= right){
      int mid = left + (right - left) / 2;
      int currentM = mid / m;
      int currentN = mid % m;
      if (matrix[currentM][currentN] == target) return new int[] {currentM, currentN};
      else if (matrix[currentM][currentN] < target) left = mid + 1;
      else right = mid - 1;
    }
    return new int[]{-1, -1};
  }

  public static void main(String[] args){
    SearchInSortedMatrixI solution = new SearchInSortedMatrixI();

    int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}};
    int[] result = solution.searchI(matrix, 2);
    System.out.println(Arrays.toString(result));

    result = solution.searchII(matrix, 2);
    System.out.println(Arrays.toString(result));
  }
}
