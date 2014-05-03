package model.reader;

/**
 * @author anthonyotienoolawo
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.memory.Memory;
import model.words.Word;
import utilities.*; 

public class Evaluator {
	private Map<String, Double> evaluations; 
	private List<Word> wordsInMemory; 
	private Memory memory; 


	/**
	 * 
	 */
	public Evaluator(){ 
		evaluations = new HashMap<String, Double>();
		memory = Memory.getInstance(); 
		initWordsInMemory(); 
	}

	public void initWordsInMemory(){ 
		wordsInMemory = new ArrayList<Word>();
		if(memory.recallWordsFromMemory() != null){
			wordsInMemory = memory.recallWordsFromMemory();
		}
	}

	public void evaluate(List <String> sentencesRead){ 
		memory.commit(sentencesRead); 
		addWordsToMemory(sentencesRead);
	}

	public void addWordsToMemory(List<String> sentencesRead){
		for(String sentence: sentencesRead){
			String [] tokenisedSentence = tokeniseSentence(sentence);
			updateWordWeight(tokenisedSentence); 
		}
		Collections.sort(wordsInMemory);
		memory.commit(wordsInMemory); 
		System.out.println(wordsInMemory); 
	}
	
	public void updateWordWeight(String [] tokenisedSentence){ 
		for(int i=0; i<tokenisedSentence.length; i++){
			if(locateWord(tokenisedSentence[i])==null){
				Word word = new Word(tokenisedSentence[i].toLowerCase(), Constants.DEFAULT_WORD_WEIGHT);
				wordsInMemory.add(word); 
			}
			else 
				locateWord(tokenisedSentence[i]).updateWeight(Constants.WORD_WEIGHT_SINGLE_UNIT_INCREMENT);
		}
	}
	
	
	/**
	 * 
	 * @param word
	 * @return
	 */
	public Word locateWord(String word){ 
		for(Word w: wordsInMemory){ 
			if(w.getWord().equals(word)){
				return w; 
			}
		} 
		return null; 
	}
	
	/**
	 * 
	 * @param sentence
	 * @return
	 */
	private String [] tokeniseSentence(String sentence){ 
		return sentence.split("\\s+");
	}
	
	
	

}
