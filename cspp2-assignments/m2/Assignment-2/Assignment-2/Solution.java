import java.util.Scanner;
import java.lang.Math.*;
/**
 * Class for solution.
 * @author : manojbandari.
 */
public class Solution {
	private Solution() {
	// we are not using this constructor.	
	}
	/**
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
	/**
	Need to write the rootsOfQuadraticEquation function and print the output.
	*/
	public static void rootsOfQuadraticEquation(final int a, final int b, final int c){
		double one_root = (-b+Math.sqrt(b*b-4*a*c))/(2*a);
		double second_root = (-b-Math.sqrt(b*b-4*a*c))/(2*a);
		System.out.println(one_root+" "+second_root);

	}
}
