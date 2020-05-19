import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    long fib = 0;
    long fibI_1 = 2;
    long fibI_2 = 1;
    long fibSum = 2;
    Scanner sc = new Scanner(System.in);
    //System.out.println("Enter the number till which fib should be added");
    int t = sc.nextInt();
    long[] n = new long[t];
    long[] temp = new long[t];
    long[] sum = new long[t];
    for (int j = 0; j < t; j++) {
      n[j] = sc.nextLong();
      temp[j] = n[j];
    }
    Arrays.sort(temp);
    for (int i = 0; i < t; i++) {
      if (temp[i] == 1) {
        fibSum = 0;
      }
      else if (temp[i] == 2) {
        fibSum = 2;
      }
      else {
        while (fib < temp[i]) {
          fib = fibI_1 + fibI_2;
          fibI_2 = fibI_1;
          fibI_1 = fib;
          if (fib % 2 == 0 && fib <= temp[i]) {
            fibSum = fib + fibSum;
          }
        }
      }
      sum[i] = fibSum;
    }
    for (int i = 0; i < t; i++) {
      int index = Arrays.binarySearch(temp, n[i]);
      System.out.println(sum[index]);
    }
  }
}
