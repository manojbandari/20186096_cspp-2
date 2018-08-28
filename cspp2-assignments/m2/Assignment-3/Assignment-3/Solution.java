import java.util.Scanner;
/**
 * @author : manojbandari
 */
public final class Solution {
    /*
    *Private constructor
    */
    private Solution() {
    // we are not using this constructor.
    }
    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /**
     * { function_description }
     *
     * @param      base      The base
     * @param      exponent  The exponent
     *
     * @return     { description_of_the_return_value }
     */
    public static long power(final int base, final int exponent) {
        //return Math.pow(base,exponent);
        if (exponent != 0) {
            return base * (power(base, exponent - 1));
        } else {
            return 1;
        }
    }
}
