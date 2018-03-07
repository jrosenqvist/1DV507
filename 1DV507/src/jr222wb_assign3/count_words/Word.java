package jr222wb_assign3.count_words;

public class Word implements Comparable<Word> {
	private String word;
	
	public Word(String str) { word = str; }
	
	@Override
	public String toString() { return word; }
	
	@Override
	public int hashCode() {	return word.toLowerCase().hashCode(); }
	
	@Override
	public boolean equals(Object other) {		
		return word.toLowerCase().equals(other.toString().toLowerCase()); //Convert to lower case and compare		
	}
	
	@Override
	public int compareTo(Word w) {
		String thisStr = word.toLowerCase();
		String otherStr = w.toString().toLowerCase();
		
		int i = 0;
		while (i < thisStr.length() && i < otherStr.length()) { //Iterate over length of shortest string
			if (thisStr.charAt(i) != otherStr.charAt(i)) //If chars at position are not equal 
				return thisStr.charAt(i) - otherStr.charAt(i); //Return whether thisStr is larger or smaller		
			i++; //Continue loop if current chars are equal
		}
		//If strings are equal over length of shortest string, return shorter string as smaller, or that strings are equal
		return thisStr.length() - otherStr.length();
	}
}
