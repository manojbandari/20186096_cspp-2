import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author : manojbandari
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }
    /**
     * { global variable }.
     */
    public static final int N_START = 3;
    /**
     * Prints the odd composite numbers between 2 and n.
     *
     * @param      n     n value
     */
    static void oddComposites(final int n) {
        int c = 0;
        int ch = 0;
        for (int i = N_START; i < n; i++) {
            if (i % 2 != 0) {
                ch = prime(i);
                if (ch > 1) {
                    System.out.println(i);
                }
            }
        }

    }

    /**
     * { prime}.
     *
     * @param      n     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    static int prime(final int n) {
        int i = 2;
        int c = 0;
        while (i <= n) {
            if (n % i == 0) {
                c = c + 1;
            }
            i = i + 1;
        }
        return c;
    }
    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        oddComposites(n);
    }
}






