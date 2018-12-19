package modele;


import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Implementation of a roulette
 * The current initialization randomization only work with 100 symbols max
 * Beyond that point the game will work but there is no chance the symbols ordered after the 100th get a starting place
 * @author Kenny
 *
 */
public final class Wheel extends Ab_Roulette {

	
	@Override
	/**
	 * The function will randomize the current stopped symbol
	 * the symbols are ordered by probability, which is stacked (if 1st have a 0.1 probability and the 2nd 0.2, then the Symbol[1] will have 
	 * a probability of 0.3) this allow us to get a random symbols according to their original probability and without too much hassle.
	 */
	public void randomizeSymbol() {
		float random= (float) Math.random();
		for(int i=0;i<symbols.length;i++) {
			if(symbols[i].probability>=random) {
				this.stopIndex=i;
				break;
			}
		}
		
	}
	
	/**
	 * return the currently stopped symbol
	 */
	public Symbol getStoppedSymbol() {
		return symbols[stopIndex];
	}
	
	/**
	 * 
	 * @return the list of symbols
	 */
	public Symbol [] getSymbols() {
		return this.symbols;
	}
		
	/**
	 * 
	 * Will build a wheel from the HashMap
	 * 
	 * @param symbo_proba K represent the symbol, V should had 2 K-V, "probability", and "value" 
	 * "probability" should represent the probability to get the current symbol, the constructor will then build the array of symbols
	 * BUT the different probability will stack on each cell of the array, to perform the a randomGet on those symbols according to 
	 * the given probabilities
	 * 
	 * After thought, it's a bad idea, we should rather have done the "stacking" in the randomizeWheels function, because the way it is, it's harder to get the probability to obtain a symbol
	 * 
	 * @throws Exception 
	 */
	public Wheel(HashMap<String,HashMap<String,Float>> map_data ) throws Exception {		
		
		float currentProbaStack=0;
		int i=0;	
		int wheelSize=map_data.size();
		
		this.symbols=new Symbol[wheelSize];
		
		//This loop will create the probability value to work with the current randomize mechanism and set others values
		for(Entry<String,HashMap<String,Float>> entry : map_data.entrySet()) {
			this.symbols[i]=new Symbol();
			
			currentProbaStack+=entry.getValue().get("probability");
			this.symbols[i].probability=currentProbaStack;
			this.symbols[i].symbol=entry.getKey();
			Float value=entry.getValue().get("value");
			if(value%1!=0) {
				System.err.println("Not int symbol value :" +value +" detected, the value will be cut and casted into a int");
			}
			this.symbols[i].value=entry.getValue().get("value").intValue();
			i++;					
	    }
		//Meaning the sum of probabilities does'nt equals 100%, meaning wrong settings
		if(currentProbaStack<1-PRECISION||currentProbaStack>1+PRECISION) {
			throw new Exception("Uncorrect probabilities settings, check if the suml equals one,else call the hotline");
		}
		
		//We now randomize the starting index
		this.randomizeSymbol();
	}
	
}
