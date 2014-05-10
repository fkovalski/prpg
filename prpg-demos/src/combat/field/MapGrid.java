package combat.field;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

public class MapGrid extends Component {

	private static final long serialVersionUID = 1L;

	private static final int COORD_INCREMENT = 60;
	private static final int COORD_INIT = 5;

	Graphics2D g2;

	public int playerPosX = 1;
	public int playerPosY = 1;

	public void paint(Graphics g) {

		g2 = (Graphics2D) g;

		Image field = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/field.jpg"));
		g2.drawImage(field, 0, 0, 600, 600, this);
		g2.setPaint(Color.WHITE);

		// Draw the horizontal lines
		for (int i = 0; i <= 10; i++) {
			g.drawLine(0, i * 60, 600, i * 60);
		}

		// Draw the vertical lines
		for (int i = 0; i <= 10; i++) {
			g.drawLine(i * 60, 0, i * 60, 600);
		}

		drawPlayers();

		g2.finalize();

	}

	private void drawPlayers() {

		Image player = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/knight.jpg"));
		g2.drawImage(player, positionToCoordinate(playerPosX), positionToCoordinate(playerPosY), 50, 50, this);

	}

	public void movePlayer(int posX, int posY) throws InterruptedException {
		playerPosX = posX;
		playerPosY = posY;
		repaint();
	}

	private int positionToCoordinate(int pos) {

		if (pos < 1) {
			return positionToCoordinate(1);
		} else if (pos > 10) {
			return positionToCoordinate(10);
		}

		return ((pos - 1) * COORD_INCREMENT) + COORD_INIT;
	}

}
