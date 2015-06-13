import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Sanskar {

	public static int count = 0;

	public static boolean solve(Long[] a, int k, int i,
			List<List<Long>> subsets, long sumR) {
		if (i == a.length && subsets.size() == k) {
			long sum = 0;
			for (List<Long> subset : subsets) {
				sum = 0;
				for (Long number : subset) {
					sum += number;
				}
				if (sum == sumR)
					continue;
				else
					break;
			}
			if (sum == sumR)
				return true;
			else
				return false;
		} else {
			// loop over all subsets and try to put a[i] in
			for (int j = 0; j < k; j++) {
				// subset j not full
				long sum = 0;
				if (subsets.get(j) != null)
					for (Long num : subsets.get(j)) {
						sum += num;
					}
				if (sum + a[i] <= sumR) {
					List<Long> sub = subsets.get(j);
					if (sub == null) {
						sub = new ArrayList<Long>();
						subsets.set(j, sub);
					}
					subsets.get(j).add(a[i]);
					if (solve(a, k, i + 1, subsets, sumR)) // do recursion
						return true;
					subsets.get(j).remove((Long) a[i]);

					if (subsets.get(j).size() == 0) {
						// don't skip empty subsets, so you won't get duplicates
						break;
					}
				}
			}
			return false;
		}
	}

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while ((t--) != 0) {
			int n = scan.nextInt();
			int k = scan.nextInt();
			Long arr[] = new Long[n];
			long sum = 0;
			for (int i = 0; i < n; i++) {
				arr[i] = scan.nextLong();
				sum += arr[i];
			}
			Arrays.sort(arr, Collections.reverseOrder());
			if (sum % k != 0 || k>n) {
				System.out.println("no");
				continue;
			}
			List<List<Long>> subsets = new ArrayList<List<Long>>(k);
			for (int i = 0; i < k; i++)
				subsets.add(i, new ArrayList<Long>());
			if (solve(arr, k, 0, subsets, sum / k)) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}
