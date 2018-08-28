import java.util.Scanner;
class area_of_Circle{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("enter radius: ");
		int r = s.nextInt();
		System.out.println(area(r));
	}
	public static double area(int r){
		return pi()*r*r;
	}
	public static double pi(){
		return 3.14;
	}

}