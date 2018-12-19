package modele;


/**
 * Abstract class representing a machine, could potentially be extented to be any type of money machine
 * @author Kenny
 *
 */
public abstract class Ab_Machine {

	protected int pactole; // Current total value of token in the machine
	protected int id;
	protected int cost; // the cost of a game
	private Player currentPlayer;
	
	
	public abstract int play();
	
	/**
	 * @return the pactole
	 */
	public int getPactole() {
		return pactole;
	}

	/**
	 * @param pactole the pactole to set
	 */
	public void setPactole(int pactole) {
		this.pactole = pactole;
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
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	/**
	 * @return the currentPlayer
	 */
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * @param currentPlayer the currentPlayer to set
	 */
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	
	/**
	 * 
	 * @param cost
	 */
	public Ab_Machine(int cost) {
		this.cost=cost;
	}

	
}
