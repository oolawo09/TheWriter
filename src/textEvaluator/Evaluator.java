package textEvaluator;

/**
 * @author anthonyotienoolawo
 */

import java.util.ArrayList;
import java.util.List;

import memory.Memory;
import utilities.*; 

public class Evaluator {
	private Parser parser;
	private List<String> recentlyRead; 
	private Memory memory; 
	
	/**
	 * 
	 */
	public Evaluator(){ 
		parser = new Parser(); 
		recentlyRead = new ArrayList<String>();
		memory = new Memory(); 
	}
	
	/**
	 * 
	 * @param fileName
	 */
	public void read(String fileName){
		recentlyRead = parser.parse(fileName); 
		memory.commit(recentlyRead); 
	}
	
	
	
}
