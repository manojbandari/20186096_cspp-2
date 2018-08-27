import java.util.*;
class swap{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("a=");
		int a= s.nextInt();
		System.out.print("b=");
		int b= s.nextInt();
		b= a+b;
		a= b-a;
		b= b-a;
		System.out.println("after swapping");
		System.out.println("a  =  "+a);
		System.out.println("b  =  "+b);
	}
}