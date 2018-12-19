package modele.comportements;

import modele.MachineManchot;

/**
 * A behavior interface for the players who should be able to play manchot
 * @author Kenny
 *
 */
public interface I_PlayManchot extends I_PlayAMachine {

	public void play(int index);
	public int playManchot(MachineManchot mach); //play one time
}
