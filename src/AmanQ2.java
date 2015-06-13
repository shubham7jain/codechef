import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class AmanQ2 {

	public static void main(String args[]) throws IOException {
		File file = new File("Junior_Tech_Assignment.txt");

		String line = null;
		BufferedReader br = new BufferedReader(new FileReader(file));
		String[] arr = new String[100];
		int i = 0;
		boolean isQuestionBeginned = false;
		String heading = "";
		while ((line = br.readLine()) != null) {
			if (line.startsWith("Q")) {
				// System.out.println(line);
				arr[i] = line;
				i++;
				isQuestionBeginned = true;
			}
			else if (isQuestionBeginned) {
				arr[i - 1] = arr[i - 1].concat("\n").concat(line);
			}
			else {
				heading = heading.concat("\n").concat(line);
			}
		}
		int j;

		Arrays.sort(arr, 0, i - 1);
		File newFile = new File("Junior_Tech_AssignmentSorted.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));

		for (j = 0; j < i; j++) {
			bw.write(arr[j]);
			bw.newLine();
		}

		bw.flush();
		System.out.println(heading);
		BufferedReader brNew = new BufferedReader(new FileReader(newFile));
		while ((line = brNew.readLine()) != null) {
			System.out.println(line);
		}
	}
}
