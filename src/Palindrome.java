import java.util.Scanner;


class Palindrome {
	
	public static String getReverse(String str) {
		String reverse = new String();
		int i= str.length() -1;
		int k=0;
		while(i>=0) {
			reverse = reverse + str.charAt(i);
			i--;
		}
		return reverse;
	}
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while((t--) != 0) {
			String str = scan.next();
			int[][] a = new int[str.length()+1][str.length()+1];
			
			String reverse = getReverse(str);
			for(int i=0;i<str.length();i++) {
				a[i][0] = 0;
				a[0][i] = 0;
			}
			for(int i=1;i<=str.length();i++) {
				for(int j=1;j<=reverse.length();j++) {
					if(str.charAt(i-1)==reverse.charAt(j-1))
						a[i][j] = a[i-1][j-1] + 1;
					else
						a[i][j] = Math.max(a[i-1][j], a[i][j-1]);
				}
			}
			System.out.println(str.length() - a[str.length()][str.length()]);
		}
	}
}
