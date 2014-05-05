package theWriter;

import model.reader.Reader;
import model.writer.Writer;

/**
 * 
 * @author anthonyotienoolawo
 *
 */

public class Main {
	
	public static void main(String [] args){
		 Reader reader = new Reader();
		 reader.read(""); 
		 Writer writer = new Writer(); 
		 writer.write(5); 
	}

}
