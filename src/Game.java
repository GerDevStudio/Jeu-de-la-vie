public class Game {

	private final static int SIMULATOR_WIDTH = 250;
	private final static int SIMULATOR_HEIGHT = 250;

	public static void main(String[] args) {

		// Création matrice
		Matrix matrix = new Matrix(SIMULATOR_WIDTH, SIMULATOR_HEIGHT);

		GameFrame frame = new GameFrame(matrix);
		
		while (true) {

			// refresh screen
			frame.refresh();
			
			matrix.evolves();

			// 20 refresh per second
			wait(50);
		}
	}

	private static void wait(int milliseconds) {

		try {
			Thread.sleep(milliseconds); // 1000 milliseconds is one second.
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

}
