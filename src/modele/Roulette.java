package modele;


import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

public final class Roulette extends Ab_Roulette {

	private int stopIndex;
	private final float PRECISION=0.001f; //used manly as a delta to ensure the stacked probabilities are around 1;
	private Symbol [] symbols;
	
	@Override
	/**
	 * The function 
	 */
	public void randomizeSymbol() {
		float random= (float) Math.random();
		for(int i=0;i<symbols.length;i++) {
			if(symbols[i].probability>=random) {
				this.stopIndex=i;
			}
		}
		
	}
	
	public Symbol getStoppedSymbol() {
		return symbols[stopIndex];
	}
		
	/**
	 * 
	 * @param symbo_proba K represent the symbol, V should be a 2 cell array, 
	 * @throws Exception 
	 */
	public Roulette(HashMap<String,HashMap<String,Float>> map_data ) throws Exception {		
		
		float currentProbaStack=0;
		int i=0;	
		int wheelSize=map_data.size();
		
		this.symbols=new Symbol[wheelSize];
		//Update the value to work with the current randomize mechanism
		for(Entry<String,HashMap<String,Float>> entry : map_data.entrySet()) {
			this.symbols[i]=new Symbol();
			
			currentProbaStack+=entry.getValue().get("probability");
			this.symbols[i].probability=currentProbaStack;
			this.symbols[i].symbol=entry.getKey();
			this.symbols[i].value=entry.getValue().get("value").intValue();
			i++;					
	    }
		//Meaning the sum of probabilities does'nt equals 100%, meaning wrong settings
		if(currentProbaStack<1-PRECISION||currentProbaStack>1+PRECISION) {
			throw new Exception("Uncorrect probabilities settings, check if the suml equals one,else call the hotline");
		}		
	}
	
}
