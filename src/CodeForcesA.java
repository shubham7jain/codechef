import java.util.Scanner;

public class CodeForcesA {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int t = scan.nextInt();
		int a[] = new int[n];
		for (int i = 1; i < n; i++) {
			a[i] = scan.nextInt();
		}

		int i = 1;
		while (i < n) {
			if (i == t) {
				System.out.println("YES");
				return;
			}
			else {
				i = i + a[i];
			}
		}
		if (i == t)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
