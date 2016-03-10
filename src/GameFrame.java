import javax.swing.JFrame;

public class GameFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	// the gameFrame needs a matrix as argument
	public GameFrame(Matrix matrix) {
		super("Jeu de la vie");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.NORMAL);
	
		// Create Jpanel containings black squares, representing living cells.
		SquaresPanel squares = new SquaresPanel(matrix);
		getContentPane().add(squares);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void refresh() {
		getContentPane().repaint();
	}
}