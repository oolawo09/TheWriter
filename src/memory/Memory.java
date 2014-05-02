package memory;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

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

	public Memory(){ 
		wordsInMemory = new ArrayList<Word>();
		sentencesInMemory = new ArrayList<String>(); 
		sentenceStreams = new SentenceStreams(Constants.SENTENCES_FILE); 
		wordStreams = new WordStreams(Constants.WORDS_FILE);
	}
	
	public void commit(List<?> words){ 
		if(words.get(0) instanceof Word){
			
		}
	}

	public void commit(String sentence){ 

	}

	

	public List<String> recallSentencesFromMemory(){

	}
	
	public List<Word> recallWordsFromMemory(){
		
	}
}
