package model.memory.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * @author anthonyotienoolawo
 *
 */

public class OutputStream {
	private FileOutputStream fileOutputStream; 
	private ObjectOutputStream objectOutputStream; 
	private String fileOut; 

	public OutputStream(String fileIn){ 
		this.fileOut = fileIn;
		initFileOutputStream(fileIn);
		initObjectOutputStream(fileOutputStream); 
	}

	/**
	 * 
	 * @param fileName
	 */
	private void initFileOutputStream(String fileName){ 
		try {
			fileOutputStream = new FileOutputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	/**
	 * 
	 * @param fileOutputStream
	 */
	private void initObjectOutputStream(FileOutputStream fileOutputStream){ 
		try {
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param object
	 */

	public void out (Object object){ 
		try {
			objectOutputStream.writeObject(object);
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
	}







}
