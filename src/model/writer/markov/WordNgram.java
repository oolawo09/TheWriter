package model.writer.markov;
/*
 * This class encapsulates N words/strings so that the
 * group of N words can be treated as a key in a map or an
 * element in a set, or an item to be searched for in an array.
 * <P>
 * @author anthonyotienoolawo
 */

public class WordNgram implements Comparable<WordNgram>{
    
	private String[] myWords;
	private int hashCode; 
	/*
	 * Store the n words that begin at index start of array list as
	 * the N words of this N-gram.
	 * @param list contains at least n words beginning at index start
	 * @start is the first of the N words to be stored in this N-gram
	 * @n is the number of words to be stored (the n in this N-gram)
	 */
	public WordNgram(String[] list, int start, int n) {
		myWords = new String[n];
		System.arraycopy(list, start, myWords, 0, n);
		for(int i=0; i<myWords.length; i++){
			if(i!=0)
				hashCode +=myWords[i].hashCode()*10^(myWords[i].length());
			hashCode +=myWords[i].hashCode();
		}
	}

	/**
	 * Return value that meets criteria of compareTo conventions.
	 * @param wg is the WordNgram to which this is compared
	 * @return appropriate value less than zero, zero, or greater than zero
	 */
	public int compareTo(WordNgram wg) {
		// TODO  implement this method
		if(wg==this)
			return 0;
		if(wg.hashCode>this.hashCode)
			return 1;

		return -1;
	}

	/**
	 * Return true if this N-gram is the same as the parameter: all words the same.
	 * @param o is the WordNgram to which this one is compared
	 * @return true if o is equal to this N-gram
	 */
	public boolean equals(Object o){
		WordNgram other = (WordNgram) o;

		for(int k=0; k<myWords.length; k++){
			if(!myWords[k].equals(other.myWords[k])){
				return false;
			}

		}
		return true;
		// TODO return correct value
	}
	public String returnsLastWord(){
		int lastIndex=myWords.length-1;
		return myWords[lastIndex];
	}

	/**
	 * Returns a good value for this N-gram to be used in hashing.
	 * @return value constructed from all N words in this N-gram
	 */
	public int hashCode(){
		// TODO return a better hash value


		return hashCode;
	}
}
