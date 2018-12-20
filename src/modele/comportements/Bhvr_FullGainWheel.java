package modele.comportements;

import modele.MachineManchot;
import modele.Symbol;

/**
 * Simple implementation of I_RulesGainWheel that send all the pactole to the player if he win
 * @author Kenny
 *
 */
public class Bhvr_FullGainWheel implements I_RulesGainWheel {

	@Override
	/**
	 * Player will earn the symbol value if all the wheels have the same symbols, 
	 * the percentage of locked wheels is then applied as a malus
	 * 
	 * 
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
		//Lazy implementation
		//TODO proper implementation
		if(gain>0) {
			gain=mach.getPactole();
		}
		return gain*(1-nbOfLockedWheels/symbols.length);
	}

}
