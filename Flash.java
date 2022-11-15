import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public class Flash extends Inventory
{
    private int x;
    private int y;
    private int width;
    private int height;
    private BufferedImage image;

    public Flash(int x, int y, String name)
    {
        super(x,y,name);

        try
		{
			image = ImageIO.read(new File("images/flash.png"));
		}

		catch(IOException e){}

        this.image = image;
        this.width = 50;
        this.height = 50;
    }
}