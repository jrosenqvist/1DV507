package jr222wb_assign3.count_words;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class WordCount1Main {
	public static void main(String[] args) throws IOException {		
		Scanner input = new Scanner(new File("src/jr222wb_assign3/count_words/words.txt"));
		
		HashSet<Word> hash = new HashSet<Word>();
		TreeSet<Word> tree = new TreeSet<Word>();
		
		while (input.hasNextLine()) {			
			for (String s : input.nextLine().split(" ")) {
				Word w = new Word(s);
				hash.add(w);
				tree.add(w);
			}				
		}
		input.close();
				
		System.out.println(hash.size());
		System.out.println(tree.size());
		
		for (Word w : tree) {
			System.out.print(w + " ");
		}
	}
}
