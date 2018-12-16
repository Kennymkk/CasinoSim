package modele.comportements;

import modele.Symbol;

/**
 * Simple interface used to determine the gain of wheels machine
 * @author Kenny
 *
 */
public interface I_RulesGainWheel {
	
	public int determineGain(Symbol[] symbols,int nbOfLockedWheels) ;
}
