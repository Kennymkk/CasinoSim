package modele;
/**
 * Abstract class of a wheel
 * @author Kenny
 *
 */
public abstract class Ab_Roulette {

	protected int stopIndex;
	protected final float PRECISION=0.001f; //used manly as a delta to ensure the stacked probabilities are around 1;
	protected Symbol [] symbols;
	
	public abstract void randomizeSymbol();
	public abstract Symbol getStoppedSymbol();
	
	
}
