/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> queue = new RandomizedQueue<String>();

        while (!StdIn.isEmpty()) {
            String a = StdIn.readString();
            if (a != null && a.length() > 0) {
                queue.enqueue(a);
            }
        }
        int i = 0;
        for (String s : queue) {
            i++;
            if (k == 0) break;
            StdOut.print(s);
            StdOut.println();
            if (i == k) break;
        }
    }
}

