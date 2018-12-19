package modele;

import java.util.HashMap;

import modele.comportements.I_PlayManchot;

/**
 * 
 * @author Kenny
 *
 */
public class Constants {

	@SuppressWarnings("rawtypes")
	/**
	 * Relation take care of saying if said player can play a machine
	 */
	private static HashMap<Class,Class> relation;
	
	/**
	 * 
	 */
	static {
		relation=new HashMap<Class,Class>();
		relation.put(MachineManchot.class, I_PlayManchot.class);
	}
	
	@SuppressWarnings("rawtypes")
	public static HashMap<Class,Class> getRelation() {
		return Constants.relation;
	}
}
