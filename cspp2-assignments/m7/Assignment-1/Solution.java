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
    public static int TEMP = 5;
    /**
     * Constructs the object.
     *
     * @param      input  The input
     */
    InputValidator(final String input) {
        if (input.length() > TEMP) {
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
public class Solution {

    private Solution() {

    }

    public static void main(final String args[]) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());

    }
}