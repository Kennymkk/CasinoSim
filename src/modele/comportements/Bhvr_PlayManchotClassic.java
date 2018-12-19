package modele.comportements;

import modele.MachineManchot;
import modele.Symbol;

import java.util.HashMap;

import modele.Ab_Roulette;
import modele.GeneralPurpose;
/**
 * 
 * @author Kenny
 * Simple implementation of playManchot Behavior
 */
public class Bhvr_PlayManchotClassic implements I_PlayManchot{

	@Override
	public void play(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * The behavior is like this : if more than half of the slot got the same symbol, the player tries to lock them
	 * @param mach
	 */	
	public int playManchot(MachineManchot mach) {
		Ab_Roulette [] arr_Wheel=mach.getArrWheel();
		//We assume here that all the roulette got the same symbols!
		HashMap<String,Integer> symbolMap = new HashMap();
		Symbol [] arr_symbols;
		for(int i=0;i<arr_Wheel.length;i++) {
			Symbol stoppedSymbol=arr_Wheel[i].getStoppedSymbol();
			
			//Counting the numbers of occurences of symbols
			if(symbolMap.containsKey(stoppedSymbol.symbol)) {
				symbolMap.put(stoppedSymbol.symbol, symbolMap.get(stoppedSymbol.symbol)+1);
			}
			else {
				symbolMap.put(stoppedSymbol.symbol, 1);
			}
		}
		
		String maxSymbol=GeneralPurpose.getMaxOfParamHashMap(symbolMap);
		for(int i=0;i<arr_Wheel.length;i++) {
			if(arr_Wheel[i].getStoppedSymbol().symbol==maxSymbol) {
				mach.lockWheel(i);
			}
		}
		
		return mach.play();
		
	}

}
