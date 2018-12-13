package modele;

import modele.comportements.I_RulesGainWheel;

public class RulesGainWheel implements I_RulesGainWheel {

	@Override
	public int CalculerGain(Symbol[] symbols,int nbOfLockedWheels) {
		String firstSymbol=symbols[0].symbol;
		int gain=symbols[0].value;
		for(int i=1;i<symbols.length;i++) {
			if(!(symbols[i].symbol==firstSymbol)) {
				gain=0;
				break;
			}
		}
		return gain/nbOfLockedWheels;
	}

}
