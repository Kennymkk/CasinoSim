package modele;

import java.util.ArrayList;

import modele.comportements.Comp_JouerManchotClassic;

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
			
			mach=arr_Players.get(i).getCurrentMachine();
			Class class_machine=mach.getClass();
			
			if(class_machine==MachineManchot.class) {
				Comp_JouerManchotClassic behavior= (Comp_JouerManchotClassic) arr_Players.get(i).getImplementedInterfaces().get(class_machine);
				//TODO set price as a machine component
				arr_Players.get(i).play(1, behavior.jouerManchot((MachineManchot)mach));
			}
			
		}
	}
	
	public void doIteration() {
		playersChangeMachine();
		playersPlay();
	}
	
}
