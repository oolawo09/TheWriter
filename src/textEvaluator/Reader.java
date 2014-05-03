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

	public Reader() { 
		evaluator = new Evaluator(); 
		recentlyRead = new ArrayList<String>();		
	}


	/**
	 * 
	 * @param fileName
	 */
	public void read(String fileName){

		//find a way to read through the view
		//recentlyRead = parser.parse(fileName);
		
		evaluator.evaluate(recentlyRead);	
	}


}
