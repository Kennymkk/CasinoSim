package modele;

import java.util.ArrayList;
import java.util.HashMap;

import modele.comportements.I_ChangeMachine;
import modele.comportements.I_PlayManchot;
import modele.comportements.I_PlayAMachine;

public class Player {

	protected int stockJeton;
	protected int stockJetonInitial;
	protected int id;
	protected Ab_Machine currentMachine;
	
	protected HashMap<Class,I_PlayAMachine> implementedInterfaces; //First one is the implemented interface, 2nd one is the concrete behavior class
	//private Machine machineActuelle;
	public I_ChangeMachine comp_changeMach;
	public I_PlayAMachine [] arrComp_play;
	
	public void changeMachine(ArrayList<Ab_Machine> arr_Machine) {
		this.comp_changeMach.changeMachine();
	}
	
	public Ab_Machine getCurrentMachine() {
		return currentMachine;
	}
	
	private void initializeImplementedInterfaces() {
		implementedInterfaces=new HashMap<Class,Boolean> ();
		Class [] arr_Interfaces =this.getClass().getInterfaces();
		
		for(int i=0;i<arr_Interfaces.length;i++) {
			implementedInterfaces.put(arr_Interfaces[i].getClass(), true);
		}
		
	}
	
	
	
	/**
	 * @return the implementedInterfaces
	 */
	public HashMap<Class, I_PlayAMachine> getImplementedInterfaces() {
		return implementedInterfaces;
	}

	/**
	 * @param implementedInterfaces the implementedInterfaces to set
	 */
	public void setImplementedInterfaces(HashMap<Class, I_PlayAMachine> implementedInterfaces) {
		this.implementedInterfaces = implementedInterfaces;
	}

	public Player(int stockJetonInitial,int id,I_PlayAMachine[] arrComp_play) {
		this.stockJetonInitial=stockJetonInitial;
		this.stockJeton=stockJetonInitial;
		this.id=id;
		this.arrComp_play=arrComp_play;
		initializeImplementedInterfaces();
	}
	
	public void play (int cost,int gain) {
		
	}
	
}
