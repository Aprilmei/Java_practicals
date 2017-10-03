
import javax.swing.JOptionPane;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name;
		name = JOptionPane.showInputDialog(null, "What's your name");
		JOptionPane.showMessageDialog(null, "Hello, " + name);
		System.exit(0);

	}

}
