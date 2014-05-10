package combat.field;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Main {

	public static void main(String[] args) {
		
		try {
			
			JFrame frame = new JFrame();
			frame.setResizable(false);
			frame.setBounds(100, 100, 1024, 710);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			JPanel panelBattlefield = new JPanel();
			panelBattlefield.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			panelBattlefield.setBounds(387, 12, 612, 612);
			panelBattlefield.setLayout(null);
			frame.getContentPane().add(panelBattlefield);
			
			MapGrid mapGrid = new MapGrid();
			mapGrid.setBounds(10, 10, 600, 600);
			panelBattlefield.add(mapGrid);
			
			frame.setVisible(true);
			
			synchronized (mapGrid) {
				
				// Test player movement
				for (int i = 1; i <= 10; i++) {
					for (int j = 1; j <= 10; j++) {
						mapGrid.movePlayer(i, j);
						mapGrid.wait(1000);
					}
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
