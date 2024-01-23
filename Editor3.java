import java.awt.Color;

public class Editor3 {
	public static void main(String[] args) {
		String source = args[0];
		String target = args[1];
		int n = Integer.parseInt(args[2]);
		Color[][] sourceImage = Runigram.read(source);
		Color[][] targetImage = Runigram.read(target);
		Runigram.setCanvas(sourceImage);
		Runigram.morph(sourceImage, targetImage, n);
	}
}
