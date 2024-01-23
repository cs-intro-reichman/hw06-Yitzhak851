import java.awt.Color;

public class Editor4 {
    public static void main(String[] args) {
        String fileName = args[0];
        int n = Integer.parseInt(args[1]);
        Color[][] picture = Runigram.read(fileName);
        Color[][] image = Runigram.grayScaled(picture);
        Runigram.setCanvas(picture); 
        Runigram.morph(picture, image, n);
    }
}