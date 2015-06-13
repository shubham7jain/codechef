import java.util.Scanner;


public class A {

	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		String home = scan.next();
		String away = scan.next();
		int t = scan.nextInt();
		scan.nextLine();
		int a[] = new int[1000];
		int h[] = new int[1000];
		for(int i =0; i<1000;i++) {
			a[i] = 0;
			h[i] = 0;
		}
		while((t--) != 0) {
			String input = scan.nextLine();
			int minute = Integer.parseInt(input.split(" ")[0]);
			String team = input.split(" ")[1];
			int player = Integer.parseInt(input.split(" ")[2]);
			String foul = input.split(" ")[3];
			
			if(team.equals("a")) {
				if(a[player] == 1) {
					a[player] = 2;
					System.out.println(away + " " + player + " " + minute);
				} else if(foul.equals("r") && a[player] != 2) {
					a[player] = 2;
					System.out.println(away + " " + player + " " + minute);
				} else if(a[player] == 0){
					a[player] = 1;
				}
			} else if(team.equals("h")) {
				if(h[player] == 1) {
					h[player] = 2;
					System.out.println(home + " " + player + " " + minute);
				} else if(foul.equals("r")  && h[player] != 2) {
					h[player] = 2;
					System.out.println(home + " " + player + " " + minute);
				} else if(h[player] == 0){
					h[player] = 1;
				}
			}
			
		}
	}
}
