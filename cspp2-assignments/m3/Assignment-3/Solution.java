import java.util.Scanner;
/**
@author: manojbandari
 Do not modify this main function.
*/

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    //we are not using this constructor.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments.
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        System.out.println(gcd(n1, n2));
    }
    /**
    *Need to write the gcd function and print the output.
    *
    *@param      n1    The n 1.
    *@param      n2    The n 2.
    *
    *@return     { description_of_the_return_value }.
    */
    public static int gcd(final int n1, final int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }
}

