import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CodeForcesB {

	public static int[] id = new int[500];

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
		}
		String mat[] = new String[n];
		for (int i = 0; i < n; i++) {
			mat[i] = scan.next();
		}

		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i].charAt(j) == '1')
					unite(i, j);
			}
		}
		boolean visited[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			visited[i] = false;
		}
		for (int i = 0; i < n; i++) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(i);
			if (visited[i] == true)
				continue;
			visited[i] = true;
			for (int j = i + 1; j < n; j++) {
				if (find(i, j)) {
					list.add(j);
					visited[j] = true;
				}
			}
			Collections.sort(list);
			List<Integer> numberList = new ArrayList<Integer>();
			for (Integer pos : list) {
				numberList.add(a[pos]);
			}
			Collections.sort(numberList);
			int k = 0;
			for (Integer pos : list) {
				a[pos] = numberList.get(k++);
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void unite(int p, int q) {
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}

	private static int root(int i) {
		while (i != id[i])
			i = id[i];
		return i;
	}

	public static boolean find(int p, int q) {
		return root(p) == root(q);
	}
}
