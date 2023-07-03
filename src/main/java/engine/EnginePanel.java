package engine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import engine.inputs.KeyboardInputs;
import engine.inputs.MouseInputs;

public class EnginePanel extends JPanel {

	private MouseInputs mouseInputs;
	private Engine engine;

	public EnginePanel(Engine engine) {
		mouseInputs = new MouseInputs(this);
		this.engine = engine;

		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);

	}

	private void setPanelSize() {
		Dimension size = new Dimension(1280, 800);
		setPreferredSize(size);
	}

	public void updateGame() {

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.white);
		for (int i = 0; i < 64; i++)
			for (int j = 0; j < 40; j++)
				g.fillRect(i * 20, j * 20, 20, 20);

		engine.render(g);

	}

	public Engine getGame() {
		return engine;
	}

}