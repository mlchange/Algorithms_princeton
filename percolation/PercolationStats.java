/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] x;
    private int t;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        t = trials;
        x = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation traildata = new Percolation(n);
            int count = 0;
            while (!traildata.percolates()) {
                int a = StdRandom.uniform(1, n + 1);
                int b = StdRandom.uniform(1, n + 1);
                if (traildata.isOpen(a, b)) {
                    continue;
                }
                traildata.open(a, b);
                count++;
            }
            x[i] = (double) count / (double) (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(x);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(x);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - 1.96 * stddev() / Math.sqrt(t);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + 1.96 * stddev() / Math.sqrt(t);
    }

    public static void main(String[] args) {
        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[1]);
        PercolationStats test = new PercolationStats(n1, n2);
        System.out.printf("mean                    = %f\n", test.mean());
        System.out.printf("stddev                  = %f\n", test.stddev());
        System.out
                .printf("95%% confidence interval = [%f, %f]\n", test.confidenceLo(),
                        test.confidenceHi());
    }
}
