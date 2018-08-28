// import java.lang.Math;
import java.util.Scanner;

/**
 * Class for solution.
 */
public class Solution
{
    /*
    Do not modify this main function.
    @param      args  The arguments
    */
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /*
    Need to write the power function and print the output.

    @param      base      The base
    @param      exponent  The exponent

    @return     {description_of_the_return_value}
    */
    public static long power(final int base, final int exponent)
    {
        //return Math.pow(base,exponent);
        if(exponent != 0)
        {
            return base * (power(base, exponent - 1));
        }
        else
        {
            return 1;
        }
    }
}