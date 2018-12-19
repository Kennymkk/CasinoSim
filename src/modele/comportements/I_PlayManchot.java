package modele.comportements;

import modele.MachineManchot;

/**
 * A behavior class for the players who should be able to play manchot
 * @author Kenny
 *
 */
public interface I_PlayManchot extends I_PlayAMachine {

	public void verrouiller(int index);
	public int jouerManchot(MachineManchot mach); //play one time
}
