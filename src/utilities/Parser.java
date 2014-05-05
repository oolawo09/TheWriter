package utilities; 
/**
 * @author anthonyotienoolawo
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {
	private Scanner scanner;
	private String parsedString;
	private List<String> sentences; 

	/**
	 * 
	 * 
	 */
	public Parser(){
		sentences = new ArrayList<String>(); 
		parsedString = new String("");
	}

	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public List<String> parse(String fileName){
		try {
			scanner = new Scanner (new File(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parsedString = scanner.useDelimiter("\\Z").next();
		parsedString.replaceAll("[^a-zA-Z ]", "");
		scanner.close(); 
		return breakFileInputIntoStrings(); 
	}
	
	/**
	 * 
	 * @return
	 */
	
	public List<String> breakFileInputIntoStrings(){ 
		String [] temp = parsedString.split("[?.!]");
		for(int i= 0; i<temp.length; i++){
			sentences.add(temp[i]);
		}
		return sentences; 
	}



}