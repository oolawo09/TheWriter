package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * @author anthonyotienoolawo
 *
 */

public class InputStream {
	private FileInputStream fileInputStream; 
	private ObjectInputStream objectInputStream; 
	private String fileIn; 

	public InputStream(String fileIn){ 
		this.fileIn = fileIn;
		initFileInputStream(fileIn);
		initObjectInputStream(fileInputStream); 
	}

	/**
	 * 
	 * @param fileName
	 */
	void initFileInputStream(String fileName){ 
		try {
			fileInputStream = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	/**
	 * 
	 * @param fileInputStream
	 */
	void initObjectInputStream(FileInputStream fileInputStream){ 
		try {
			objectInputStream = new ObjectInputStream(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @return
	 */

	public Object in(){ 
		Object object = null; 
		try {
			object = ((ObjectInput) fileInputStream).readObject();
			objectInputStream.close(); 
			fileInputStream.close(); 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return object; 
	}







}
