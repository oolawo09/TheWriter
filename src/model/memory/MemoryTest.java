package model.memory;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.words.Word; 

public class MemoryTest {

	private Memory memory  = Memory.getInstance();
	List<Word> words = new ArrayList<Word>(); 
	List<String> sentences = new ArrayList<String>(); 


	@Test 
	public void testCommitAndRecallOfWords(){ 
		words = initialiseWords();
		memory.commit(words); 
		List <Word> recalledWords = memory.recallWordsFromMemory(); 
		for(int i=0; i<recalledWords.size(); i++){
			assertEquals(words.get(i), recalledWords.get(i)); 
		}
	}

	@Test 
	public void testCommitAndRecallOfSentences(){
		sentences = initialiseSentences(); 
		memory.commit(sentences);
		List<String> recalledSentences = memory.recallSentencesFromMemory(); 
		assertEquals(sentences, recalledSentences);
	}

	public List<String> initialiseSentences(){ 
		List<String> sentences = new ArrayList<String>(); 
		for(int i=0; i<10; i++){
			sentences.add("This is the " + i + "th sentence.");
		}
		return sentences; 
	}

	public List<Word> initialiseWords(){
		List<Word> words = new ArrayList<Word>(); 
		for(double i=0; i<10; i++){
			String word = "word " + i;
			words.add(new Word(word, i));
		}

		return words; 
	}

}
