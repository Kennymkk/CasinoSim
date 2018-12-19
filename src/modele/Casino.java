package modele;

import java.util.ArrayList;

import modele.comportements.Bhvr_PlayManchotClassic;
import modele.comportements.I_PlayManchot;

/**
 * Class of a casino
 * Contain a loop where the players could swap machines if empty were found (not tested) and a loop where all players play
 * For the purpose of presentation incoming, it also contain the display
 * @author Kenny
 *
 */
public class Casino {

	private ArrayList<Player> arr_Players;
	private ArrayList<Ab_Machine> arr_Machine;
	
	/**
	 * 
	 * @param arr_Players
	 * @param arr_Machine
	 */
	public Casino(ArrayList<Player> arr_Players,ArrayList<Ab_Machine> arr_Machine) {
		this.arr_Machine=arr_Machine;
		this.arr_Players=arr_Players;
	}
	
	/**
	 * Loop giving the players the opportunity to change machines
	 */
	private void playersChangeMachine() {
		for(int i=0;i<arr_Players.size();i++) {
			arr_Players.get(i).changeMachine(this.arr_Machine);
		}
	}
	
	/**
	 * Loop of play
	 */
	private void playersPlay() {
		Ab_Machine mach;
		
		int gain=0;
		int previousGain[]=new int[10];
		
		for(int i=0;i<arr_Players.size();i++) {
			Player loopPlayer=arr_Players.get(i);
			mach=loopPlayer.getCurrentMachine();
			
			previousGain[i]=loopPlayer.getStockJeton();
			
			if(mach!=null) {
				Class class_machine=mach.getClass();
				if(loopPlayer.playerCanPlayOnCurrentMachine()) {
					if(class_machine==MachineManchot.class) {
										
						//TODO implements some kind of relation table of needed implemented interfaces to play certains machines
						
						//We look into the players 'canPlay' catalog to pick up the particular behavior needed for this machine
						//Since we called playerCanPlayOnCurrentMachine earlier, the player should have such object
						I_PlayManchot behavior= (I_PlayManchot) loopPlayer.getImplementedInterfaces().get(I_PlayManchot.class);						
						
						//Next statement do the play!
						gain=loopPlayer.play(mach.getCost(), behavior.playManchot((MachineManchot)mach));
					}
					//else if(...
				}
			}
			
			//TEMPORARY DISPLAY
			//TODO A real MV program
			MachineManchot castedMach=(MachineManchot) mach;
			System.out.println("Player with id "+loopPlayer.getId() +" has rolled :");
			System.out.println(castedMach.getStringOfWheels());
			System.out.println("he gained :" +gain+"since he previously had " + previousGain[i]+"he now have "+loopPlayer.getStockJeton());
			System.out.println();
		}
	}

	/**
	 * Main loop
	 */
	public void doIteration() {
		playersChangeMachine();
		playersPlay();
	}
	
	
	
}
