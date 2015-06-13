import java.util.Scanner;
import java.util.Arrays;


public class C {
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] dist1 = new int[n];
		for(int i =0;i<n;i++) {
			dist1[i] = scan.nextInt();
		}
		int m = scan.nextInt();
		int[] dist2 = new int[m];
		for(int i =0;i<m;i++) {
			dist2[i] = scan.nextInt();
		}
		
		Arrays.sort(dist1);
		Arrays.sort(dist2);
		
	}

}
