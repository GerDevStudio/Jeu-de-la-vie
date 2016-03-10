import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;

//contains squares to be displayed, representing the matrix
class SquaresPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private static final int CELL_WIDTH_IN_PIXELS = 3;
	private static final int CELL_HEIGTH_IN_PIXELS = CELL_WIDTH_IN_PIXELS;

	private Matrix matrix;

	// Constructors
	public SquaresPanel() {
		super();
		this.matrix = new Matrix(0, 0);
	}

	public SquaresPanel(Matrix matrix) {
		super();
		this.matrix = matrix;
	}

	public Rectangle getSquare(int x, int y) {
		Rectangle rect = new Rectangle(x * CELL_WIDTH_IN_PIXELS, y * CELL_HEIGTH_IN_PIXELS, CELL_WIDTH_IN_PIXELS,
				CELL_HEIGTH_IN_PIXELS);
		return rect;
	}

	@Override
	public Dimension getPreferredSize() {
		Dimension dimension = matrix.getDimension();
		return new Dimension(dimension.width * CELL_WIDTH_IN_PIXELS, dimension.height * CELL_HEIGTH_IN_PIXELS);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		// on parcourt les cellules de la matrixe
		for (int x = 0; x < matrix.getDimension().getWidth() - 1; x++) {
			{
				for (int y = 0; y < matrix.getDimension().getHeight() - 1; y++) {

					// si la cellule positionnée à (x,y) est vivante, on la dessine
					if (matrix.getGrille()[x][y].isAlive()) {
						g2.fill(getSquare(x, y));
					}
				}
			}
		}
	}
}