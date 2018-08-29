import java.util.Scanner;

public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double degreesCelsius = scan.nextDouble();
		System.out.println(calculateFromDegreesToFarenheit(degreesCelsius));
	}
	/*
	Need to fill the calculateFromDegreesToFarenheit function and print the output
	of fahrenheit.
	*/
	public static double calculateFromDegreesToFarenheit(double degreesCelsius){
		return  degreesCelsius*1.8 + 32;
	}
}
