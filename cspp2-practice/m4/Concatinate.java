import java.util.Scanner;
public class Concatinate {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String s1 = "Hello ";
		String s2 = s.next();
		System.out.println(s1.concat(s2)+"!");
	}
}
