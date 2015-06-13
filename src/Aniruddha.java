import java.util.Scanner;


class Aniruddha {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int result[] = new int[1000004];
		int h = 1;
		int t = 1;
		int h_new, t_new;
		result[1]=2;
		for (int i=2; i< 1000004;i++) {
			h_new = h+t;
			t_new = t;
			result[i] = (result[i-1] + 2*h + t)%1000000007;
			h = h_new;
			t = t_new;
		}
		int test = scan.nextInt();
		while((test--)!=0) {
			int n = Integer.parseInt(scan.next());
			
			System.out.println(result[n]);
		}
	}
}
