package modele;

import modele.comportements.I_RulesGainWheel;

/**
 * Effective class of machine manchot
 * Follow a Strategy Pattern around the wheels (who are abstract class) and the rules (interface) used to determine the gain
 * 
 * @param wheels
 * @param rules
 */
public class MachineManchot extends Ab_Machine{

	private I_RulesGainWheel compRules;
	private Ab_Roulette [] arrWheel;
	private boolean [] locked;
	
	@Override
	/**
	 * play function of the abstract machine
	 * Randomize unlocked wheels and return eventual gain to the player (via arrWheel and compRules)
	 */
	public int jouer() {
		Symbol [] results=new Symbol[arrWheel.length];
		for(int i=0;i<arrWheel.length;i++) {
			if(!locked[i]) {
				arrWheel[i].randomizeSymbol();
			}
			results[i]=arrWheel[i].getStoppedSymbol();
		}
		
		return compRules.determineGain(results, this.countLockedWheels());
	}
	
	/**
	 * 
	 * @return a String representation of the symbol currently stopped on all the wheels
	 */
	public String getStringOfWheels() {
		String status = new String();
		for(int i=0;i<arrWheel.length;i++) {
			status+=arrWheel[i].getStoppedSymbol().symbol;
		}
		return status;
	}
	
	
	private int countLockedWheels() {
		int lockedWheels=0;
		for(int i=0;i<locked.length;i++) {
			lockedWheels++;
		}
		return lockedWheels;
	}

	public MachineManchot(Ab_Roulette[] wheels,I_RulesGainWheel rules) {
		this.compRules=rules;
		this.arrWheel=wheels;
		this.locked=new boolean[wheels.length];
		for(int i=0;i<locked.length;i++) {
			locked[i]=false;
		}
	}


}
