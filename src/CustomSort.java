import java.util.Arrays;
import java.util.Comparator;

public class CustomSort implements Comparator<String> {

	public static void main(String args[]) {
		String arr[] = {"60", "54", "546", "548"};

		Arrays.sort(arr, new CustomSort());
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}

	@Override
	public int compare(String X, String Y) {
		// first append Y at the end of X
		String XY = X + Y;

		// then append X at the end of Y
		String YX = Y + X;

		// Now see which of the two formed numbers is greater
		return XY.compareTo(YX) > 0 ? 1 : -1;
	}
}
