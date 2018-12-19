package modele;

import java.util.ArrayList;
import java.util.HashMap;

import modele.comportements.I_ChangeMachine;
import modele.comportements.I_PlayManchot;
import modele.comportements.I_PlayAMachine;

public class Player {

	protected int stockToken;
	protected int stockTokenInitial;
	protected int id;
	protected Ab_Machine currentMachine;
	
	protected HashMap<Class,I_PlayAMachine> implementedInterfaces; //First one is the implemented interface, 2nd one is the concrete behavior class
	//private Machine machineActuelle;
	public I_ChangeMachine bhvr_changeMach;
	
	public void changeMachine(ArrayList<Ab_Machine> arr_Machine) {
		currentMachine=this.bhvr_changeMach.changeMachine(arr_Machine);
	}
	
	public Ab_Machine getCurrentMachine() {
		return currentMachine;
	}
	
	/**
	 * 
	 * @param arrComp_play
	 */
	private void initializeImplementedInterfaces(I_PlayAMachine[] arrComp_play) {
		implementedInterfaces=new HashMap<Class,I_PlayAMachine> ();
		
		for(int i=0;i<arrComp_play.length;i++) {
			//For example, will create a entry K => I_PlayManchot V => Bhvr_PlayManchotClassic object
			Class [] classArr_implementedInterfaces=arrComp_play[i].getClass().getInterfaces();
			if(classArr_implementedInterfaces.length>1) {
				System.err.println("A implementation of play behavior should implement only one play behavior interface");
			}
			Class superClass=classArr_implementedInterfaces[0];
			//The idea was to use .getSuperClass() but it does'nt work with interfaces extending interfaces. 
			/*
			Class [] classArr_superClass=classArr_implementedInterfaces[0].getInterfaces();
			if(classArr_superClass.length>1) {
				System.err.println("A extension of play behavior should extends or implement only one play behavior interface");
			}
			*/
			
			implementedInterfaces.put(superClass, arrComp_play[i]);
		}
		
	}
	
	public boolean playerCanPlayOnCurrentMachine() {
		if(stockToken>=currentMachine.getCost()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the stockJeton
	 */
	public int getStockJeton() {
		return stockToken;
	}

	/**
	 * @param stockJeton the stockJeton to set
	 */
	public void setStockJeton(int stockJeton) {
		this.stockToken = stockJeton;
	}

	/**
	 * @return the stockJetonInitial
	 */
	public int getStockJetonInitial() {
		return stockTokenInitial;
	}

	/**
	 * @param stockJetonInitial the stockJetonInitial to set
	 */
	public void setStockJetonInitial(int stockJetonInitial) {
		this.stockTokenInitial = stockJetonInitial;
	}

	/**
	 * @return the implementedInterfaces
	 */
	public HashMap<Class, I_PlayAMachine> getImplementedInterfaces() {
		return implementedInterfaces;
	}

	/**
	 * 
	 * @param implementedInterfaces the implementedInterfaces to set
	 */
	public void setImplementedInterfaces(HashMap<Class, I_PlayAMachine> implementedInterfaces) {
		this.implementedInterfaces = implementedInterfaces;
	}

	public Player(int stockJetonInitial,int id,I_PlayAMachine[] arrBhvr_play,I_ChangeMachine bhvr_changeMachine) {
		this.stockTokenInitial=stockJetonInitial;
		this.stockToken=stockJetonInitial;
		this.id=id;
		this.bhvr_changeMach=bhvr_changeMachine;
		initializeImplementedInterfaces(arrBhvr_play);
	}
	
	/**
	 * @param gain
	 */
	public int play (int cost,int gain) {
		this.stockToken-=cost;
		this.stockToken+=gain;
		return gain;
	}
	
}
