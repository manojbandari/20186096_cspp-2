/**
@author : manojbandari
Reverse a given string
*/

import java.util.Scanner;

/**
 * Class for solution.
 */
public class Solution {
    /*
    Do not modify the main function
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
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);

    }
    //Write reverseString function
    public static String reverseString(final String s) {
        String temp = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            temp = temp + s.charAt(i);
        }
        return temp;
    }
}
