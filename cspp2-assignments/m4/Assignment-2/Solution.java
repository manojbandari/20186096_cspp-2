import java.util.*;
public class Solution {
	/* Fill the main function to print resultant of addition of matrices*/
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int r1 = s.nextInt();
		int c1 = s.nextInt();
		int[][] a1 = new int[r1][c1];
		int[][] a2 = new int[r1][c1];
		for(int i = 0; i < r1; i++) {
			for(int j = 0; j < c1; j++) {
			a1[i][j] = s.nextInt();
			}
		}
		int r2 = s.nextInt();
		int c2 = s.nextInt();
		for(int i = 0; i < r2; i++) {
			for(int j = 0; j < c2; j++) {
				a2[i][j] = s.nextInt();
			}
		}
		if (r1 == r2 && c1 == c2){
			int[][] sum = new int[r1][c1];
			for(int i = 0; i < r1; i++) {
				for(int j = 0;j < c1; j++) {
					sum[i][j] = a1[i][j] + a2[i][j];
				}	
			}
			for(int i = 0; i < r1 ; i++) {
				for(int j = 0; j < c1; j++) {
					if(j < c1-1){
						System.out.print(sum[i][j]);					
					}
					else{
						System.out.println(sum[i][j]+" ");
					}
				}
				System.out.println("");
			}
		}

		else {
			System.out.println("not possible");
		}
	
	}
}