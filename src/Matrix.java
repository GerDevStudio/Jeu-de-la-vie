import java.awt.Dimension;
import java.util.Random;

public class Matrix {

	private int largeur;
	private int hauteur;
	private Cell[][] grille;

	// Constructor
	public Matrix(int largeur, int hauteur) {
		super();

		grille = new Cell[largeur][hauteur];
		this.largeur = largeur;
		this.hauteur = hauteur;

		this.initializes(largeur, hauteur);
	}

	// Getters and setters
	public Cell[][] getGrille() {
		return grille;
	}
	
	public Dimension getDimension(){
		return new Dimension(largeur,hauteur);
	}

	public void setGrille(Cell[][] grilleCourante) {
		this.grille = grilleCourante;
	}

	// Public methods

	// Create cells for the grid
	public void initializes(int largeur, int hauteur) {

		// Create random matrix
		Random random = new Random();

		for (int x = 0; x < largeur; x++) {
			for (int y = 0; y < hauteur; y++) {

				grille[x][y] = new Cell(x, y, random.nextBoolean());
			}
		}
	}

	// si une cellule 2 voisins elle ne change pas d'état
	// si elle a trois voisins elle vit
	// sinon elle meurt;
	public void evolves() {
		// on parcourt les cellules 1 a 1 et on calcule leur futur etat
		for (Cell[] line : grille) {
			for (Cell currentCell : line) {
				int neighbours = numberOfLivingNeighbours(currentCell);
				switch (neighbours) {
				case 2:
					if (currentCell.isAlive()) {
						currentCell.willLive();
					} else {
						currentCell.willDie();
					}
					break;
				case 3:
					currentCell.willLive();
					break;
				default:
					currentCell.willDie();
				}
			}
		}

		// on fait évoluer toutes les cellules
		for (Cell[] line : grille) {
			for (Cell currentCell : line) {
				currentCell.evolves();
			}
		}
	}

	// on calcule le nombre de voisins de chaque cellule
	// en faisant les calculs selon la prochaine grille
	public int numberOfLivingNeighbours(Cell c) {

		int result = 0;

		int x = c.getX();
		int y = c.getY();

		// cellule à gauche
		if (x > 0) {
			result += grille[x - 1][y].isAlive() ? 1 : 0;
		}

		// cellule en haut à gauche
		if (x > 0 && y > 0) {
			result += grille[x - 1][y - 1].isAlive() ? 1 : 0;
		}

		// cellule en haut
		if (y > 0) {
			result += grille[x][y - 1].isAlive() ? 1 : 0;
		}

		// cellule en haut a droite
		if (x < largeur - 1 && y > 0) {
			result += grille[x + 1][y - 1].isAlive() ? 1 : 0;
		}

		// cellule a droite
		if (x < largeur - 1) {
			result += grille[x + 1][y].isAlive() ? 1 : 0;
		}

		// cellule en bas a droite
		if (x < largeur - 1 && y < hauteur - 1) {
			result += grille[x + 1][y + 1].isAlive() ? 1 : 0;
		}

		// cellule en bas
		if (y < hauteur - 1) {
			result += grille[x][y + 1].isAlive() ? 1 : 0;
		}

		// cellule en bas a gauche
		if (y < hauteur - 1 && x > 0) {
			result += grille[x - 1][y + 1].isAlive() ? 1 : 0;
		}

		return result;
	}

	@Override
	// 
	public String toString() {

		StringBuilder builder = new StringBuilder();

		for (int y = 0; y < hauteur; y++) {
			for (int x = 0; x < largeur; x++) {

				Cell cell = grille[x][y];

				// X is alive cell, . is dead cell
				builder.append((cell.isAlive()) ? "X" : ".");
			}
			if (y != hauteur - 1) {
				builder.append(System.lineSeparator());
			}
		}

		return builder.toString();
	}

}
