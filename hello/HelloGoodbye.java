/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class HelloGoodbye {
    public static void main(String[] args) {
        System.out.printf("Hello %s and %s.", args[0], args[1]);
        System.out.println();
        System.out.printf("Goodbye %s and %s.", args[1], args[0]);
        System.out.println();
    }
}