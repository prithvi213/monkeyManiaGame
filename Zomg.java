import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Zomg
{
    private int x;
    private int y;
    private int length;
    private int width;
    private BufferedImage zomg;
    private boolean visible;
    private boolean move;
    private int count;

    public Zomg(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.length = 50;
        this.width = 100;
        this.visible = true;
        this.move = true;
        this.count = 0;

        try
        {
            zomg = ImageIO.read(new File("images/zomg.png"));
        }

        catch(IOException e){}
    }

    public void drawMe(Graphics g)
    {
        g.drawImage(zomg,x,y,null);
    }

    public void checkCollision(Inventory inventory)
    {
        if(visible == true && inventory.getVisible() == true)
        {
            
            int itemX = inventory.getX();
            int itemY = inventory.getY();
            int itemHeight = inventory.getHeight();
            int itemWidth = inventory.getWidth();

            if(itemX+itemWidth >= x && itemX <= x+length && itemY+itemHeight >= y && itemY <= y+width)
            {
                count++;
                boolean proVisible = inventory.getVisible();
                proVisible = false;
                playSoundHit();
            }

            if(count == 3)
            {
                visible = false;
                playSoundHit();
            }
            
        }
    }

    public void move(int level)
    {
        if(level == 1)
        {
            if(move)
            {
                y += 5;

                if(y >= 570)
                {
                    move = false;
                }
            }

            else
            {
                y -= 5;

                if(y <= 0)
                {
                    move = true;
                }
            }
        }
        
        else if(level == 2)
        {
            if(move)
            {
                y += 10;

                if(y >= 570)
                {
                    move = false;
                }
            }

            else
            {
                y -= 10;

                if(y <= 0)
                {
                    move = true;
                }
            }
        }

        else if(level == 3)
        {
            if(move)
            {
                y += 15;

                if(y >= 570)
                {
                    move = false;
                }
            }

            else
            {
                y -= 15;

                if(y <= 0)
                {
                    move = true;
                }
            }
        }
    }

    public void playSoundShoot()
    { 
        try
        {
            URL url = this.getClass().getClassLoader().getResource("sounds/cannon.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        }

        catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
    }

    public void playSoundHit()
    { 
        try
        {
            URL url = this.getClass().getClassLoader().getResource("sounds/hit.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        }

        catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
    }

    public void playSoundQuestEnd()
    { 
        try
        {
            URL url = this.getClass().getClassLoader().getResource("sounds/ting.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        }

        catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
    }

    public boolean getVisible()
    {
        return visible;
    }

    public int getCount()
    {
        return count;
    }

    public void reset(boolean visible)
    {
        this.visible = visible;
    }

    public void reset(int x, int y, boolean visible)
    {
        this.x = x;
        this.y = y;
        this.visible = visible;
        this.count = 0;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void reset(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}