import java.awt.Color;

public class Editor2 {

	public static void main(String[] args) {
		String fileName = args[0];
		int width = Integer.parseInt(args[1]);
		int height = Integer.parseInt(args[2]);
		Color[][] imageIn = Runigram.read(fileName);
		Color[][] scaledImage = Runigram.scaled(imageIn, width, height);
		Runigram.setCanvas(imageIn);
		Runigram.display(imageIn);
		StdDraw.pause(3000);
		Runigram.setCanvas(scaledImage);
		Runigram.display(scaledImage);
	}
}
