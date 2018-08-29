/**
 *@author : maanojbandari.
 * { item_description }.
 */
import java.util.Scanner;
/*
 Do not modify this main function.
*/
public final class Solution {
    private Solution(){
    //we are not using this constructor.
    }

/**
 * Fill the main function to.
 * print the number of 7's between 1 to n.
 * @param      args  The arguments.
 */
    public static void main(final String[] args) {

        Scanner s=new Scanner(System.in);      
        int n = s.nextInt();
        int count = 0;
        for (int i = 1 ; i < n ; i++) {
            count += numbers(i);
        }
        System.out.println(count);
    }
    
    /**
     * { function_description }
     *
     * @param      n     { parameter_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public static final int numbers(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 10 == 7) {
                count++ ;
            }
            n = n / 10;
        }
        return count;
    }
}