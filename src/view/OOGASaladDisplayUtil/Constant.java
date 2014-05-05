package view.OOGASaladDisplayUtil;

import java.awt.Font;

public class Constant {
	
	public final static boolean DEBUG = true;
	
	public final static int leftBorder = 10;
	public final static int rightBorder = 10;
	public final static int upperBorder = 10;
	public final static int bottomBorder = 10;
	
	public final static String imagePropertyFile = "resources.images";
	public final static Font titleFont = new Font("Roman", Font.BOLD, 16);
	public final static Font contentFont = new Font("monaco", Font.PLAIN, 15);
	public final static Object[] identifiers = {"Item", "Number"};
	
	public final static String imageSelectedPathTag = "imageSelectedPath";

	public final static void LOG(Class<?> cls, String str) {
		if (DEBUG) System.out.println(cls.toString() + " " + str);
	}

}

