package chapter_3;

public class Triangle {

	private int width;

	public Triangle(int aWidth) {
		width = aWidth;

	}

	public String toString() {
		String r = "";
		for (int i = 1; i <= width; i++) {
			for (int j = 1; j <= i; j++)
				r = r + "[]";
			r = r + "\n";
		}
		return r;
	}

}
