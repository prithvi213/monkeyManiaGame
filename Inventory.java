import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public abstract class Inventory
{
    private int x;
    private int y;
    private int width;
    private int height;
    private BufferedImage image;
    private boolean visible;

    public Inventory(int x, int y, String name)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.visible = false;

        try
		{
			image = ImageIO.read(new File("images/" + name + ".png"));
		}

		catch(IOException e){}
    }

    public void drawMe(Graphics g)
    {
        if(visible)
        {
            g.drawImage(image,x,y,null);
        }
    }

    public void drawMe(Graphics g, int x, int y)
    {
        g.drawImage(image,x,y,null);
    }

    public void moveLeft()
    {
        if(visible)
        {
            x -= 10;

            if(x < 200)
            {
                visible = false;
            }
        }
    }

    public void fire(int playerX, int playerY)
    {
        if(visible == false)
        {
            x = playerX;
            y = playerY;
            visible = true;
        }
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public boolean getVisible()
    {
        return visible;
    }
}