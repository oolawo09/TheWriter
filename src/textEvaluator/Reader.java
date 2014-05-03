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
		for(String w: evaluations.keySet()){ 
			updateWordWeight(w, evaluations.get(w)); 
		}
		
	}

	/**
	 * 
	 * @param recentlyReadSentences
	 * @return 
	 */
	private Map<String, Double> processEvaluations(List<String> recentlyReadSentences){ 
		return evaluator.evaluateMultipleSentences(recentlyReadSentences);
	}
	
	private Word locateWord(String word){ 
		for(Word w: wordsInMemory){ 
			if(w.getWord().equals(word)){
				return w; 
			}
		} 
			return null; 
	}
	
	private void updateAllWordsWeights(Map<String, Double> evaluations){ 
		
	}
	
	private void updateWordWeight(String word, Double weight){ 
		Word locatedWord = locateWord(word); 
		if(locatedWord==null){
			Word w = new Word(word, weight);
			wordsInMemory.add(w); 
		}
		else 
			locatedWord.updateWeight(weight);
			
		
	}
	
	

	
}
