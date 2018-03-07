package jr222wb_assign3.count_words;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IdentifyWordsMain {
	public static void main(String[] args) throws IOException {
		File f = new File("src/jr222wb_assign3/count_words/HistoryOfProgramming.txt");
		Scanner input = new Scanner(f);
		PrintWriter output = new PrintWriter("src/jr222wb_assign3/count_words/words.txt");
		while (input.hasNextLine()) {
			String parsed = input.nextLine().replaceAll("[^a-zA-Z ]+", "");
			if (parsed.length() > 0)
				output.println(parsed);			
		}		
		output.close();
		input.close();
	}
}
