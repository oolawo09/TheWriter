package model.reader;

/**
 * @author anthonyotienoolawo
 */

import java.util.ArrayList;
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
		evaluations = evaluateMultipleSentences(sentencesRead); 
		updateAllWordsWeights(evaluations); 
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
	 * @param evaluations
	 */
	public void updateAllWordsWeights(Map<String, Double> evaluations){ 
		for(String w: evaluations.keySet()){ 
			updateWordWeight(w, evaluations.get(w)); 
		}
		memory.commit(wordsInMemory); 
	}

	/**
	 * 
	 * @param word
	 * @param weight
	 */
	public void updateWordWeight(String word, Double weight){ 
		Word locatedWord = locateWord(word); 
		if(locatedWord==null){
			Word w = new Word(word, weight);
			wordsInMemory.add(w); 
		}
		else 
			locatedWord.updateWeight(weight);

	}



	/**
	 * 
	 * @param sentences
	 * @return
	 */
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
		return calculateWordWeights(tokenizedSentence); 
	}

	/**
	 * 
	 * @param tokenizedSentence
	 * @return
	 */
	public Map<String,Double> calculateWordWeights(String [] tokenizedSentence){ 
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
		System.out.println(result);
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
