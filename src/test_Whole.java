import java.util.ArrayList;
import java.util.HashMap;

import modele.Ab_Machine;
import modele.Casino;
import modele.MachineManchot;
import modele.Player;
import modele.Wheel;
import modele.comportements.Bhvr_ChangeMachineClassic;
import modele.comportements.Bhvr_ClassicGainWheel;
import modele.comportements.Bhvr_FullGainWheel;
import modele.comportements.Bhvr_PlayManchotClassic;
import modele.comportements.I_PlayAMachine;

public class test_Whole {
	public static void main(String[] args) throws Exception {
		
		HashMap<String,HashMap<String,Float>> map_wheelModel=createWheelModel();
		
		ArrayList<Player> arrL_player=createPlayers();
		ArrayList<Ab_Machine> arrL_mach=createMachines(map_wheelModel);
		
		Casino casino=new Casino(arrL_player, arrL_mach);
		
		for(int i=0;i<10;i++) {
			casino.doIteration();
		}
	}
	
	public static ArrayList<Player> createPlayers(){
		
		Bhvr_PlayManchotClassic bhvr_manchot=new Bhvr_PlayManchotClassic();
		I_PlayAMachine [] arr_behavior=new I_PlayAMachine [1];
		Bhvr_ChangeMachineClassic bhvr_changeMachine=new Bhvr_ChangeMachineClassic();
		
		
		arr_behavior[0]=bhvr_manchot;
		ArrayList<Player> arrL_player=new ArrayList<Player>();
		for(int i=0;i<3;i++) {
			arrL_player.add(new Player((i+1)*10,i,arr_behavior, bhvr_changeMachine));
		}
		
		return arrL_player;
	}
	
	public static ArrayList<Ab_Machine> createMachines(HashMap<String,HashMap<String,Float>> map_wheelModel) throws Exception {
		ArrayList<Ab_Machine> arrL_mach=new ArrayList<Ab_Machine>();
		Wheel[] arr_wheels;
		
		//Switch comments to alternate between different gain methods
		
		Bhvr_ClassicGainWheel rules=new Bhvr_ClassicGainWheel();
		//Bhvr_FullGainWheel rules=new Bhvr_FullGainWheel();
		
		
		for(int i=0;i<3;i++) {
			arr_wheels=test_Whole.createWheelObject(map_wheelModel);
			arrL_mach.add(new MachineManchot(arr_wheels,rules,i+1,500));
		}
		
		return arrL_mach;
	}
	
	public static HashMap<String,HashMap<String,Float>> createWheelModel() {
		HashMap<String,HashMap<String,Float>> map_wheelModel = new HashMap<String,HashMap<String,Float>>();
		String [] a= {"a","b","c","d","e"};
		
		for(int i=1;i<=4;i++) {
			HashMap<String,Float> test=new HashMap<String,Float>();
			test.put("probability", (float) (0.1* (float) i));
			test.put("value", (float) (10*i));
			
			map_wheelModel.put(a[i],test);
		}
		
		return map_wheelModel;
	}
	
	public static Wheel[] createWheelObject(HashMap<String,HashMap<String,Float>> map_WheelModel) throws Exception {
		Wheel[] arr_wheels = new Wheel[3];
		
		for(int i=0;i<3;i++) {
			arr_wheels[i] =new Wheel(map_WheelModel);
		}
		
		return arr_wheels;
	}
	
}
