import java.util.Scanner;

public class Solution {
  static int N = 3;

  // Function for finding maximum sum
  static int maxPathSum(int tri[][], int m)
  {
    // loop for bottom-up calculation
    for (int i = m - 1; i >= 0; i--)
    {
      for (int j = 0; j <= i; j++)
      {
        // for each element, check both
        // elements just below the number
        // and below right to the number
        // add the maximum of them to it
        if (tri[i + 1][j] > tri[i + 1][j + 1])
          tri[i][j] += tri[i + 1][j];
        else
          tri[i][j] += tri[i + 1][j + 1];
      }
    }

    // return the top element
    // which stores the maximum sum
    return tri[0][0];
  }

  /* Driver program to test above functions */
  public static void main (String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    int[] n = new int[t];
    int[] sum = new int[t];
    for (int i = 0; i < t; i++) {
      n[i] = sc.nextInt();
      int tri[][] = new int[n[i]][n[i]];
      for (int j = 0; j < n[i]; j++) {
        for (int k = 0; k <= j; k++) {
          tri[j][k] = sc.nextInt();
        }
      }
      sum[i] = maxPathSum(tri, n[i]-1);
    }

    for (int i = 0; i < t; i++) {
      System.out.println(sum[i]);
    }
  }
}
