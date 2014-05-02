package lexicon;
/**
 * This class creates words returning a reference to each created word.  
 * 
 * @author anthonyotienoolawo
 *
 */
public class WordFactory {
	
	
	/**
	 * 
	 * @param word
	 * @param type
	 * @return
	 */
	public Word newWord(String word, String type){
		return new Word(word, type); 
	}
	
	/**
	 * 
	 * @param word
	 * @param type
	 * @param weight
	 * @return
	 */
	
	public Word newWord(String word, String type, Double weight){ 
		return new Word(word, type, weight); 
	}
	
}
