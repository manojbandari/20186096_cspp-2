import java.util.Scanner;
public class Average {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int a[]= new int[n];
		float sum = 0;
		for (int i=0;i<n;i++) {
			a[i]=s.nextInt();
			sum = sum + a[i];
		}
		System.out.println(sum/n);
	}
}
