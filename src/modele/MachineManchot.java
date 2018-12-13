package modele;

import modele.comportements.I_RulesGainWheel;

public class MachineManchot extends Ab_Machine{

	private I_RulesGainWheel comp_Rules;
	private Ab_Roulette [] arrWheel;
	private boolean [] locked;
	
	@Override
	public int jouer() {
		Symbol [] results=new Symbol[arrWheel.length];
		for(int i=0;i<arrWheel.length;i++) {
			if(!locked[i]) {
				arrWheel[i].randomizeSymbol();
			}
			results[i]=arrWheel[i].getStoppedSymbol();
		}
		
		return comp_Rules.CalculerGain(results, this.countLockedWheels());
	}
	
	private int countLockedWheels() {
		int lockedWheels=0;
		for(int i=0;i<locked.length;i++) {
			lockedWheels++;
		}
		return lockedWheels;
	}

	public MachineManchot(Ab_Roulette[] wheels,I_RulesGainWheel rules) {
		this.comp_Rules=rules;
		this.arrWheel=wheels;
		this.locked=new boolean[wheels.length];
		for(int i=0;i<locked.length;i++) {
			locked[i]=false;
		}
	}


}
