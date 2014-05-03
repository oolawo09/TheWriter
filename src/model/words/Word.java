package model.words;
/**
 * 
 * @author anthonyotienoolawo
 * 
 * A wrapper class for the String word. It holds a word, its type and weight. 
 *
 */

import java.io.Serializable;

import utilities.*; 

public class Word implements Comparable<Word>, Serializable{
	private String word; 
	private String type;
	private Double weight; 


	/**
	 * Word constructor that doesn't require a weight parameter 
	 * @param word
	 * @param type
	 */
	
	public Word(String word, String type){ 
		this.word = word; 
		this.type = type; 
		this.weight = Constants.DEFAULT_WORD_WEIGHT; 
	}
	
	/**
	 * Word constructor that requires a weight parameter 
	 * @param word
	 * @param type
	 * @param weight
	 */
	
	public Word(String word, String type, Double weight){ 
		this.word = word; 
		this.type = type; 
		this.weight = weight; 
	}
	
	public Word(String word, Double weight){
		this.word = word; 
		this.type = "default type";
		this.weight = weight; 
		
	}
	/**
	 * 
	 * @param newWeight a positive/negative double that's added to the word's weight 
	 */
	public void updateWeight(double newWeight){ 
		weight += newWeight; 
	}
	
	/**
	 * 
	 * @return
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * 
	 */
	public String toString(){ 
		return "word type: "+type + ", actual word: " + word + ", word weight: " + weight; 
	}

	@Override
	public int compareTo(Word arg0) {
		// TODO Auto-generated method stub
		Double compareWeight = ((Word) arg0).getWeight(); 
		return (int) (compareWeight - this.weight);
	}
	
	public Double getWeight() {
		return weight;
	}
	
	
}
