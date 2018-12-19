package modele;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This class contain various utility functions, they should had been part of extensions of a class or another nice way to incorporate them
 * into the code, unfortunately due to the lack of time, they are right here, right now.
 * @author Kenny
 *
 */
public class GeneralPurpose {
	
	/**
	 * KV Should had been typed to neutral, unfortunately i don't know how to do it atm
	 * @return
	 */
	public static String getMaxOfParamHashMap(Map<String,Integer> map) {
		
		int maxValue=0;
		String maxKey=new String();
		for(Entry<String,Integer> entry : map.entrySet()) {
			Integer value=entry.getValue();
			if(value>maxValue) {
				maxValue=value;
				maxKey=entry.getKey();
			}
		}
		
		return maxKey;
	}
	
}
