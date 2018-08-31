import java.util.*;
public class FirstLast6 {
	public static int N_temp = 6;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int a[]= new int[n];
		for (int i=0;i<n;i++) {
			a[i]=s.nextInt();
		}
		if (a[0]==N_temp)
			System.out.println(true);
		else if (a[a.length-1]==N_temp)
			System.out.println(true);
		else
			System.out.println(false);
	}
}