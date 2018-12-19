package modele.comportements;

import java.util.ArrayList;

import modele.Ab_Machine;

/**
 * A behavior class used to determine if a player will/should change machine
 * @author Kenny
 *
 */
public interface I_ChangeMachine {
	public Ab_Machine changeMachine(ArrayList<Ab_Machine> arr_mach);
}
