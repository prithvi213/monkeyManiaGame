import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Screen extends JPanel implements ActionListener, MouseListener, KeyListener
{
    private Player player;
    private JButton startGame;
    private int screenNumber;
    private BufferedImage startScreen;
    private Font font;
    private JButton instructions;
    private BufferedImage grass;
    private BufferedImage farms;
    private JButton back;
    private BufferedImage instructionbgd;
    private BufferedImage primate;
    private BufferedImage title;
    private ArrayList<Inventory> inventoryList;
    private BufferedImage village;
    private Zomg[] zomgBlimps;
    private Projectile[] projectiles;
    private BufferedImage dart;
    private JButton inventory;
    private BufferedImage inventoryImage;
    private int itemNumber;
    private JButton restartGame;
    private JButton next;
    private BufferedImage monkey;
    private BufferedImage insideVillage;
    private BufferedImage boomerang;
    private BufferedImage sentry;
    private BufferedImage dialogueBackground;
    private BufferedImage apprentice;
    private BufferedImage fireBackground;
    private int level;
    private BufferedImage sentryLeft;
    private BufferedImage projectile;
    private int lives;
    private BufferedImage livesImage;
    private BufferedImage beacon;
    private BufferedImage oldVillage;
    private BufferedImage bomb;
    private BufferedImage shrukens;
    private BufferedImage superMonkey;
    private BufferedImage superGround;
    private BufferedImage gameOver;
    private boolean gameOverYet;
    private BufferedImage zomg;
    private BufferedImage meerkat;
    private BufferedImage flash;

    public Screen()
    {
        this.setLayout(null);

        player = new Player(650,250);
        
        this.itemNumber = 1;
        this.level = 1;
        this.lives = 3;
        this.gameOverYet = false;

        zomgBlimps = new Zomg[3];
        projectiles = new Projectile[3];

        for(int i=0; i<zomgBlimps.length; i++)
        {
            zomgBlimps[i] = new Zomg(250,50+(i*130));
        }

        for(int i=0; i<projectiles.length; i++)
        {
            projectiles[i] = new Projectile(250,50+(i*130));
        }

        startGame = new JButton("Play");
        startGame.setBounds(10,600,100,30);
        this.add(startGame);
        startGame.setFocusable(true);
        startGame.addActionListener(this);

        instructions = new JButton("Instructions");
        instructions.setBounds(870,600,120,30);
        this.add(instructions);
        instructions.setFocusable(true);
        instructions.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(10,600,80,30);
        this.add(back);
        back.setVisible(false);
        back.setFocusable(true);
        back.addActionListener(this);

        inventory = new JButton("Inventory");
        inventory.setBounds(870,540,120,30);
        this.add(inventory);
        inventory.setFocusable(true);
        inventory.addActionListener(this);

        next = new JButton("Next");
        next.setBounds(870,600,120,30);
        this.add(next);
        next.setVisible(false);
        next.setFocusable(true);
        next.addActionListener(this);

        this.screenNumber = 0;

        try
		{
			startScreen = ImageIO.read(new File("images/start.png"));
		}

		catch(IOException e){}

        try
		{
			grass = ImageIO.read(new File("images/grass.png"));
		}

		catch(IOException e){}

        try
		{
			farms = ImageIO.read(new File("images/farms.png"));
		}

		catch(IOException e){}

        try
		{
			instructionbgd = ImageIO.read(new File("images/instructionbgd.png"));
		}

		catch(IOException e){}

        try
		{
			primate = ImageIO.read(new File("images/primate.png"));
		}

		catch(IOException e){}

        try
		{
			title = ImageIO.read(new File("images/title.png"));
		}

		catch(IOException e){}

        try
		{
			village = ImageIO.read(new File("images/village.png"));
		}

		catch(IOException e){}

        try
		{
			dart = ImageIO.read(new File("images/dart.png"));
		}

		catch(IOException e){}

        try
		{
			inventoryImage = ImageIO.read(new File("images/inventoryImage.png"));
		}

		catch(IOException e){}

        try
		{
			monkey = ImageIO.read(new File("images/monkey.png"));
		}

        catch(IOException e){}

        try
        {
            insideVillage = ImageIO.read(new File("images/insideVillage.png"));
        }

        catch(IOException e){}

        try
		{
			boomerang = ImageIO.read(new File("images/boomerang.png"));
		}

		catch(IOException e){}

        try
		{
			sentry = ImageIO.read(new File("images/sentry.png"));
		}

		catch(IOException e){}

        try
		{
			dialogueBackground = ImageIO.read(new File("images/dialogue.png"));
		}

		catch(IOException e){}

        try
		{
			apprentice = ImageIO.read(new File("images/apprentice.png"));
		}

		catch(IOException e){}

        try
		{
			fireBackground = ImageIO.read(new File("images/firebgd.png"));
		}

		catch(IOException e){}

        try
		{
			sentryLeft = ImageIO.read(new File("images/sentryLeft.png"));
		}

		catch(IOException e){}

        try
        {
            projectile = ImageIO.read(new File("images/projectile.png"));
        }

        catch(IOException e){}

        try
        {
            livesImage = ImageIO.read(new File("images/lives.png"));
        }

        catch(IOException e){}

        try
        {
            beacon = ImageIO.read(new File("images/beacon.png"));
        }

        catch(IOException e){}

        try
        {
            oldVillage = ImageIO.read(new File("images/old.png"));
        }

        catch(IOException e){}

        try
        {
            bomb = ImageIO.read(new File("images/bomb.png"));
        }

        catch(IOException e){}

        try
        {
            shrukens = ImageIO.read(new File("images/shrukens.png"));
        }

        catch(IOException e){}

        try
        {
            superMonkey = ImageIO.read(new File("images/supermonkey.png"));
        }

        catch(IOException e){}

        try
        {
            superGround = ImageIO.read(new File("images/superman.png"));
        }

        catch(IOException e){}

        try
        {
            gameOver = ImageIO.read(new File("images/gameOver.png"));
        }

        catch(IOException e){}

        try
        {
            zomg = ImageIO.read(new File("images/zomg.png"));
        }

        catch(IOException e){}

        try
        {
            meerkat = ImageIO.read(new File("images/meerkat.png"));
        }

        catch(IOException e){}

        try
        {
            flash = ImageIO.read(new File("images/flash.png"));
        }

        catch(IOException e){}
        

        this.font = new Font("Chalkboard", Font.BOLD, 20);

        inventoryList = new ArrayList<Inventory>();
        inventoryList.add(new Dart(player.getX(),player.getY(), "dart"));

        this.setFocusable(true);
        this.addKeyListener(this);
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(1000,650);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        if(screenNumber == 0)
        {
            g.drawImage(startScreen,0,0,null);
            g.drawImage(title,400,10,null);
        }

        else if(screenNumber == 1)
        {
            g.drawImage(dialogueBackground,0,0,null);
            g.setFont(font);
            g.setColor(Color.GREEN);
            g.drawImage(primate,50,50,null);
            g.drawImage(monkey,50,400,null);
            g.drawString("Hello I'm Chip. Welcome to my Banana Farm. In order to gain more accessories,", 120, 80);
            g.drawString("you will need to defeat my ZOMG blimps. Since this is just the beginning of ", 120, 110);
            g.drawString("your training, the blimps won't fire, but will move at a medium speed. ", 120, 140);
            g.drawString("Once you're done, come find me in my village, where I'll help you proceed ", 120, 170);
            g.drawString("for future training.", 120, 200);
            g.drawString("Thank you.", 120, 430);
        }

        else if(screenNumber == 2)
        {
            g.drawImage(grass,0,0,null);
            g.drawImage(village,20,20,null);
            g.drawImage(primate,50,100,null);
            
            for(int i=0; i<6; i++)
            {
                for(int j=0; j<4; j++)
                {
                    g.drawImage(farms,(i*180),(j*183),null);
                }
            }

            player.drawMe(g);

            inventoryList.get(0).drawMe(g);

            for(int i=0; i<lives; i++)
            {
                g.drawImage(livesImage,775+(i*75),600,null);
            }

            if(lives == 0)
            {
                screenNumber = -1;
                gameOverYet = true;
            }

            if(!gameOverYet)
            {
                for(Zomg z : zomgBlimps)
                {
                    if(z.getCount() == 3)
                    {
                        System.out.println();
                    }

                    else 
                    {
                        z.drawMe(g);
                    }
                }
            }

            g.setFont(font);
            g.setColor(Color.CYAN);
            g.drawString("Quest I", 900, 50);
            itemNumber = 0;

            for(int i=0; i<zomgBlimps.length; i++)
            {
                if(!(zomgBlimps[i].getVisible()) && (player.getX() >= 20 && player.getY() >= 20 && player.getX() <= 170 && player.getY() <= 170))
                {           
                    itemNumber++;
                }
            }

            if(itemNumber == 3 && inventoryList.size() == 3)
            {
                screenNumber = 3;
                zomgBlimps[0].playSoundQuestEnd();
                inventory.setVisible(true);
                next.setVisible(true);
            }

            if(itemNumber == 3 && inventoryList.size() == 1)
            {
                inventoryList.add(new Boomerang(player.getX(), player.getY(), "boomerang"));
                inventoryList.add(new Sentry(player.getX(), player.getY(), "sentry"));
            }
        }

        else if(screenNumber == 3)
        {
            g.drawImage(insideVillage,0,0,null);
            g.drawImage(primate,50,50,null);
            g.drawImage(monkey,50,400,null);
            g.setFont(font);
            g.setColor(Color.YELLOW);
            g.drawString("Welcome to my village. You have proved me wrong. I have given you further ", 120, 80);
            g.drawString("accessories in your inventory if you check. You have successfully completed ", 120, 110);
            g.drawString("Quest 1. Your training has been strengthened.", 120, 140);
            g.drawImage(boomerang,120,170,null);
            g.drawImage(sentry,200,170,null);
            g.drawString("Ok, Thank you so much. I will miss you.", 120, 430);
        }

        else if(screenNumber == 4)
        {
            g.drawImage(dialogueBackground,0,0,null);
            g.drawImage(apprentice,50,50,null);
            g.drawImage(monkey,50,400,null);
            g.setFont(font);
            g.setColor(Color.ORANGE);
            g.drawString("Hello, I'm Godfire. Welcome to my Fire Lands. The challange is tougher, ", 120, 80);
            g.drawString("because you'll need to destroy faster blimps which shoot projectiles.", 120, 110);
            g.drawString("This is your 2nd Quest.", 120, 140);
            g.drawString("Ok, I'm ready.", 120, 430);
        }

        else if(screenNumber == 5)
        {
            level = 2;
            g.drawImage(fireBackground,0,0,null);
            g.drawImage(oldVillage,20,20,null);
            g.drawImage(apprentice,70,30,null);
            player.drawMe(g);

            projectiles[0].drawMe(g);
            projectiles[1].drawMe(g);
            
            g.drawImage(sentryLeft,650,150,null);

            for(int i=0; i<lives; i++)
            {
                g.drawImage(livesImage,775+(i*75),600,null);
            }

            for(int i=0; i<projectiles.length; i++)
            {
                if(projectiles[i].checkCollision(player) == true)
                {
                    lives--;
                    player.reset(650,(int)(Math.random()*50+250));

                    for(int j=0; j<zomgBlimps.length; j++)
                    {
                        zomgBlimps[j].reset(250,50+(i*130));
                    }

                    break;
                }
            }

            if(lives == 0)
            {
                screenNumber = -1;
                gameOverYet = true;
            }
            
            if(!gameOverYet)
            {
                g.setFont(font);
                g.setColor(Color.CYAN);
                g.drawString("Quest II", 900, 20);

                for(Zomg z : zomgBlimps)
                {
                    if(z.getCount() == 3)
                    {
                        System.out.println();
                    }

                    else 
                    {
                        z.drawMe(g);

                        for(Projectile p : projectiles)
                        {
                            p.drawMe(g);
                        }
                    }
                }
            }
            
            inventoryList.get(0).drawMe(g);
            inventoryList.get(1).drawMe(g);

            for(int i=0; i<zomgBlimps.length; i++)
            {
                if(!(zomgBlimps[i].getVisible()) && (player.getX() >= 20 && player.getY() >= 20 && player.getX() <= 170 && player.getY() <= 170))
                {           
                    itemNumber++;
                    lives = 3;
                }
            }

            if(itemNumber == 6 && inventoryList.size() == 3)
            {
                inventoryList.add(new Shrukens(player.getX(),player.getY(),"shrukens"));
                inventoryList.add(new Bomb(player.getX(),player.getY(),"bomb"));
            }

            if(itemNumber == 6 && inventoryList.size() == 5)
            {
                screenNumber = 6;
                zomgBlimps[0].playSoundQuestEnd();
                inventory.setVisible(true);
                next.setVisible(true);
            }
        }

        else if(screenNumber == 6)
        {
            g.drawImage(insideVillage,0,0,null);
            g.drawImage(apprentice,50,50,null);
            g.drawImage(monkey,50,400,null);
            g.setFont(font);
            g.setColor(Color.ORANGE);
            g.drawString("Before I let you go, I wanted to tell you that I'm happy you were able to fight against ", 120, 80);
            g.drawString("the stronger ZOMGs and their projectiles. By the way check your inventory for the items ", 120, 110);
            g.drawString("below. Good luck! I will miss you.", 120, 140);
            g.drawImage(shrukens,120,170,null);
            g.drawImage(bomb,200,170,null);
            g.drawString("Miss you too, apprentice", 120, 430);
        }

        else if(screenNumber == 7)
        {
            g.drawImage(dialogueBackground,0,0,null);
            g.drawImage(superMonkey,50,50,null);
            g.drawImage(monkey,50,400,null);
            g.setFont(font);
            g.setColor(Color.CYAN);
            g.drawString("Hi, my name is Super. Welcome to my Battle Ground in Bloonsmania. My ZOMGs will be ", 120, 80);
            g.drawString("a lot faster and they will shoot more frequent projectiles. This is your 3rd quest. ", 120, 110);
            g.drawString("Meet me by my beacon once you are done, where it's all warm. Are you ready?", 120, 140);
            g.drawString("Sir yes sir.", 120, 430);
        }

        else if(screenNumber == 8)
        {
            level = 3;
            g.setColor(Color.BLUE);
            g.fillRect(0,0,1000,650);
            g.drawImage(superGround,0,0,null);
            g.setFont(font);
            g.setColor(Color.CYAN);
            g.drawImage(beacon,20,20,null);
            g.drawImage(superMonkey,40,120,null);
            player.drawMe(g);
            g.drawImage(sentryLeft,650,150,null);
            g.drawImage(sentryLeft,650,350,null);
            projectiles[0].drawMe(g);
            projectiles[1].drawMe(g);
            projectiles[2].drawMe(g);

            for(int i=0; i<lives; i++)
            {
                g.drawImage(livesImage,775+(i*75),600,null);
            }

            
            for(int i=0; i<projectiles.length; i++)
            {
                if(projectiles[i].checkCollision(player) == true)
                {
                    lives--;
                    player.reset((int)(Math.random()*5+655),(int)(Math.random()*50+255));

                    for(int j=0; j<zomgBlimps.length; j++)
                    {
                        zomgBlimps[j].reset(250,50+(i*130));
                    }

                    break;
                }
            }

            if(lives == 0)
            {
                screenNumber = -1;
                gameOverYet = true;
            }

            if(!gameOverYet)
            {
                g.drawString("Quest III", 900, 20);
                
                for(Zomg z : zomgBlimps)
                {
                    if(z.getCount() == 3)
                    {
                        System.out.println();
                    }

                    else 
                    {
                        z.drawMe(g);

                        for(Projectile p : projectiles)
                        {
                            p.drawMe(g);
                        }
                    }
                }
            }

            inventoryList.get(0).drawMe(g);
            inventoryList.get(1).drawMe(g);
            inventoryList.get(3).drawMe(g);
            inventoryList.get(4).drawMe(g);

            for(int i=0; i<zomgBlimps.length; i++)
            {
                if(!(zomgBlimps[i].getVisible()) && (player.getX() >= 20 && player.getY() >= 20 && player.getX() <= 170 && player.getY() <= 170))
                {           
                    itemNumber++;
                }
            }

            if(itemNumber == 9 && inventoryList.size() == 5)
            {
                inventoryList.add(new Meerkat(player.getX(),player.getY(),"meerkat"));
                inventoryList.add(new Flash(player.getX(),player.getY(),"flash"));
                inventoryList.add(new Lock(player.getX(),player.getY(),"lock"));
                inventoryList.add(new Lock(player.getX(),player.getY(),"lock"));
                inventoryList.add(new Lock(player.getX(),player.getY(),"lock"));
            }

            if(itemNumber == 9 && inventoryList.size() == 10)
            {
                screenNumber = 9;
                zomgBlimps[0].playSoundQuestEnd();
                inventory.setVisible(true);
                next.setVisible(true);
            }
        }

        else if(screenNumber == 9)
        {
            g.drawImage(insideVillage,0,0,null);
            g.setFont(font);
            g.setColor(Color.CYAN);
            g.drawImage(superMonkey,50,50,null);
            g.drawImage(monkey,50,430,null);
            g.drawString("Well done... You defeated my ZOMGs which fire at a faster rate.", 120, 80);
            g.drawString("I am ready to give you these weapons and your traning is complete.", 120, 110);
            g.drawString("I will miss you.", 120, 140);
            g.drawImage(meerkat,120,170,null);
            g.drawImage(flash,200,170,null);
            g.drawString("Miss you too, sensei", 120, 460);
        }

        else if(screenNumber == 10)
        {
            g.setColor(Color.GREEN);
            g.fillRect(0,0,1000,650);
            g.drawImage(primate,50,50,null);
            g.setFont(font);
            g.setColor(Color.BLACK);
            g.drawString("Hi, it's your old friend Chip. I want to congratulate you for destroying every ", 120, 80);
            g.drawString("ZOMG in banana farms, volcanic lands, and the Super Battle Ground.", 120, 110);
            g.drawImage(monkey,50,430,null);
            g.drawString("I missed you too and thank you very much.", 120, 460);
            next.setVisible(false);
            g.drawString("Press R to Restart", 800, 570);
        }

        else if(screenNumber == 30)
        {
            g.setColor(Color.GREEN);
            g.fillRect(0,0,1000,650);
            g.setFont(font);
            g.setColor(Color.BLUE);
            g.drawString("Monkey Mania I", 400, 50);
            g.drawString("Rules:", 20, 80);
            g.drawString("Help Get Dart Monkey Acquire All Three Quests", 20, 110);
            g.drawString("P - Cheat Key", 20, 140);
            g.drawString("The villians are the ZOMG blimps", 20, 170);
            g.drawString("Up Arrow Key - Move Up | Down Arrow Key - Move Down | Left Arrow Key - Move Left.", 20, 200);
            g.drawString("Right Arrow Key - Move Right", 20, 230);
            g.drawString("You need to first destroy the ZOMG blimps and then move to the character shown in ", 20, 260);
            g.drawString("the top left corner. As you do, you will collect more inventory.", 20, 290);
            g.drawString("Space Bar - Shoot at an Enemy", 20, 320);
            g.drawString("As you progress through, the ZOMG blimps will be stronger.", 20, 350);
            g.drawString("You will take a journey from your home to the banana farms to the volcanic grounds, ", 20, 380);
            g.drawString("to a SuperMan designed battle ground.", 20, 410);
            g.drawString("There are 3 Quests.", 20, 440);
            g.drawImage(monkey,20,500,null);
            g.drawImage(zomg,100,480,null);
        }

        else if(screenNumber == 31)
        {
            g.setColor(Color.GREEN);
            g.fillRect(0,0,1000,650);
            g.drawImage(inventoryImage,0,0,null);
            g.setFont(font);
            g.setColor(Color.BLACK);
            g.drawString("Inventory",450,35);

            for(int i=0; i<inventoryList.size(); i++)
            {
                inventoryList.get(i).drawMe(g,(i%5)*(200)+75,180+((i/5)*240));
            }

            if(inventoryList.size() == 10)
            {
                g.drawString("COMING SOON!", 420, 350);
                g.drawString("COMING SOON!", 620, 350);
                g.drawString("COMING SOON!", 820, 350);
            }
        }

        else if(screenNumber == -1)
        {
            g.drawImage(gameOver,0,0,null);
            g.setColor(Color.CYAN);
            g.setFont(font);
            g.drawString("Press R to Play Again", 400, 100);
        }      
    }

    public void animate()
    {
        int count = 0;

        while(true)
        {
            if(level == 1)
            {
                inventoryList.get(0).moveLeft();
            
                for(Zomg z : zomgBlimps)
                {
                    z.move(level);
                    z.checkCollision(inventoryList.get(0));
                }

                try
                {
                    Thread.sleep(10);
                }

                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
            }
            
            else if(level == 2)
            {
                inventoryList.get(0).moveLeft();
                inventoryList.get(1).moveLeft();

                for(Zomg z : zomgBlimps)
                {
                    z.move(level);
                    z.checkCollision(inventoryList.get(0));
                    z.checkCollision(inventoryList.get(1));
                }

                if(count % 100 == 0)
                {
                    for(Projectile p : projectiles)
                    {
                        if(!(p.noZomgsLeft(zomgBlimps)))
                        {
                            p.fire(zomgBlimps[0].getX(), zomgBlimps[0].getY());
                        }
                    }
                }

                for(Projectile p : projectiles)
                {    
                    p.moveRight(level);
                }

                try
                {
                    Thread.sleep(10);
                }

                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
            }

            else if(level == 3)
            {
                inventoryList.get(0).moveLeft();
                inventoryList.get(1).moveLeft();
                inventoryList.get(3).moveLeft();
                inventoryList.get(4).moveLeft();

                for(Zomg z : zomgBlimps)
                {
                    z.move(level);
                    z.checkCollision(inventoryList.get(0));
                    z.checkCollision(inventoryList.get(1));
                }

                if(count % 50 == 0)
                {
                    for(Projectile p : projectiles)
                    {
                        if(!(p.noZomgsLeft(zomgBlimps)))
                        {
                            p.fire(zomgBlimps[0].getX(), zomgBlimps[0].getY());
                            p.fire(zomgBlimps[1].getX(), zomgBlimps[1].getY());
                            p.fire(zomgBlimps[2].getX(), zomgBlimps[2].getY());
                        }
                    }
                }

                for(Projectile p : projectiles)
                {    
                    p.moveRight(level);
                }

                try
                {
                    Thread.sleep(10);
                }

                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
            }

           count++;
           repaint();
        }
    }

    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == 32)
        {
            if(level == 1)
            {
                inventoryList.get(0).fire(player.getX(),player.getY());
                zomgBlimps[0].playSoundShoot();
            }

            else if(level == 2)
            {
                inventoryList.get(0).fire(650,160);
                inventoryList.get(1).fire(player.getX(),player.getY());
                zomgBlimps[0].playSoundShoot();
            }

            else if(level == 3)
            {
                inventoryList.get(0).fire(650,160);
                inventoryList.get(1).fire(650,360);
                inventoryList.get(3).fire(player.getX()-120, player.getY());
                inventoryList.get(4).fire(player.getX(), player.getY());
                zomgBlimps[0].playSoundShoot();
            }
        }

        if(e.getKeyCode() == 37)
        {
            player.moveLeft();
        }

        if(e.getKeyCode() == 38)
        {
            player.moveUp();
        }

        if(e.getKeyCode() == 39)
        {
            player.moveRight();
        }

        if(e.getKeyCode() == 40)
        {
            player.moveDown();
        }

        if(e.getKeyCode() == 80)
        {
            screenNumber++;

            if(screenNumber > 0)
            {
                startGame.setVisible(false);
                instructions.setVisible(false);         
            }

            if(screenNumber != 2 && screenNumber != 5 && screenNumber != 8)
            {
                inventory.setBounds(10,600,120,30);
                inventory.setVisible(true);
                next.setVisible(true);
            }

            else if(screenNumber == 2 || screenNumber == 5 || screenNumber == 8 || screenNumber == 10)
            {
                inventory.setVisible(false);
                next.setVisible(false);

                for(int i=0; i<zomgBlimps.length; i++)
                {
                    zomgBlimps[i].reset(250,50+(i*130),true);
                }

                player.reset((int)(Math.random()*5+650),(int)(Math.random()*50+250));
            }

            if(screenNumber == 3)
            {
                inventoryList.add(new Boomerang(player.getX(), player.getY(), "boomerang"));
                inventoryList.add(new Sentry(player.getX(), player.getY(), "sentry"));
            }

            if(screenNumber == 6)
            {
                inventoryList.add(new Shrukens(player.getX(),player.getY(),"shrukens"));
                inventoryList.add(new Bomb(player.getX(),player.getY(),"bomb"));
            }

            if(screenNumber == 9)
            {
                inventoryList.add(new Meerkat(player.getX(),player.getY(),"meerkat"));
                inventoryList.add(new Flash(player.getX(),player.getY(),"flash"));
                inventoryList.add(new Lock(player.getX(),player.getY(),"lock"));
                inventoryList.add(new Lock(player.getX(),player.getY(),"lock"));
                inventoryList.add(new Lock(player.getX(),player.getY(),"lock"));
            }
        }

        if(e.getKeyCode() == 82)
        {
            gameOverYet = false;
            screenNumber = 0;
            lives = 3;
            level = 1;
            instructions.setBounds(870,600,120,30);
            instructions.setVisible(true);
            inventory.setBounds(870,540,120,30);
            inventory.setVisible(true);
            startGame.setVisible(true);
        }

        repaint();
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == startGame)
        {
            startGame.setVisible(false);
            instructions.setVisible(false);
            inventory.setBounds(10,600,120,30);
            screenNumber = 1;
            next.setVisible(true);
            inventory.setVisible(true);
        }

        if(e.getSource() == instructions)
        {
            instructions.setVisible(false);
            startGame.setVisible(false);
            screenNumber = 30;
            back.setVisible(true);
            inventory.setVisible(false);
        }

        if(e.getSource() == back)
        {
            back.setVisible(false);
            screenNumber = 0;
            startGame.setVisible(true);
            instructions.setVisible(true);
            inventory.setVisible(true);
            inventory.setBounds(870,540,120,30);
        }

        if(e.getSource() == inventory)
        {
            screenNumber = 31;
            back.setVisible(true);
            startGame.setVisible(false);
            instructions.setVisible(false);
            inventory.setVisible(false);
        }
        
        if(e.getSource() == next)
        {
            if(screenNumber == 1)
            {
                screenNumber = 2;
                inventory.setVisible(false);
                next.setVisible(false);
            }

            else if(screenNumber == 3)
            {
                screenNumber = 4;
                inventory.setVisible(true);
                next.setVisible(true);
            }

            else if(screenNumber == 4)
            {
                screenNumber = 5;
                next.setVisible(false);
                inventory.setVisible(false);
                lives = 3;
                level = 2;
                player.reset(650,(int)(Math.random()*50+250));

                for(int i=0; i<zomgBlimps.length; i++)
                {
                    zomgBlimps[i].reset(250,50+(i*130),true);
                }
            }

            else if(screenNumber == 6)
            {
                screenNumber = 7;
                inventory.setVisible(true);
                next.setVisible(true);
            }

            else if(screenNumber == 7)
            {
                screenNumber = 8;
                level = 3;
                lives = 3;
                inventory.setVisible(false);
                next.setVisible(false);
                player.reset(650,(int)(Math.random()*50+250));

                for(int i=0; i<zomgBlimps.length; i++)
                {
                    zomgBlimps[i].reset(250,50+(i*130),true);
                }
            }

            else if(screenNumber == 9)
            {
                screenNumber = 10;
            }
        }

        repaint();
    }

    public void mousePressed(MouseEvent e){}
    public void mouseExited(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}