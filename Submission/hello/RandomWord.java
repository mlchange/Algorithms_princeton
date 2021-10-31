import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */
public class RandomWord {
    public static void main(String[] args) {
        int n = 0;
        String a, b = "";
        while (!StdIn.isEmpty()) {
            n++;
            a = StdIn.readString();
            if (StdRandom.bernoulli((double) 1 / n)) b = a;
        }
        StdOut.println(b);
    }
}
