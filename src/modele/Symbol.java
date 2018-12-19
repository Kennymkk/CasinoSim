package modele;

/**
 * Since this class is rather a structure than a class, we keep the fields on public protection
 * After thought, it's a bad idea tho, because if we want to implement internal function and setup getters&setters, we will have to replace every reference to them.
 * @author Kenny
 *
 */
public class Symbol {
	public float probability;
	public String symbol;
	public int value;
}
