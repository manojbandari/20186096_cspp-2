import java.util.Scanner;
class bigger_equal_smaller{
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		System.out.println("enter two numbers");
		int varA = s.nextInt();
		int varB = s.nextInt();
		if(varA > varB){
			System.out.println("Bigger");
		}
		else if(varA == varB){
			System.out.println("Equal");
		}
		else{
			System.out.println("Smaller");
		}
	}	
}