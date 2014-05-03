package textEvaluator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lexicon.Lexicon;
import memory.Memory;
import utilities.Parser;

/**
 * 
 * @author anthonyotienoolawo
 *
 */

public class Reader {
	
	private Evaluator evaluator; 
	private Parser parser;
	private List<String> recentlyRead; 
	private Memory memory; 
	private Lexicon lexicon; 

	public Reader() { 
		evaluator = new Evaluator(); 
		parser = new Parser(); 
		recentlyRead = new ArrayList<String>();
		memory = Memory.getInstance(); 
		lexicon = new Lexicon(); 
	}
	
	
	/**
	 * 
	 * @param fileName
	 */
	public void read(String fileName){
		recentlyRead = parser.parse(fileName); 
		memory.commit(recentlyRead); 
	}
	
	/**
	 * 
	 * @param recentlyReadSentences
	 * @return 
	 */
	public Map<String, Double> processEvaluations(List<String> recentlyReadSentences){ 
		return evaluator.evaluateMultipleSentences(recentlyReadSentences);
	}
	
	/**
	 * 
	 */
	public void updateWordWeights(){
		Map<String, Double> evaluations = processEvaluations(recentlyRead); 
		for(String word: evaluations.keySet()){
			lexicon.updateWordWeight(word, evaluations.get(word)); 
		}
	}
	

}
