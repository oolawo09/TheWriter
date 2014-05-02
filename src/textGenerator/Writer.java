package textGenerator;

import java.util.List;

import lexicon.*;
import memory.Memory;

/**
 * 
 * @author anthonyotienoolawo
 *
 */

public class Writer {
	private Lexicon lexicon; 
	private Memory memory; 
	private List<Word> wordsLearnt;
	private List<String> sentencesRemembered; 
	
	
	public Writer(){
		lexicon = new Lexicon();
		wordsLearnt = lexicon.getWordsLearnt();
		memory = Memory.getInstance(); 
	}
	 
	
	
	
	
	
}
