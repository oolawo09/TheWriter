package theWriter;

import model.reader.Reader;
import model.writer.Writer;
import utilities.*;

/**
 * 
 * @author anthonyotienoolawo
 *
 */

public class Main {
	
	public static void main(String [] args){
		 Reader reader = new Reader();
		 reader.read(Constants.SAMPLE_STORY_FILE); 
		 Writer writer = new Writer(); 
		 writer.write(Constants.DEFAULT_MARKOV_SEED); 
	}
	
	

}
