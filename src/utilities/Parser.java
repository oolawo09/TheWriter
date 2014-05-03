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

	/**
	 * 
	 * 
	 */
	public Parser(){
		parsedString = new String("");
	}

	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public String parse(String fileName){
		try {
			scanner = new Scanner (new File(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parsedString = scanner.useDelimiter("\\Z").next(); 
		scanner.close(); 	
		System.out.println(parsedString); 
		return parsedString; 
	}
	
	/*protected int readChars(Scanner s) {
		myString = s.useDelimiter("\\Z").next();
		s.close();    
		return myString.length();

	}*/



}