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
    private static int flag = 0;
    /**
     * { temp variable }.
     */
    private static int N_TEMP = 5;
    /**
     * Constructs the object.
     *
     * @param      input  The input
     */
    public InputValidator(final String input) {
        if (input.length() > N_TEMP) {
            flag = 1;
        }

    }
    /**
     * { to validate data }.
     *
     * @return     { return_value is boolean }.
     */
    public static boolean validateData() {
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
     * { item_description }.
     */
    public static void main(final String args[]) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());

    }
}