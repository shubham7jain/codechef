import java.util.Scanner;


class Cracker {

	public static void main(String args[]) {
		int t, n, m, a;
		Scanner scan = new Scanner(System.in);
		t = Integer.parseInt(scan.next());
		scan.nextLine();
		while((t--) != 0) {
			String line = scan.nextLine();
			n = Integer.parseInt(line.split(" ")[0]);
			a = Integer.parseInt(line.split(" ")[1]);
			m = Integer.parseInt(line.split(" ")[2]);
			System.out.println(((a+m)%n==0?n:(a+m)%n));
		}
	}
}
