package hw2;

import edu.princeton.cs.introcs.StdRandom;

public class PercolationStats {
    /**
     * perform T independent experiments on an N-by-N grid
     *
     * @param N
     * @param T
     * @param pf
     */
    private double sumX = 0;
    private double sumX2 = 0;
    private int examT;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }
        examT = T;
        for (int i = 0; i < T; i++) {
            Percolation percolation = pf.make(N);
            int count = 0;
            while (!percolation.percolates()) {
                int row, col;
                do {
                    row = StdRandom.uniform(N);
                    col = StdRandom.uniform(N);
                } while (!percolation.isOpen(row, col));
                percolation.open(row, col);
                count++;
            }
            sumX += count;
            sumX2 += count * count;
        }
    }

    public double mean() {
        return sumX / examT;
    }

    /**
     * sample mean of percolation threshold
     *
     * @return
     */
    public double stddev() {
        double total = sumX2 - 2 * mean() * sumX + examT * mean() * mean();
        return Math.sqrt(total / (examT - 1));
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
