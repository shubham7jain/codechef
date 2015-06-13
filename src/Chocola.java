import java.util.Scanner;
class Chocola {
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		System.out.println();
		while((t--) != 0) {
		int m = scan.nextInt();
		int n = scan.nextInt();
		int costX[] = new int[m]; 
		int costY[] = new int[n]; 
		for(int i = 0; i < m-1; i++) {
			costX[i] = scan.nextInt();
		}
		for(int i = 0; i < n-1; i++) {
			costY[i] = scan.nextInt();
		}
		
		int h=1, v=1;
		int result = 0;
		while(h!=m || v!=n) {
			int posX=-1;
			int posY=-1;
			int max = -1;
			for(int i=0;i<m;i++) {
				if(costX[i]>max) {
					max = costX[i];
					posX = i;
				}
			}
			for(int i=0;i<n;i++) {
				if(costY[i]>max) {
					max = costY[i];
					posY = i;
				}
			}
			
			if(posY != -1) {
				result = result + max*h;
				v++;
				costY[posY] = -1;
			} else {
				result = result + max*v;
				h++;
				costX[posX] = -1;
			}
		}
		System.out.println(result);
	}
	}

}
