/** author : manojbandari
*program to check the valid data
*/
import java.util.*;
class InputValidator {	
	/**
	 * { flag variable }
	 */
	static int flag = 0;
	
	/**
	 * Constructs the object.
	 *
	 * @param      input  The input
	 */
	InputValidator(String input) {
		if (input.length() > 5) {
			flag = 1;
		}

	}
	/**
	 * { to validate data }
	 *
	 * @return     { return_value is boolean }
	 */
	public static boolean validateData() {
		if (flag == 1) {
			return true;
		}
		return false;
	}
}
public class Solution {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		InputValidator i = new InputValidator(input);
		System.out.println(i.validateData());

	}

}
