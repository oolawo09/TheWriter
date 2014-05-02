package utilities; 
/**
 * @author anthonyotienoolawo
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {
	private Scanner scanner;
	private List<String> parsedStrings;

	/**
	 * 
	 * @param fileName
	 */
	public Parser(String fileName){
		parsedStrings = new ArrayList<String>();
	}

	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public List<String> parse(String fileName){
		scanner = new Scanner (fileName);
		while(scanner.hasNext()){
			parsedStrings.add(scanner.next());
		}
		scanner.close(); 
		return parsedStrings; 
	}

}