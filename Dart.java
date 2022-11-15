import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public class Dart extends Inventory
{
    private int x;
    private int y;
    private int width;
    private int height;
    private BufferedImage image;

    public Dart(int x, int y, String name)
    {
        super(x,y,name);

        try
		{
			image = ImageIO.read(new File("images/dart.png"));
		}

		catch(IOException e){}

        this.image = image;
        this.width = 50;
        this.height = 23;
    }
}