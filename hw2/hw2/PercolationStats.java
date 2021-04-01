package hw2;

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    /**
     * perform T independent experiments on an N-by-N grid
     *
     * @param N
     * @param T
     * @param pf
     */
    private int examT;
    private double[] sumX;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }
        this.examT = T;
        this.sumX = new double[T];
        for (int i = 0; i < T; i++) {
            Percolation percolation = pf.make(N);
            int count = 0;
            while (!percolation.percolates()) {
                int row, col;

                //do {
                row = StdRandom.uniform(N);
                col = StdRandom.uniform(N);
                //} while (!percolation.isOpen(row, col));
                if (!percolation.isOpen(row, col)) {
                    percolation.open(row, col);
                }
                count++;
            }
            double thereHold = (double) percolation.numberOfOpenSites() / (double) (N * N);
            sumX[i] = thereHold;
        }
    }

    public double mean() {
        return StdStats.mean(sumX);
    }

    /**
     * sample mean of percolation threshold
     *
     * @return
     */
    public double stddev() {
        return StdStats.stddev(sumX);

    }

    /**
     * sample standard deviation of percolation threshold
     *
     * @return
     */
    public double confidenceLow() {
        return mean() - 1.96 * stddev() / Math.sqrt(examT);
    }

    /**
     * low endpoint of 95% confidence interval
     *
     * @return
     */
    public double confidenceHigh() {
        return mean() + 1.96 * stddev() / Math.sqrt(examT);
    }

}
