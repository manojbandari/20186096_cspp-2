import java.util.Scanner;
/**
 * @author:manojbandari
 */
public final class Solution
{   
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
    *Fill this main function to print maximum of given array.
    *
    *@param      args  The arguments.
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (max < a[i]) {
                max = a[i];
            }
        }
        System.out.println(max);

    }
}
