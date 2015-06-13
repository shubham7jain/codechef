import java.util.Scanner;


public class B {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		int first[] = new int[200005];
		int second[] = new int[200005];
		int f=0, s=0;
		String last ="";
		for(int i = 0; i< n; i++) {
			int tech = scan.nextInt();
			if(tech>0) {
				first[f++] = tech;
				last = "first";
			} else {
				second[s++] = -tech;
				last = "second";
			}
		}
		
		long sum_f= 0;
		for(int i=0; i<f ; i++) {
			sum_f += first[i];
		}
		long sum_s= 0;
		for(int i=0; i<s ; i++) {
			sum_s += second[i];
		}
		
		if(sum_f>sum_s) {
			System.out.println("first");
		} else if(sum_f<sum_s) {
			System.out.println("second");
		} else {
			String result = "";
			int i;
			for(i=0;i<Math.min(f, s); i++) {
				if(first[i] > second[i]) {
					result = "first";
					break;
				} else if(first[i] < second[i]) {
					result = "second";
					break;
				}
			}
			if(i == Math.min(f, s)) {
				if(f>s)
					result ="first";
				else if(f<s)
					result ="second";
			}
			
			if(result == "") {
				System.out.println(last);
			} else {
				System.out.println(result);
			}
		}
	}
}
