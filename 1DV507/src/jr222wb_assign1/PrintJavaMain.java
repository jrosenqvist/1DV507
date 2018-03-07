package jr222wb_assign1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrintJavaMain {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("/home/spender/workspace/1DV507/src");
		listDir(file);
	}
	private static int depth = 0; //Variable for keeping depth when printing out

	private static void listDir(File file) throws FileNotFoundException {		
		if (file.isDirectory()) { //If currently looking at a directory
			printDir(file); //Call printDir method on current location
			depth++; //Increase depth variable
			File[] dirList = file.listFiles(); //Store contents of current directory in array					
			for (File sub : dirList) //Run this same method for every file in array
				listDir(sub);
			depth--; //Decrease depth when "leaving" a sub-directory
		}
		else
			printDir(file); //If not a directory, just print out the file
	}
	private static void printDir(File file) throws FileNotFoundException {
		StringBuilder str = new StringBuilder();			
		for (int i = 0; i < depth; i++) //Add indentation based on value of depth variable
			str.append("   ");
		if (file.isDirectory()) //Add brackets around directories
			str.append("[" + file.getName() + "]");
		else
			str.append(file.getName() + " " + countRows(file));	//Add number of rows to files	
		System.out.println(str.toString());		
	}
	
	private static int countRows(File file) throws FileNotFoundException {		
			int rows = 0; //Row counter
			Scanner input = new Scanner(file); //Open a scanner on provided location			
			while(input.hasNextLine()) { //Until end of file is reached
				input.nextLine(); //Go to next line
				rows++; //Add to row counter
			}
			input.close();
			return rows; //Return counted rows
	}
}
