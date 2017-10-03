
import java.awt.Rectangle;

import javax.swing.JFrame;
// import packageName.className

public class Testing {

	public static final int DANDAD = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Daniel");

		Rectangle box = new Rectangle(5, 10, 20, 30);

		System.out.printf("The box detail is " + box);
		System.out.print("\nThe width of box is " + box.getWidth());
		box.translate(5, 0);
		System.out.print("\nThe X of box is " + box.getX());
		System.out.print("\n Expected is 10 ");

		JFrame frame = new JFrame();
		frame.setSize(150, 250);
		frame.setTitle("An Alien Face ");

		RectangleComponent component = new RectangleComponent();
		frame.add(component);

		frame.setVisible(true);
		System.out.println("Hello");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// appletviewer RectangleApplet.html

		// System.exit(0);
	}

}
