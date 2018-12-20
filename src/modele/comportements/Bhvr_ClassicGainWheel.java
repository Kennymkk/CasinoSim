package modele.comportements;

import modele.MachineManchot;
import modele.Symbol;

/**
 * Simple implementation of I_RulesGainWheel
 * @author Kenny
 *
 */
public class Bhvr_ClassicGainWheel implements I_RulesGainWheel {

	@Override
	/**
	 * Player will earn the symbol value if all the wheels have the same symbols, 
	 * the percentage of locked wheels is then applied as a malus
	 */
	public int determineGain(Symbol[] symbols,int nbOfLockedWheels,MachineManchot mach) {
		String firstSymbol=symbols[0].symbol;
		int gain=symbols[0].value;
		for(int i=1;i<symbols.length;i++) {
			if(!(symbols[i].symbol==firstSymbol)) {
				gain=0;
				break;
			}
		}
		
		
		return gain*(1-nbOfLockedWheels/symbols.length);
	}

}
