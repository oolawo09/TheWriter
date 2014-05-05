package model.writer;

import java.util.List;

import model.memory.Memory;
import model.words.*;
import model.writer.markov.WordMarkovModel;
import utilities.*; 

/**
 * 
 * @author anthonyotienoolawo
 *
 */

public class Writer {
	private Memory memory; 
	private List<Word> wordsLearnt;
	private List<String> sentencesRemembered; 
	private WordMarkovModel wordMarkovModel; 
	
	
	public Writer(){
		memory = Memory.getInstance(); 
		wordMarkovModel = new WordMarkovModel(); 
	}
	
	public void write(int k){
		wordMarkovModel.setMyString(combineWordsInAString(wordsLearnt)); 
		wordMarkovModel.createMap(k);
		wordMarkovModel.smarterThanBrute(k,Constants.DEFAULT_MARKOV_WORD_COUNT); 
	}
	
	public String combineWordsInAString(List<Word> wordsLearnt  ){
		String answer = " "; 
		for(Word word: wordsLearnt){
			answer+= word.getWord() + " "; 
		}
		return answer; 
	}
	 
	
	
	
	
	
}
