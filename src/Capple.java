import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


class Capple {

	public static void main(String args[]) {
		Scanner scan  = new Scanner(System.in);
		int t = scan.nextInt();
		while((t--) != 0) {
			int n = scan.nextInt();
			int a[] = new int[n];
			Set<Integer> set = new HashSet<Integer>();
			for(int i=0;i<n;i++) {
				a[i] = scan.nextInt();
				set.add(a[i]);
			}
			
			System.out.println(set.size());
		}
	}
}
