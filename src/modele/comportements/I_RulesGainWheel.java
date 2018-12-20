package modele.comportements;

import modele.MachineManchot;
import modele.Symbol;

/**
 * Simple interface used to determine the gain of wheels machine
 * @author Kenny
 *
 */
public interface I_RulesGainWheel {
	
	//TODO remove all parameters but MachineManchot and do change accordingly
	public int determineGain(Symbol[] symbols,int nbOfLockedWheels,MachineManchot mach) ;
}
