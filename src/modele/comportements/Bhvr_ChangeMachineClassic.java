package modele.comportements;

import java.util.ArrayList;

import modele.Ab_Machine;

/**
 * Simple implementation of a changeMachine behavior
 * @author Kenny
 *
 */
public class Bhvr_ChangeMachineClassic implements I_ChangeMachine{
	
	/**
	 * As soon as the player see a machine is empty. (Grass is greener on the other side)
	 */
	public Ab_Machine changeMachine(ArrayList<Ab_Machine> arr_mach) {
		for(int i=0;i<arr_mach.size();i++) {
			if(arr_mach.get(i).getCurrentPlayer()==null) {
				return arr_mach.get(i);
			}
		}
		
		return null;
	};
}
