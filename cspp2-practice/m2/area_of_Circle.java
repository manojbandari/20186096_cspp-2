import java.util.Scanner;
class area_of_Circle{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("enter radius: ");
		float r = s.nextInt();
		System.out.println(3.14*r*r);
	}
}