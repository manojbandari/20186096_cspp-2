import java.util.Scanner;
/**.
 * Class for solution.
 * @author     : manojbandari.
 */
public final class Solution {
    static final int temp = 4;
    /**.
     * Constructs the object.
     */
    private Solution() {
    // we are not using this constructor.
    }
    /**.
    *Do not modify this main function.
    *@param      args  The arguments.
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        rootsOfQuadraticEquation(a, b, c);
    }
    /**.
    *Need to write the rootsOfQuadraticEquation function.
    *and print the output.
    *@param      a     { parameter_description }.
    *@param      b     { parameter_description }.
    *@param      c     { parameter_description }.
    */
    public static void
    rootsOfQuadraticEquation(final int a, final int b, final int c) {
        double firstroot = (-b + Math.sqrt(b * b - temp * a * c)) / (2 * a);
        double secondroot = (-b - Math.sqrt(b * b - temp * a * c)) / (2 * a);
        System.out.println(firstroot + " " + secondroot);
    }
}
