import java.util.Scanner;


class PhilospherStone {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int i, j;
		while((t--) != 0) {
			int h = scan.nextInt();
			int w = scan.nextInt();
			
			int[][] a = new int[h+2][w+2];
			for(i=1;i<=h;i++) {
				for(j=1;j<=w;j++) {
					a[i][j] = scan.nextInt();
				}
			}
			for(i=0;i<=h+1;i++) {
				a[i][0] = 0;
				a[i][w+1] = 0;
			}
			for(i=0;i<=w+1;i++) {
				a[0][i] = 0;
				a[h+1][i] = 0;
			}
			
			for(i=1;i<=h;i++) {
				for(j=1;j<=w;j++) {
					a[i][j] = Math.max(Math.max(a[i-1][j-1], a[i-1][j]), a[i-1][j+1]) + a[i][j];
				}
			}
			int max=0;
			for(i=1;i<=w;i++) {
				if(a[h][i]>max)
					max = a[h][i];
			}
			System.out.println(max);
		}		
	}
}
