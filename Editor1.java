import java.awt.Color;

public class Editor1 {
	public static void main(String[] args) {
		String fileName = args[0];
		String action = args[1];
		Color[][] imageIn = Runigram.read(fileName);
		Color[][] imageOut = null;
		if (action.equals("fh")) {
			imageOut = Runigram.flippedHorizontally(imageIn);
		} else if (action.equals("fv")) {
			imageOut = Runigram.flippedVertically(imageIn);
		} else if (action.equals("gs")) {
			imageOut = Runigram.grayScaled(imageIn);
		}
		Runigram.setCanvas(imageIn);
		Runigram.display(imageIn);
		StdDraw.pause(3000);
		Runigram.display(imageOut);
	}
}