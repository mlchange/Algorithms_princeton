/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Measurecpu {
    public static void main(String[] args) {
        Stopwatch measure = new Stopwatch();
        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[1]);
        PercolationStats test = new PercolationStats(n1, n2);
        System.out.printf("mean                    = %f\n", test.mean());
        System.out.printf("stddev                  = %f\n", test.stddev());
        System.out
                .printf("95%% confidence interval = [%f, %f]\n", test.confidenceLo(),
                        test.confidenceHi());
        StdOut.println(measure.elapsedTime());
    }
}
