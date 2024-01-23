import java.awt.Color;

public class ColorDemo {
	public static void main(String[] args) {
		// fofo();
		Color black = new Color(0, 0, 0);
		Color white = new Color(255, 255, 255);
		Color[][] image = {
				{ black, white, black, white },
				{ white, black, white, black },
				{ black, white, black, white },
				{ white, black, white, black },
		};
		setCanvas(image);
		StdDraw.show();
	}

	public static void fofo() {
		Color red = new Color(255, 0, 0);
		Color black = new Color(0, 0, 0);
		Color white = new Color(255, 255, 255);
		Color yellow = new Color(255, 255, 0);
		System.out.println("RGB values of yellow:");
		System.out.println("R = " + yellow.getRed()); // prints 255
		System.out.println("G = " + yellow.getGreen()); // prints 255
		System.out.println("B = " + yellow.getBlue()); // prints 0
		System.out.print("Red = ");
		print(red);
		System.out.println();
		Color[] arr = { black, white, black, white };
		Color[] arr2 = { new Color(0, 0, 0), new Color(255, 255, 255), new Color(255, 255, 255), new Color(0, 0, 0) };
		Color[][] arr3 = {
				{ black, white, black, white },
				{ white, black, white, black },
				{ black, white, black, white },
				{ white, black, white, black },
		};
		for (int i = 0; i < arr.length; i++) {
			print(arr[i]);
		}
		System.out.println();
		print(black);
	}

	public static void print(Color c) {
		System.out.print("(");
		System.out.printf("%3s,", c.getRed()); // Prints the red component
		System.out.printf("%3s,", c.getGreen()); // Prints the green component
		System.out.printf("%3s", c.getBlue()); // Prints the blue component
		System.out.print(")  ");
	}

	public static void setCanvas(Color[][] image) {
		StdDraw.setTitle("Runigram 2023");
		int height = image.length + 600;
		int width = image[0].length + 600;
		StdDraw.setCanvasSize(height, width);
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(0, height);
		StdDraw.enableDoubleBuffering();
	}
}