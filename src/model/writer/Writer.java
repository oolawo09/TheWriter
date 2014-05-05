package model.writer;

import java.util.ArrayList;
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
	private List<String> sentencesLearnt; 
	private WordMarkovModel wordMarkovModel; 
	
	
	public Writer(){
		wordsLearnt = new ArrayList<Word>(); 
		sentencesLearnt = new ArrayList<String>(); 
		memory = Memory.getInstance(); 
		wordMarkovModel = new WordMarkovModel(); 
	}
	
	public void write(int k){
		recallWords(); 
		recallSentences(); 
		wordMarkovModel.setMyString(combineWordsInAString(wordsLearnt)); 
		wordMarkovModel.createMap(k);
		wordMarkovModel.smarterThanBrute(k,Constants.DEFAULT_MARKOV_WORD_COUNT); 
	}
	
	private void recallWords(){ 
		wordsLearnt = memory.recallWordsFromMemory(); 
	}
	
	private void recallSentences(){ 
		sentencesLearnt = memory.recallSentencesFromMemory(); 
	}
	
	public String combineWordsInAString(List<Word> wordsLearnt  ){
		String answer = " "; 
		for(Word word: wordsLearnt){
			answer+= word.getWord() + " "; 
		}
		return answer; 
	}
	 
	
	
	
	
	
}
