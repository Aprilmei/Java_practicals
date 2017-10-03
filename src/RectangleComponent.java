import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class RectangleComponent extends JComponent {

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		Ellipse2D.Double ellipse = new Ellipse2D.Double(5, 10, 100, 150);
		g2.draw(ellipse);

		Rectangle box = new Rectangle(25, 70, 15, 15);
		g2.setColor(Color.GREEN);
		g2.fill(box);
		box.translate(50, 0);
		g2.fill(box);

		g2.setColor(Color.RED);
		Line2D.Double segment = new Line2D.Double(30, 110, 80, 110);
		g2.draw(segment);

		g2.setColor(Color.BLUE);
		g2.drawString("Hello Dan", 5, 200);

		// Color magenta = new Color();

	}
}
