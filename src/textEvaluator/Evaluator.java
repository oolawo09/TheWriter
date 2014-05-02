package textEvaluator;

/**
 * @author anthonyotienoolawo
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import memory.Memory;
import utilities.*; 

public class Evaluator {
	private Map<String, Double> evaluations; 
	
	/**
	 * 
	 */
	public Evaluator(){ 
		evaluations = new HashMap<String, Double>();
	}
	
	public Map<String, Double> evaluateMultipleSentences(List<String> sentences){ 
		for(String sentence: sentences){
			evaluations.putAll(evaluateSentence(sentence));
		}
		
		return evaluations; 
	}
	
	
	/**
	 * 
	 * @param sentence
	 * @return
	 */
	public Map<String,Double> evaluateSentence(String sentence){
		String [] tokenizedSentence = tokeniseSentence(sentence);
		return updateWordWeights(tokenizedSentence); 
	}
	
	/**
	 * 
	 * @param tokenizedSentence
	 * @return
	 */
	public Map<String,Double> updateWordWeights(String [] tokenizedSentence){ 
		Map<String, Double> result = new HashMap<String, Double>(); 

		for(int i=0; i<tokenizedSentence.length; i++){ 
			String word = tokenizedSentence[i];
			if(!result.containsKey(word)){
				result.put(word, Constants.DEFAULT_WORD_WEIGHT);
			}
			else{
				Double weight = result.get(word);
				result.remove(word);
				weight += Constants.WORD_WEIGHT_SINGLE_UNIT_INCREMENT;
				result.put(word, weight);
			}
		}	
		return result; 
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
