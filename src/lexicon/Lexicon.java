package lexicon;

import java.util.ArrayList;
import java.util.List;

import memory.Memory;
import utilities.*; 

/**
 * 
 * @author anthonyotienoolawo
 *
 */


public class Lexicon {
	private List<Word> wordsLearnt;
	private WordFactory wordFactory;
	private Printer printer; 
	private Memory memory; 
	
	public Lexicon(){ 
		wordsLearnt = new ArrayList<Word>(); 
		wordFactory = new WordFactory(); 
		printer = new Printer(); 
		memory = new Memory(); 
		wordsLearnt = memory.recallWordsFromMemory(); 
	}
	
	/**
	 * 
	 * @param word
	 * @param type
	 * @param weight
	 */
	public void insertNewWord(String word, String type, Double weight){ 
		if (weight == null){
			wordsLearnt.add(wordFactory.newWord(word, type));
		}
		else
			wordsLearnt.add(wordFactory.newWord(word, type, weight));
	}
	
	
}
