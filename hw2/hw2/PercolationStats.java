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
    private double u;
    private double sigma;
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
                int index = StdRandom.uniform(N * N);
                //do {
                row = index / N;
                col = index % N;
                //} while (!percolation.isOpen(row, col));
                percolation.open(row, col);
                count++;
            }
            double thereHold = (double) count / (double) (N * N);
            sumX[i] = thereHold;
        }
    }

    public double mean() {
        u = StdStats.mean(this.sumX);
        return u;
    }

    /**
     * sample mean of percolation threshold
     *
     * @return
     */
    public double stddev() {

        sigma = StdStats.stddev(sumX);
        return sigma;
    }

    /**
     * sample standard deviation of percolation threshold
     *
     * @return
     */
    public double confidenceLow() {
        return u - 1.96 * sigma / Math.sqrt(examT);
    }

    /**
     * low endpoint of 95% confidence interval
     *
     * @return
     */
    public double confidenceHigh() {
        return u + 1.96 * sigma / Math.sqrt(examT);
    }

}
