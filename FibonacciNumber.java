public class FibonacciNumber{

/*
  Method 1: Recursion
*/
  public long fibonacci(int K){
    if (K <= 0) return 0;
    if (K == 1) return 1;
    return fibonacci(K - 1) + fibonacci(K - 2);
  }

/*
  Method 2: Dynamic programming solution with O(n) solution
*/
  public long fibonacciI(int K){
    if (K <= 0) return 0;
    long[] array = new long[K + 1];
    // array[0] = 0; with or without gives the same result!!! array initialization !!! with all zeros!!!!!
    array[1] = 1;
    for(int i = 2; i <= K; i++){
      array[i] = array[i - 2] + array[i - 1];
    }
    return array[K];
  }

/*
  Method 3: Dynamic programming solution with O(1) solution
*/
  public long fibonacciII(int K){
    if (K <= 0) return 0;
    long a = 0;
    long b = 1;
    while (K >= 1) { // here K > 1 then return b; K >= 1 then return a
      long temp = a + b;
      a = b;
      b = temp;
      K--;
    }
    return a;
  }

/*
  Method 4: O(logn) solution using matrix multiplication
  M = {{1,1},{0,0}} = {{f(2),f(1)},{f(1),f(0)}}
  fibo(K) = (M ^ K)[0][0]
*/
  public static final long[][] SEED = {{1L, 1L},{1L, 0L}};
  public long fibonacciIII(int K){
    if (K <= 0) return 0;
    if (K == 1) return 1;
    long[][] matrix = {{1L, 1L},{1L, 0L}};
    pow(matrix, K - 1);
    return matrix[0][0];
  }

  private void pow(long[][] matrix, int pow){
    if (pow == 1) return;
    pow(matrix, pow/2);
    multiply(matrix, matrix);
    if (pow % 2 != 0) multiply(matrix, SEED);
  }

  private void multiply(long[][] matrix, long[][] matrix2){
    long topLeft = matrix[0][0]*matrix2[0][0] + matrix[0][1]*matrix2[1][0];
    long topRight = matrix[0][0]*matrix2[0][1] + matrix[0][1]*matrix2[1][1];
    long bottomLeft = matrix[1][0]*matrix2[0][0] + matrix[1][1]*matrix2[1][0];
    long bottomRight = matrix[1][0]*matrix2[0][1] + matrix[1][1]*matrix2[1][1];
    matrix[0][0] = topLeft;
    matrix[0][1] = topRight;
    matrix[1][0] = bottomLeft;
    matrix[1][1] = bottomRight;
  }

  public static void main(String[] args){
    FibonacciNumber solution = new FibonacciNumber();
    long number = solution.fibonacci(10);
    System.out.println(number);

    number = solution.fibonacciI(10);
    System.out.println(number);

    number = solution.fibonacciII(10);
    System.out.println(number);

    number = solution.fibonacciIII(10);
    System.out.println(number);
  }

}
