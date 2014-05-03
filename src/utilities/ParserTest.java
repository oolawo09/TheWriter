package utilities;

import org.junit.Test;

public class ParserTest {
	private Parser parser;
	
	@Test
	public void readIn(){
		parser = new Parser(); 
		parser.parse("/Users/anthonyotienoolawo/git/TheWriter/src/model/reader/data/alice.txt"); 
	}
	
	
}
