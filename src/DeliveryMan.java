import java.util.Arrays;
import java.util.Scanner;

class Pair implements Comparable<Pair>
{
	public int index;
	public int value;

	public Pair(int value, int index)
	{
		this.index = index;
		this.value = value;
	}

	@Override
	public int compareTo(Pair other)
	{
		// multiplied to -1 as the author need descending sort order
		return Integer.valueOf(this.value).compareTo(other.value);
	}
}

class DeliveryMan
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int x = scan.nextInt();
		int y = scan.nextInt();
		Pair a[] = new Pair[n];
		Pair b[] = new Pair[n];
		for (int i = 0; i < n; i++)
		{
			a[i] = new Pair(scan.nextInt(), i);
		}
		for (int i = 0; i < n; i++)
		{
			b[i] = new Pair(scan.nextInt(), i);
		}
		Arrays.sort(a);
		Arrays.sort(b);

		int i = n - 1;
		int j = n - 1;

		boolean postionsDone[] = new boolean[n];
		for (int k = 0; k < n; k++)
		{
			postionsDone[k] = false;
		}
		long sum = 0;
		while (n > 0 && (x > 0 || y > 0) && (i >= 0 || y >= 0))
		{
			// System.out.println(a[i].value + ", " + b[j].value + ", " + i + ", " + j + ", " + x + ", " + y);
			if (i >= 0 && x > 0 && ((a[i].value > b[j].value) || (y == 0)))
			{
				if (!postionsDone[a[i].index])
				{
					postionsDone[a[i].index] = true;
					sum = sum + a[i].value;
					i--;
					n--;
					x--;
				}
				else
				{
					i--;
				}
			}
			else if ((j >= 0 && y > 0) || (x == 0))
			{
				if (!postionsDone[b[j].index])
				{
					postionsDone[b[j].index] = true;
					sum = sum + b[j].value;
					j--;
					n--;
					y--;
				}
				else
				{
					j--;
				}
			}
		}
		System.out.println(sum);
	}
}
