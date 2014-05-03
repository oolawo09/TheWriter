package textEvaluator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lexicon.Word;
import lexicon.WordFactory;
import memory.Memory;
import utilities.Parser;

/**
 * 
 * @author anthonyotienoolawo
 *
 */

public class Reader {

	private Evaluator evaluator; 
	private List<String> recentlyRead; 
	Map<String, Double> evaluations;
	private Memory memory; 
	private WordFactory wordFactory; 
	private List<Word> wordsInMemory; 

	public Reader() { 
		evaluator = new Evaluator(); 
		recentlyRead = new ArrayList<String>();
		memory = Memory.getInstance(); 
		wordFactory = new WordFactory(); 
		wordsInMemory = new ArrayList<Word>();
		wordsInMemory = memory.recallWordsFromMemory();
	}


	/**
	 * 
	 * @param fileName
	 */
	public void read(String fileName){

		//find a way to read through the view
		//recentlyRead = parser.parse(fileName); 
		memory.commit(recentlyRead); 
		evaluations = processEvaluations(recentlyRead); 
	}

	/**
	 * 
	 * @param recentlyReadSentences
	 * @return 
	 */
	private Map<String, Double> processEvaluations(List<String> recentlyReadSentences){ 
		return evaluator.evaluateMultipleSentences(recentlyReadSentences);
	}
	
	private void updateWordWeights(String word, Double weight){ 
		
	}

	
}
