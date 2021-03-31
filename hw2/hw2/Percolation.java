package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int n;
    private WeightedQuickUnionUF djSet;
    private int source;
    private int to;
    private int[][] opened;
    private int openNum;

    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        n = N;
        openNum = 0;
        opened = new int[N][N];
        djSet = new WeightedQuickUnionUF(N * N + 2);
        source = n * n;
        to = n * n + 1;
    }

    private boolean isOutOfBound(int nn) {
        if (nn < 0 || nn >= n) {
            return true;
        }
        return false;
    }

    private int xyTo1d(int row, int col) {
        return row * n + col;
    }

    /**
     * open the site (row, col) if it is not open already
     *
     * @param row
     * @param col
     */
    public void open(int row, int col) {
        if (isOutOfBound(row) || isOutOfBound(col)) {
            throw new IndexOutOfBoundsException();
        }
        int indexTarget = xyTo1d(row, col);
        if (opened[row][col] == 0) {
            opened[row][col] = 1;
            openNum++;
            if (row == 0) {
                djSet.union(indexTarget, source);
            }
            if (row == n - 1) {
                djSet.union(indexTarget, to);
            }
            if (row > 0 && opened[row - 1][col] != 0) {
                djSet.union(xyTo1d(row - 1, col), indexTarget);
            }
            if (row < n - 1 && opened[row + 1][col] != 0) {
                djSet.union(xyTo1d(row + 1, col), indexTarget);
            }
            if (col > 0 && opened[row][col - 1] != 0) {
                djSet.union(xyTo1d(row, col - 1), indexTarget);
            }
            if (col < n - 1 && opened[row][col + 1] != 0) {
                djSet.union(xyTo1d(row, col + 1), indexTarget);
            }
        }


    }

    /**
     * is the site (row, col) open?
     *
     * @param row
     * @param col
     * @return
     */
    public boolean isOpen(int row, int col) {
        if (isOutOfBound(row) || isOutOfBound(col)) {
            throw new IndexOutOfBoundsException();
        }
        return opened[row][col] != 0;
    }

    /**
     * is the site (row, col) full?
     *
     * @param row
     * @param col
     * @return
     */
    public boolean isFull(int row, int col) {
        if (isOutOfBound(row) || isOutOfBound(col)) {
            throw new IndexOutOfBoundsException();
        }
        if (row != n - 1) {
            return djSet.connected(xyTo1d(row, col), source);
        } else {
            if (!djSet.connected(xyTo1d(row, col), source)) {
                return false;
            }
            return djSet.connected(xyTo1d(row, col), source);
        }
    }

    /**
     * number of open sites
     *
     * @return
     */
    public int numberOfOpenSites() {
        return openNum;
    }

    /**
     * does the system percolate?
     *
     * @return
     */
    public boolean percolates() {
        return djSet.connected(source, to);
    }

    /**
     * use for unit testing
     *
     * @param args
     */
    public static void main(String[] args) {
        Percolation percolation = new Percolation(5);
        System.out.println(percolation.percolates());
        percolation.open(3, 4);
        System.out.println(percolation.numberOfOpenSites());
        percolation.open(2, 4);
        percolation.open(2, 2);
        System.out.println(percolation.numberOfOpenSites());
        percolation.open(2, 3);
        System.out.println(percolation.numberOfOpenSites());
        percolation.open(0, 2);
        System.out.println(percolation.numberOfOpenSites());
        percolation.open(1, 2);
        System.out.println(percolation.isFull(2, 2));
        System.out.println(percolation.isOpen(0, 2));
        System.out.println(percolation.percolates());
        percolation.open(2, 4);
        System.out.println(percolation.percolates());
        percolation.open(4, 4);
        System.out.println(percolation.percolates());
        System.out.println(percolation.numberOfOpenSites());

        Percolation percolation1 = new Percolation(1);
        System.out.println(percolation1.percolates());
        percolation1.open(0, 0);
        System.out.println(percolation1.numberOfOpenSites());
        System.out.println(percolation1.percolates());
    }
}
