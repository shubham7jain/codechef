import java.math.BigInteger;
import java.util.Scanner;


public class Bholu {
	
	public static BigInteger min(BigInteger a, BigInteger b, BigInteger c) {
		if(a.compareTo(b) < 0 && a.compareTo(c) < 0)
			return a;
		else if(b.compareTo(a) < 0 && b.compareTo(c) < 0)
			return b;
		else 
			return c;
	}
	
	public static BigInteger gcd(BigInteger n,BigInteger m)
	{ if(m.compareTo(n) <= 0 && (n.mod(m)).equals(new BigInteger("0")))
	   return m;
	  if(n.compareTo(m) < 0)
	   return gcd(m,n);
	  else
	   return gcd(m,n.mod(m));
	 }
	
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		int t = Integer.parseInt(scan.next());
		while((t--) != 0) {
			BigInteger a = scan.nextBigInteger();
			BigInteger b = scan.nextBigInteger();
			BigInteger c = scan.nextBigInteger();
			BigInteger side = gcd(a,b);
			side = gcd(c, side);
			BigInteger cuboidArea = a.multiply(b).multiply(c);
			BigInteger cubeArea = side.multiply(side).multiply(side);
			BigInteger modulas = new BigInteger("1000000007");
			System.out.println(side + " " + (cuboidArea.divide(cubeArea)).mod(modulas));
		}
	}
}
