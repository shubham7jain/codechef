import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
class Stones {
	public static void main(String[] args) throws java.lang.Exception {
		Scanner scan = new Scanner(System.in);
		long t = scan.nextLong();
		while ((t--) != 0) {
			int n = scan.nextInt();
			long k = scan.nextLong();
			long time[] = new long[n];
			long profit[] = new long[n];
			for (int i = 0; i < n; i++) {
				time[i] = scan.nextLong();
			}
			for (int i = 0; i < n; i++) {
				profit[i] = scan.nextLong();
			}
			long max = -1;
			for (int i = 0; i < n; i++) {
				if ((k / time[i]) * profit[i] > max)
					max = (k / time[i]) * profit[i];
			}

			System.out.println(max);
		}
	}
}
