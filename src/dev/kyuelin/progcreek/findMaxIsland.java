package dev.kyuelin.progcreek;

import dev.kyuelin.utilities.IntGenerator;

import java.util.LinkedList;

/**
 * Created by linken on 5/4/16.
 */
public class findMaxIsland {
    public static int find(int[][] input) {
        int maxsize = 0;
        LinkedList<MatrixPoint> visited = new LinkedList<>();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                int currsize = 0;
                MatrixPoint p = new MatrixPoint(i, j);
                if (visited.contains(p) || input[i][j] == 0) continue;
                LinkedList<MatrixPoint> island = new LinkedList<>();

                island.add(p);

                while (!island.isEmpty()) {
                    MatrixPoint temp = island.pop();
                    visited.add(temp);
                    currsize++;
                    int r = temp.row;
                    int c = temp.col;
                    if (c < input[i].length - 1) {
                        MatrixPoint p1 = new MatrixPoint(r, c + 1);
                        if (!visited.contains(p1) && input[r][c + 1] == 1) {
                            island.add(p1);
                        }
                    }
                    if (r < input.length - 1) {
                        MatrixPoint p2 = new MatrixPoint(r + 1, c);
                        if (!visited.contains(p2) && input[r + 1][c] == 1) {
                            island.add(p2);
                        }
                    }
                }

                maxsize = Math.max(maxsize, currsize);
            }
        }
        return maxsize;
    }

    public static void main(String[] args) {
        int[][] mat = IntGenerator.genIntMatrix(9, 9, 2);
        IntGenerator.printMatrix(mat);
        System.out.println("Size of Largest Island =" + find(mat));
    }
}
