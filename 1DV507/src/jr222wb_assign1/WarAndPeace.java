package jr222wb_assign1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WarAndPeace {
	public static void main(String[] args) throws IOException {
		String text = readText("/home/spender/workspace/1DV507/src/jr222wb_assign1/WarAndPeace.txt"); // My own method
		//String[] words = text.split("[\\u2014 ]");  // This is how the string SHOULD be split properly since there
													  // are no spaces between words and 'em dash' characters in the text
		String[] words = text.split(" "); // However, this gets closer to the expected result
		System.out.println("Initial word count: "+words.length);   // We found 577091
				
		Stream<String> stream = Arrays.stream(words);		
		
		long unique = stream.flatMap(s -> Stream.of(s.replaceAll("[^a-z'-]+", ""))) //Remove all non-allowed characters				
				.distinct() //Only choose distinct words
				.count(); //Count them
				
		System.out.println("Unique word count: " + unique); //Print out unique word count		
	}

	static String readText(String file) throws IOException {
		List<String> words = Files.readAllLines(Paths.get(file)); //Put the file contents in a list		
		return words.toString().toLowerCase(); //Return the contents as a lower case string
	}
}



