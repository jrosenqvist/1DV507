
package jr222wb_assign3.count_words;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class WordCount2Main {
	public static void main(String[] args) throws IOException {		
		Scanner input = new Scanner(new File("src/jr222wb_assign3/count_words/words.txt"));

		HashWordSet hash = new HashWordSet();
		TreeWordSet tree = new TreeWordSet();

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
		System.out.println(tree.contains(new Word("are")));
		System.out.println(hash.contains(new Word("are")));


		Iterator<Object> iterTree = tree.iterator();
		while (iterTree.hasNext()) {
			System.out.print(iterTree.next() + " ");
		}
		System.out.println();

		System.out.println();
		Iterator<Object> iterHash = hash.iterator();		
		while (iterHash.hasNext()) {
			System.out.print(iterHash.next() + " ");
		}
		System.out.println();
		System.out.println(tree.size());
		
	}
}

