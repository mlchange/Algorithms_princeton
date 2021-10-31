/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] grid;
    private WeightedQuickUnionUF data;
    private WeightedQuickUnionUF refdata;
    private final int top;
    private final int bottom;
    private int n;
    private int open;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        data = new WeightedQuickUnionUF(n * n + 2);
        refdata = new WeightedQuickUnionUF(n * n + 1);
        grid = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = false;
            }
        }
        top = n * n;
        open = 0;
        bottom = n * n + 1;
        this.n = n;
    }

    private int transrowcol(int row, int col) {
        return (row - 1) * n + col - 1;
    }

    private boolean isValid(int i, int j) {
        return i > 0
                && j > 0
                && i <= n
                && j <= n;
    }

    private void throwerror(int i, int j) {
        if (!isValid(i, j)) {
            throw new IllegalArgumentException();
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        throwerror(row, col);

        int a;
        a = transrowcol(row, col);

        if (grid[row - 1][col - 1]) {
            return;
        }

        grid[row - 1][col - 1] = true;
        open = open + 1;

        if (row == 1) {
            data.union(top, a);
            refdata.union(top, a);
        }
        if (row == n) {
            data.union(bottom, a);
        }
        if (isValid(row + 1, col) && isOpen(row + 1, col)) {
            data.union(transrowcol(row + 1, col), a);
            refdata.union(transrowcol(row + 1, col), a);
        }
        if (isValid(row - 1, col) && isOpen(row - 1, col)) {
            data.union(transrowcol(row - 1, col), a);
            refdata.union(transrowcol(row - 1, col), a);
        }
        if (isValid(row, col + 1) && isOpen(row, col + 1)) {
            data.union(transrowcol(row, col + 1), a);
            refdata.union(transrowcol(row, col + 1), a);
        }
        if (isValid(row, col - 1) && isOpen(row, col - 1)) {
            data.union(transrowcol(row, col - 1), a);
            refdata.union(transrowcol(row, col - 1), a);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        throwerror(row, col);
        return grid[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        throwerror(row, col);
        return refdata.find(transrowcol(row, col)) == refdata.find(top);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return open;
    }

    // does the system percolate?
    public boolean percolates() {
        return data.find(bottom) == data.find(top);
    }

    public static void main(String[] args) {

    }
}
