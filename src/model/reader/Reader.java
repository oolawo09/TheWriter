package model.reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.memory.Memory;
import model.words.Word;
import model.words.WordFactory;
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
