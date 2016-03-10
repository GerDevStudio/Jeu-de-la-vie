
public class Cell {

	private int x;
	private int y;
	private boolean isAlive;
	private boolean willBeAlive;

	// Constructor
	public Cell(int x, int y, boolean isAlive) {
		super();
		this.x = x;
		this.y = y;
		this.isAlive = isAlive;
		this.willBeAlive = false;
	}

	// Getters
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isAlive() {
		return isAlive;
	}

	// Public methods
	public void willLive() {
		this.willBeAlive = true;
	}

	public void willDie() {
		this.willBeAlive = false;
	}
	
	public void evolves()
	{
		this.isAlive=this.willBeAlive;
		this.willBeAlive=false;
	}

}
