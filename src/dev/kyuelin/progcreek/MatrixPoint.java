package dev.kyuelin.progcreek;

/**
 * Created by linken on 5/4/16.
 */
public class MatrixPoint {
    int row;
    int col;

    public MatrixPoint(int r, int c) {
        this.row=r;
        this.col=c;
    }

    public boolean equals(Object p) {
        if(!(p instanceof MatrixPoint))
            return false;
        if (p == this)
            return true;
        return (row==((MatrixPoint)p).row && col==((MatrixPoint)p).col);
    }
}
