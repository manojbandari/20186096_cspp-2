import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter name and roll number:");
		String name = s.nextLine();
		int roll= s.nextInt();
		System.out.println("Name :"+name +"   "+"Roll Number : "+roll);
	}
}