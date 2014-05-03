package textEvaluator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	Map<String, Double> evaluations;
	private Memory memory; 

	public Reader() { 
		evaluator = new Evaluator(); 
		parser = new Parser(); 
		recentlyRead = new ArrayList<String>();
		memory = Memory.getInstance(); 
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
		evaluations = processEvaluations(recentlyRead); 
	}
	


}
