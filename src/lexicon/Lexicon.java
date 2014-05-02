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
	private Memory memory; 
	
	public Lexicon(){ 
		wordsLearnt = new ArrayList<Word>(); 
		wordFactory = new WordFactory(); 
		memory = Memory.getInstance(); 
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
		memory.commit(wordsLearnt); 
	}
	
	/**
	 * 
	 * @param word
	 * @param newWeight
	 */
	public void updateWordWeight(String word, double newWeight){
		for(Word w: wordsLearnt){
			if(w.getWord().equals(word))
				w.updateWeight(newWeight); 
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Word> getWordsLearnt() {
		return wordsLearnt;
	}
	
}
