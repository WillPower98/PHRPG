import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JPanel;

//William Munoz
//May 14, 2016


public class GamePanel extends JPanel implements Runnable, KeyListener
{
 /**
    * 
    */
private static final long serialVersionUID = 1L;
public static final int WIDTH = 800;
public static final int HEIGHT = 600;
private static boolean Floor1;
 
 private Thread thread;
 private boolean running;
 
 private BufferedImage image;
 private Graphics2D g;
 
 private int FPS = 10;
 private int targetTime = 1000/FPS;
 
 private TileMap tileMap;
 private Player player;
 
 public GamePanel(){
    
    super();
    setPreferredSize(new Dimension(WIDTH,HEIGHT));
    setFocusable(true);
    requestFocus();
    Floor1=false;
 }
 
 public void addNotify()
 {
    super.addNotify();
    if(thread == null){
       thread = new Thread(this);
       thread.start();
    }
    addKeyListener(this);
 }
 
 public static boolean getFloor1(){
    
       return Floor1;
    
 }
 public void run(){
    tileMap = new TileMap("src/Floor2",32);
    
    init(tileMap);
    
    
    long startTime;
    long urdTime;
    long waitTime;
    
    while(running){
       startTime = System.nanoTime();
       if(player.getx()>=50 && player.getx()<=75 && player.gety()>=1280 && player.gety()<=1312){
          tileMap = new TileMap("src/Floor1",32);
          init(tileMap);
          player.setx(75);
          player.sety(1248);
          Floor1=true;
          }
       
       if(player.getx()>=350 && player.getx()<=375 && player.gety()>=690 && player.gety()<=722){
          tileMap=new TileMap("src/Floor1",32);
          init(tileMap);
          player.setx(390);
          player.sety(650);
          Floor1=true;
       }
       update();
       render();
       draw();
       
       urdTime = (System.nanoTime() - startTime)/1000000;
       waitTime = targetTime - urdTime;
       
       try{
          Thread.sleep(waitTime);
       }
       catch(Exception e){
          
       }
       
    }
 }
 
 
 private void init(TileMap tileMap){
    running = true;
    image = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_INT_RGB);
    g = (Graphics2D) image.getGraphics();
    
     
    tileMap.loadTiles("src/tilesetNew11.gif");
    try
   {
     player = new Player(tileMap);
   } catch (IOException e)
   {
      // TODO Auto-generated catch block
      e.printStackTrace();
   }
    player.setx(100);
    player.sety(100);
 }
 
 private void update(){
    tileMap.update();
    player.update();
   
 }
 
 private void render(){
    
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, WIDTH, HEIGHT);
    tileMap.draw(g);
    player.draw(g);

    
 }
 
 private void draw(){
    Graphics g2 = getGraphics();
    g2.drawImage(image, 0, 0 , null);
    g2.dispose();
    
    
 }

@Override
public void keyPressed(KeyEvent key)
{
   int code = key.getKeyCode();
   
   if(code == KeyEvent.VK_SHIFT){
      player.setmaxSpeed(2);
   }
   
   if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A){
      player.setLeft(true);
   }
   
   if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D){
      player.setRight(true);
   }
   
   if(code == KeyEvent.VK_UP || code == KeyEvent.VK_W){
      player.setup(true);
   }
   
   if(code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S){
      player.setdown(true);
   }

}

@Override
public void keyReleased(KeyEvent key)
{
int code = key.getKeyCode();
   
   if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A){
      player.setLeft(false);
   }
   
   if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D){
      player.setRight(false);
   }
   
   if(code == KeyEvent.VK_UP || code == KeyEvent.VK_W){
      player.setup(false);
   }
   
   if(code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S){
      player.setdown(false);
   }
   
   if(code == KeyEvent.VK_SHIFT){
      player.setmaxSpeed(.5);
   }
   
}

@Override
public void keyTyped(KeyEvent key)
{
   
   
}
 
 
 
}
