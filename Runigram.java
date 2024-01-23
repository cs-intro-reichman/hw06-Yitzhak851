
/**
 * This class provides several methods for manipulating
 * two-dimensional arrays of Color objects.
 * @author - Yitzhak Bar or
 * @version - 23/01/2024
 */

import java.awt.Color;

public class Runigram {
	public static void main(String[] args) {
		Color[][] tinypic = read("tinypic.ppm");
		setCanvas(tinypic);
		print(tinypic);
		System.out.println("================== Do some cool flip =====================");
		Color[][] imageOut = flippedHorizontally(tinypic);
		print(imageOut);
	}

	/**
	 * Reads the image data from the given file,
	 * and returns a 2D array of Color values, representing the image data.
	 * 
	 * @param fileName - the name of the file to read from.
	 * @return - returns a 2D array of Color values, representing the image data.
	 */
	public static Color[][] read(String fileName) {
		In in = new In(fileName);
		in.readString(); // reads file, ignoring the 1 and 3 lines.
		int numCols = in.readInt(); // reads the 2.0-nd line, which is the number of columns.
		int numRows = in.readInt(); // reads the 2.1-rd line, which is the number of rows.
		in.readInt(); // ignore
		Color[][] image = new Color[numRows][numCols]; // Creates the image array
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				int r = in.readInt();
				int g = in.readInt();
				int b = in.readInt();
				image[i][j] = new Color(r, g, b);
			}
		}
		return image;
	}

	/**
	 * Prints the pixels of the given image.
	 * Each pixel is printed as a triplet
	 * of integers in the range 0-255 (separated by commas).
	 * 
	 * @param image - the image to print.
	 */
	public static void print(Color[][] image) {
		int numRows = image.length;
		int numCols = image[0].length;
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				print(image[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * Prints the RGB values of a given color, using the format "(rrr,ggg,bbb)".
	 * 
	 * @param c - the given color.
	 */
	public static void print(Color c) {
		System.out.print("(");
		System.out.printf("%3s,", c.getRed()); // Prints the red component
		System.out.printf("%3s,", c.getGreen()); // Prints the green component
		System.out.printf("%3s", c.getBlue()); // Prints the blue component
		System.out.print(")  ");
	}

	/**
	 * Returns an image which is the horizontally flipped
	 * version of the given.
	 * 
	 * @param image - the image to flip.
	 * @return - returns image which is the horizontally flipped version of the
	 *         given image.
	 */
	public static Color[][] flippedHorizontally(Color[][] image) {
		Color[][] flipped = new Color[image.length][image[0].length];
		for (int i = 0; i < image.length; i++) {
			for (int j = image[0].length - 1; j >= 0; j--) {
				flipped[i][image[0].length - 1 - j] = image[i][j];
			}
		}
		return flipped;
	}

	/**
	 * Returns an image which is the vertically flipped version of the given image.
	 * 
	 * @param image - the image to flip.
	 * @return - returns image which is the vertically flipped version of the given
	 *         image.
	 */
	public static Color[][] flippedVertically(Color[][] image) {
		Color[][] flipped = new Color[image.length][image[0].length];
		for (int i = image.length - 1; i >= 0; i--) {
			for (int j = 0; j < image[0].length; j++) {
				flipped[image.length - 1 - i][j] = image[i][j];
			}
		}
		return flipped;
	}

	/**
	 * Computes the luminance of the RGB values of the given pixel, using the
	 * 
	 * @param pixel - the given pixel.
	 * @return - returns a Color object consisting the three values r = lum, g =
	 */
	public static Color luminance(Color pixel) {
		int r = pixel.getRed();
		int g = pixel.getGreen();
		int b = pixel.getBlue();
		int lum = (int) (0.299 * r + 0.587 * g + 0.114 * b);
		return new Color(lum, lum, lum);
	}

	/**
	 * Returns an image which is the grayscaled version of the given image.
	 * 
	 * @param image - the image to grayscaled.
	 * @return - returns an image which is the grayscaled version of the given
	 *         image.
	 */
	public static Color[][] grayScaled(Color[][] image) {
		Color[][] grayScaled = new Color[image.length][image[0].length];
		for (int i = 0; i < grayScaled.length; i++) {
			for (int j = 0; j < grayScaled[0].length; j++) {
				grayScaled[i][j] = luminance(image[i][j]);
			}
		}
		return grayScaled;
	}

	/**
	 * Returns an image which is the scaled version of the given image.
	 * 
	 * @param image  - the image to scale
	 * @param width  - the desired width of the scaled image
	 * @param height - the desired height of the scaled image
	 * @return - returns an image which is the scaled version of the given image.
	 */
	public static Color[][] scaled(Color[][] image, int width, int height) {
		Color[][] scaled = new Color[height][width];
		double ratioX = (double) image[0].length / width;
		double ratioY = (double) image.length / height;
		for (int i = 0; i < scaled.length; i++) {
			for (int j = 0; j < scaled[0].length; j++) {
				scaled[i][j] = image[(int) (i * ratioY)][(int) (j * ratioX)];
			}
		}
		return scaled;
	}

	/**
	 * Computes and returns a blended color which is a linear combination of the two
	 * 
	 * @param c1    - the first color
	 * @param c2    - the second color
	 * @param alpha - the alpha value
	 * @return - returns a blended color which is a linear combination of the two
	 */
	public static Color blend(Color c1, Color c2, double alpha) {
		int r = (int) (alpha * c1.getRed() + (1 - alpha) * c2.getRed());
		int g = (int) (alpha * c1.getGreen() + (1 - alpha) * c2.getGreen());
		int b = (int) (alpha * c1.getBlue() + (1 - alpha) * c2.getBlue());
		return new Color(r, g, b);
	}

	/**
	 * Constructs and returns an image which is the blending of the two given
	 * 
	 * @param image1 - the first image
	 * @param image2 - the second image
	 * @param alpha  - the alpha value
	 * @return - returns an image which is the blending of the two given images.
	 */
	public static Color[][] blend(Color[][] image1, Color[][] image2, double alpha) {
		Color[][] blended = new Color[image1.length][image1[0].length];
		for (int i = 0; i < blended.length; i++) {
			for (int j = 0; j < blended[0].length; j++) {
				blended[i][j] = blend(image1[i][j], image2[i][j], alpha);
			}
		}
		return blended;
	}

	/**
	 * Displays a morphing sequence of the two given images.
	 * 
	 * @param source - the first image
	 * @param target - the second image
	 * @param n      - the number of images in the morphing sequence
	 */
	public static void morph(Color[][] source, Color[][] target, int n) {
		Color[][] blended = new Color[source.length][source[0].length];
		for (int i = 0; i < n; i++) {
			blended = blend(source, target, (double) i / (n - 1));
			display(blended);
			StdDraw.pause(500);
		}
	}

	/**
	 * Creates a canvas for the given image.
	 * 
	 * @param image - the image to create a canvas for.
	 */
	public static void setCanvas(Color[][] image) {
		StdDraw.setTitle("Runigram 2024");
		int height = image.length;
		int width = image[0].length;
		StdDraw.setCanvasSize(height, width);
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(0, height);
		StdDraw.enableDoubleBuffering();
	}

	/**
	 * Displays the given image on the current canvas.
	 * 
	 * @param image - the image to display.
	 */
	public static void display(Color[][] image) {
		int height = image.length;
		int width = image[0].length;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				StdDraw.setPenColor(image[i][j].getRed(),
						image[i][j].getGreen(),
						image[i][j].getBlue());
				StdDraw.filledSquare(j + 0.5, height - i - 0.5, 0.5);
			}
		}
		StdDraw.show();
	}
}
