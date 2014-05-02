package memory;

import utilities.*;

/**
 * 
 * @author anthonyotienoolawo
 *
 */
public class SuperStream {
	private InputStream inputStream; 
	private OutputStream outputStream; 
	
	
	/**
	 * 
	 * @param fileIn
	 * @param fileOut
	 */
	public SuperStream(String fileName){ 
		inputStream = new InputStream(fileName); 
		outputStream = new OutputStream(fileName); 
	}
	
	public void out(Object object){
		outputStream.out(object);
	}
	
	public Object in(){
		return inputStream.in(); 
	}
}
