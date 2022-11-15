import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Projectile
{
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;
    private BufferedImage projectile;

    public Projectile(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.width = 100;
        this.height = 50;
        this.visible = false;

        try
        {
            projectile = ImageIO.read(new File("images/rocket.png"));
        }

        catch(IOException e){}
    }

    public void drawMe(Graphics g)
    {
        if(visible)
        {
            g.drawImage(projectile,x,y,null);
        }
    }

    public void moveRight(int level)
    {
        if(level == 2)
        {
            if(visible)
            {
                x += 5;

                if(x > 800)
                {
                    visible = false;
                }
            }
        }

        else if(level == 3)
        {
            if(visible)
            {
                x += 10;

                if(x > 800)
                {
                    visible = false;
                }
            }
        }
    }

    public boolean checkCollision(Player player)
    {
        if(visible)
        {
            int pX = player.getX();
            int pY = player.getY();
            int pWidth = player.getWidth();
            int pHeight = player.getHeight();

            if(pX+pWidth >= x && pX <= x+width && pY+pHeight >= y && pY <= y+height)
            {
                visible = false;
                return true;
            }
        }

        return false;
    }

    public boolean noZomgsLeft(Zomg[] zomgBlimps)
    {
        for(int i=0; i<zomgBlimps.length; i++)
        {
            if(zomgBlimps[i].getVisible() == true)
            {
                return false;
            }
        }

        return true;
    }

    public void fire(int fighterX, int fighterY)
    {
        if(!visible)
        {
            x = fighterX;
            y = fighterY;
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