/** author : manojbandari.
*program to check the valid data.
*/
import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
    /**
     * { flag variable }.
     */
    private int flag = 0;
    /**
     * Constructs the object.
     *
     * @param      input  The input
     */
    InputValidator(final String input) {
        /**
        * { temp variable }.
        */
        int temp = 5;
        if (input.length() > temp) {
            flag = 1;
        }

    }
    /**
     * { to validate data }.
     *
     * @return     { return_value is boolean }.
     */
    boolean validateData() {
        if (flag == 1) {
            return true;
        }
        return false;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { function_description }.
     *
     * @param args The arguments.
     */
    public static void main(final String args[]) {
        /**
         * It is the main class description.
         */
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());

    }
}