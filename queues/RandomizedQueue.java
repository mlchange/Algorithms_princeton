/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int nN = 0;

    // construct an empty randomized queue

    // is the randomized queue empty?
    public boolean isEmpty() {
        return nN == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return nN;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if (nN == a.length) resize(2 * a.length);
        a[nN++] = item;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < nN; i++) {
            copy[i] = a[i];
        }
        a = copy;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        int n = StdRandom.uniform(nN);
        Item remove = a[n];
        a[n] = a[nN - 1];
        nN--;
        if (nN > 0 && nN == a.length / 4) resize(a.length / 2);
        return remove;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        int n = StdRandom.uniform(nN);
        return a[n];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private int j = 0;
        private Item[] copy = (Item[]) new Object[nN];

        private ListIterator() {

            StdRandom.shuffle(a, 0, nN);
            for (int q = 0; q < nN; q++) {
                copy[q] = a[q];
            }
        }

        public boolean hasNext() {
            return j != nN;
        }

        public Item next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            return copy[j++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();
        for (int i = 0; i < n; i++)
            queue.enqueue(i);
        for (int a : queue) {
            for (int b : queue)
                StdOut.print(a + "-" + b + " ");
            StdOut.println();
        }
    }
}
