/**
*@author: manojbandari
* Given an String, Write a java method
* that returns the decimal value for the given binary string.
*/
import java.util.Scanner;

/**
 * Class for solution.
 */
public final class Solution {
    /*
    Do not modify this main function.
    */
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { main function}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            String res = binaryToDecimal(s); //Write binaryToDecimal function
            System.out.println(res);
        }
    }
    /**
     * { binary to decimal }.
     *
     * @param      s     { parameter_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    static String binaryToDecimal(final String s) {
        int value = 0;
        String temp = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                value = value + (int) Math.pow(2, s.length() - i - 1);

            }
        }
        temp += value;
        return temp;
    }

}
