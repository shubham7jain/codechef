import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Xor {

	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while ((t--) != 0) {
			int n = scan.nextInt();
			int k = scan.nextInt();

			Integer arr[] = new Integer[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scan.nextInt();
			}

			Arrays.sort(arr, Collections.reverseOrder());

			int temp = arr[0];
			int bitpos = 0;
			while (temp != 0) {
				bitpos++;
				temp = temp >> 1;
			}

			for (int j = 1; j < n; j++) {
				if ((arr[j] >> (bitpos - 1)) == 0) {
					temp = arr[j];
					bitpos = 0;
					while (temp != 0) {
						bitpos++;
						temp = temp >> 1;
					}
					continue;
				}
				for (int i = j; i < n; i++) {
					if ((arr[i] >> (bitpos - 1)) != 0) {
						arr[i] = arr[i] ^ arr[j - 1];
					} else
						break;
				}

				Arrays.sort(arr, Collections.reverseOrder());
				temp = arr[j];
				bitpos = 0;
				while (temp != 0) {
					bitpos++;
					temp = temp >> 1;
				}
			}

			int result = k;
			for (int i = 0; i < n; i++) {
				if ((result ^ arr[i]) > result)
					result = result ^ arr[i];
			}
			System.out.println(result);
		}
	}
}
