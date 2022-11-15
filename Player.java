import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public class Player
{
    private int x;
    private int y;
    private int length;
    private int width;
    private BufferedImage monkey;
    private boolean visible;

    public Player(int x, int y)
    {
        this.x = x;
        this.y = y;
        length = 50;
        width = 50;
        this.visible = true;

        try
		{
			monkey = ImageIO.read(new File("images/monkey.png"));
		}

		catch(IOException e){}
    }

    public void drawMe(Graphics g)
    {
        if(visible)
        {
            g.drawImage(monkey,x,y,null);
        }        
    }

    public void moveUp()
    {
        y -= 5;
    }

    public void moveLeft()
    {
        x -= 5;
    }

    public void moveRight()
    {
        x += 5;
    }

    public void moveDown()
    {
        y += 5;
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
        return length;
    }

    public int getHeight()
    {
        return width;
    }

    public boolean getVisible()
    {
        return visible;
    }

    public void reset(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}