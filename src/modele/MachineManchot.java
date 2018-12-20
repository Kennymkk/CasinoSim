package modele;

import modele.comportements.I_RulesGainWheel;

/**
 * Effective class of machine manchot
 * Follow a Strategy Pattern around the wheels (who are abstract class) and the rules (interface) used to determine the gain
 * 
 * @author Kenny
 */
public class MachineManchot extends Ab_Machine{

	private I_RulesGainWheel bhvr_Rules;
	private Ab_Roulette [] arr_Wheel;
	private boolean [] locked;
	
	
	@Override
	/**
	 * play function of the abstract machine
	 * Randomize unlocked wheels and return eventual gain to the player (via arrWheel and compRules)
	 * The flow is just to use wheel functions to randomize the symbols, then we send the results to the current object Gain implementation so he send us back the gain
	 */
	public int play() {
		Symbol [] results=new Symbol[arr_Wheel.length];
		for(int i=0;i<arr_Wheel.length;i++) {
			if(!locked[i]) {
				arr_Wheel[i].randomizeSymbol();
			}
			results[i]=arr_Wheel[i].getStoppedSymbol();
		}
		
		int gain=bhvr_Rules.determineGain(results, this.countLockedWheels(),this);
		if(this.pactole<gain) {
			gain=this.pactole;
			this.pactole=0;
			return gain;
		}
		else {		
			this.pactole-=gain;
			return gain;
		}
	}
	
	/**
	 * 
	 * @return a String representation of the symbol currently stopped on all the wheels
	 * Could be used to be interpreted char by char by a View Module for example
	 */
	public String getStringOfWheels() {
		String status = new String();
		for(int i=0;i<arr_Wheel.length;i++) {
			status+=arr_Wheel[i].getStoppedSymbol().symbol;
		}
		return status;
	}
	
	
	/**
	 * 
	 * @return the number of locked wheels
	 */
	private int countLockedWheels() {
		int lockedWheels=0;
		for(int i=0;i<locked.length;i++) {
			if(locked[i]) {
				lockedWheels++;
			}			
		}
		return lockedWheels;
	}
	
	
	
	

	/**
	 * @return the arrWheel
	 */
	public Ab_Roulette[] getArrWheel() {
		return arr_Wheel;
	}

	/**
	 * @param arrWheel the arrWheel to set
	 */
	public void setArrWheel(Ab_Roulette[] arrWheel) {
		this.arr_Wheel = arrWheel;
	}
	
	public void lockWheel(int index) {
		if(this.countLockedWheels()<this.arr_Wheel.length-1) {
			this.locked[index]=true;
		}
	}
	
	public void unlockWheel(int index) {
		this.locked[index]=false;
	}

	public MachineManchot(Ab_Roulette[] wheels,I_RulesGainWheel rules,int cost,int pactole) {
		super(cost);
		this.bhvr_Rules=rules;
		this.arr_Wheel=wheels;
		this.locked=new boolean[wheels.length];
		for(int i=0;i<locked.length;i++) {
			locked[i]=false;
		}
		this.pactole=pactole;
	}
	
	


}
