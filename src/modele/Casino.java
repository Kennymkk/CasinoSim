package modele;

import java.util.ArrayList;

import modele.comportements.Bhvr_JouerManchotClassic;
import modele.comportements.I_PlayManchot;

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
	
	private void playersChangeMachine() {
		for(int i=0;i<arr_Players.size();i++) {
			arr_Players.get(i).changeMachine(this.arr_Machine);
		}
	}
	
	private void playersPlay() {
		Ab_Machine mach;
		for(int i=0;i<arr_Players.size();i++) {
			
			Player loopPlayer=arr_Players.get(i);
			mach=loopPlayer.getCurrentMachine();
			
			if(mach!=null) {
				Class class_machine=mach.getClass();
				if(loopPlayer.playerCanPlayOnCurrentMachine()) {
					if(class_machine==MachineManchot.class) {
						
						//We are getting : the type of interface we need to seek into the player playInterface catalog; by : giving the Class to relation
						Constants.getRelation().get(class_machine);
						
						I_PlayManchot behavior= (I_PlayManchot) loopPlayer.getImplementedInterfaces().get(I_PlayManchot.class);						
						
						//Next statement do the play!
						loopPlayer.play(mach.getCost(), behavior.jouerManchot((MachineManchot)mach));
					}
					//else if(...
				}
			}
			
			//TEMPORARY DISPLAY
			MachineManchot castedMach=(MachineManchot) mach;
			System.out.println("Player with id"+loopPlayer.getId() +"has rolled :");
			System.out.println(castedMach.getStringOfWheels());
		}
	}
	
	public void doIteration() {
		playersChangeMachine();
		playersPlay();
	}
	
	
	
}
