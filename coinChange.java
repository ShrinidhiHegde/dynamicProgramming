import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution {

  public static long getWays(int n, List<Long> c) {
    int m = c.size();
    ArrayList[][] memo = new ArrayList[m+1][n+1];
    Long[] arr = new Long[n];

    for (int i = 0; i < m+1; i++) {
      memo.get(i).set(0, (long) 1);
    }
    for (long i = 1; i < m+1; i++) {
      for (long j = 1; j < n+1; j++) {
        memo.get(i).set(j,memo.get(i-1).get((int) j)+memo.get(i).get((int) (j-c.get((int) i))));
      }
    }
    return memo[m][n];
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    List<Long> c = new ArrayList<>();
    for(int i = 0; i < m; i++) {
      c.add(sc.nextLong());
    }
    getWays(n,c);
  }
}
