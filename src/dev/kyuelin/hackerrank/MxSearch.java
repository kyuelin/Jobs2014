package dev.kyuelin.hackerrank;

/**
 * Created by kennethlin on 6/14/16.
 */
public class MxSearch {
    public static boolean search(int[][] matrix, int target) {
        if(matrix == null) return false;
        if(matrix.length == 0 || matrix[0].length == 0) return false;

        int r = matrix.length;
        int c = matrix[0].length;

        int start = 0;
        int end = r*c-1;

        while(start <= end) {
            int mid = (start+end)/2;
            int midx = mid/c;
            int midy = mid%c;

            if (target == matrix[midx][midy]) {
                return true;
            }
            else if (target < matrix[midx][midy]) {
                end = mid-1;
            }
            else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static boolean search2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int x = m-1;
        int y = 0;

        while(x>=0 && y<n) {
            if (target == matrix[x][y]) return true;
            else if (target < matrix[x][y]) x--;
            else y++;
        }
        return false;
    }
}
