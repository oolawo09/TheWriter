package memory;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lexicon.Word;
import utilities.*; 

/**
 * 
 * @author anthonyotienoolawo
 *
 */
public class Memory {
	private List<Word> wordsInMemory; 
	private List<String> sentencesInMemory; 
	private SentenceStreams sentenceStreams; 
	private WordStreams wordStreams; 
	private WordWeightStreams wordWeightStreams; 
	private static Memory _instance; 

	private Memory(){ 
		wordsInMemory = new ArrayList<Word>();
		sentencesInMemory = new ArrayList<String>(); 
		sentenceStreams = new SentenceStreams(Constants.SENTENCES_FILE); 
		wordStreams = new WordStreams(Constants.WORDS_FILE);
		wordWeightStreams = new WordWeightStreams(Constants.WORD_WEIGHT_FILE); 
	}
	
	public static Memory getInstance(){
		if(_instance == null){
			_instance = new Memory();
		}
		return _instance; 
	}
	
	/**
	 * 
	 * @param words
	 */
	public void commit(List<?> words){ 
		if(words.get(0) instanceof Word){
			wordStreams.out(words); 
		}
		else 
			sentenceStreams.out(words); 
	}
	
	/**
	 * 
	 * @param words
	 */
	public void commit(Map<String, Double> wordWeights){ 
		wordWeightStreams.out(wordWeights);
	}
	
	/**
	 * 
	 * @param object
	 */
	public void commit(Object object){ 
		wordWeightStreams.out(object);
	}

	/**
	 * 
	 * @return
	 */
	public List<String> recallSentencesFromMemory(){
		return (List<String>) sentenceStreams.in(); 
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Word> recallWordsFromMemory(){
		return (List<Word>) wordStreams.in(); 
	}
	

	/**
	 * 
	 * @return
	 */
	public Map<String, Double> recallWordWeightsFromMemory(){ 
		return (Map<String, Double>) wordWeightStreams.in(); 
	}
	
	
}
