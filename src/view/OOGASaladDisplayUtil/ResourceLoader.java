package view.OOGASaladDisplayUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Loads resources from a properties file and puts them in a map
 * Code heavily influenced by Jordan Ly's work in SLogo
 *
 */
public class ResourceLoader {
	
	public static Map<String, String> load(String tag, String fileName) {
		Map<String, String> loaded = new HashMap<String, String>();
		
		ResourceBundle bundle = ResourceBundle.getBundle(fileName);
		
		return loaded;
	}
}
