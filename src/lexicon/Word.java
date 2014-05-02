package lexicon;
/**
 * 
 * @author anthonyotienoolawo
 * 
 * A wrapper class for the String word. It holds a word, its type and weight. 
 *
 */

import utilities.*; 

public class Word {
	private String word; 
	private String type;
	private double weight; 
	
	
	/**
	 * Word constructor that doesn't require a weight parameter 
	 * @param word
	 * @param type
	 */
	
	public Word(String word, String type){ 
		this.word = word; 
		this.type = type; 
		this.weight = Constants.DEFAULT_WEIGHT; 
	}
	
	/**
	 * Word constructor that requires a weight parameter 
	 * @param word
	 * @param type
	 * @param weight
	 */
	
	public Word(String word, String type, double weight){ 
		this.word = word; 
		this.type = type; 
		this.weight = weight; 
	}
	
	
	
	
}
