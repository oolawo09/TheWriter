package model.reader;
/**
 * @author anthonyotienoolawo
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class ReaderTest {
	private Reader reader = new Reader(); 
	
	
	@Test
	public void TestSentenceCommitAndRecall(){ 
		reader.read("/Users/anthonyotienoolawo/git/TheWriter/src/model/reader/data/alice.txt");
	}
	

}
