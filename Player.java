import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

//William Munoz
//May 16, 2016

public class Player
{

   private double x;
   private double y;
   private double dx;
   private double dy;
   private Font font = new Font("Gill Sans Ultra Bold",Font.BOLD,15);
   private int width;
   private int height;
   private boolean left;
   private boolean right;
   private boolean up;
   private boolean down;
   
   private double moveSpeed;
   private double maxSpeed;
   private double stopSpeed;
   
   private TileMap tileMap;
   
   private boolean topLeft;
   private boolean topRight;
   private boolean bottomLeft;
   private boolean bottomRight;
   
   private String text;
   private String text1;
   private String text2;
   
   private Animation animation;
   private BufferedImage[] idleSprites;
   private BufferedImage[] walkingSprites;
   private BufferedImage[] upSprites;
   private BufferedImage[] downSprites;
   private boolean facingLeft;
   
   
   
   public Player(TileMap tm) throws IOException{
      tileMap=tm;
      text="Welcome To";
      text1="Pascack Hills";
      text2="";
      width = 22;
      height = 22;       
      //default is 8
      moveSpeed = 8; 
      maxSpeed = 8;   
      stopSpeed = 2;
      
      try{
         idleSprites = new BufferedImage[1];
         walkingSprites = new BufferedImage[6];
         downSprites = new BufferedImage[6];
         upSprites = new BufferedImage[6];
         
         idleSprites[0] = ImageIO.read(new File("src/Screen Shot 2016-05-23 at 1.37.45 PM.png"));
         
         BufferedImage image = ImageIO.read(new File("src/walking2.gif"));
         for(int i=0;i<walkingSprites.length;i++){
            walkingSprites[i]=image.getSubimage(i*width+i, 0, width, height);
         }
      
      
      BufferedImage image1 = ImageIO.read(new File("src/walking6.png"));
      for(int i=0;i<downSprites.length;i++){
         downSprites[i]=image1.getSubimage(i*width+i, 0, width, height);
      }
      
      BufferedImage image2 = ImageIO.read(new File("src/up2.png"));
      for(int i=0;i<upSprites.length;i++){
         upSprites[i]=image2.getSubimage(i*width+i, 0, width, height);
      }
      
      }
      catch(Exception e){
         e.printStackTrace();
      }
      
      
      animation = new Animation();
      facingLeft = false;
   }
   
   public void setx(int i){x=i;}
   public void sety(int i){y=i;}
   public double getx(){return x;}
   public double gety(){return y;}
   public String gettext(){return text;}
   
   public void settext(){
      
 if(GamePanel.getFloor1()==false){
    
 
      if(getx()>=50 && getx()<=150 && gety()>=64 && gety()<=192){
         text="Band Storage";
         text1 = "Room 212";
         text2="Dr.Bill";
      }
      else if(getx()>=50 && getx()<=150 && gety()>=192 && gety()<=448){
         text="Band Room.";
         text1 = "Room 210";
         text2 = "Dr.Bill";
      }
      else if (getx()>=50 && getx()<=150 && gety()>=448 && gety()<=512){
         text = "Band Office";
         text1 = "Dr.Bill";
         text2 = "";
      }
      else if(getx()>=50 && getx()<=125 && gety()>=544 && gety()<=640){
         text= "Conference Room";
         text1 = "Room 203";
         text2 = "";
      }
      else if(getx()>=50 && getx()<=150 && gety()>=672 && gety()<=864){
         text= "Choir Room";
         text1 = "Room 204";
         text2 = "Ms. Elkin";
      }
      else if(getx()>=50 && getx()<=150 && gety()>=864 && gety()<=928){
         text= "Choir Office";
         text1 = "Ms. Elkin";
         text2 = "";
      }
      else if(getx()>=50 && getx()<=150 && gety()>928 && gety()<=1024){
         text="Dark Room";
         text1 = "Mrs.Garretson";
      }
      else if(getx()>=50 && getx()<=150 && gety()>=1024 && gety()<=1120)
      {
         text = "Photography";
         text1= "202";
         text2="Mrs.Garretson";
      }
      else if(getx()>=50 && getx()<=150 && gety()>=1152 && gety()<=1248){
         text= "Tech Supervisor";
         text1 = "Room 200";
         text2 = "";
        }
      else if(getx()>=50 && getx()<=150 && gety()>=1280 && gety()<=1312){
         text="Stairwell";
         text1="";
         text2="";
      }
      else if(getx()>=300 && getx()<=425 && gety()>=64 && gety()<=192){
         text="Video Production";
         text1= "Room 213";
         text2="Ms. Manzella";
      }
      else if(getx()>=300 && getx()<=425 && gety()>=224 && gety()<=352){
         text="Tech Lab";
         text1="Room 211";
         text2="Mr. Kohler";
      }
      else if(getx()>=300 && getx()<=425 && gety()>=384 && gety()<=466)
      {
         text = "Faculty Bathroom";
         text1 = "Don't Go";
         text2 = "In Here";
      }
      else if(getx()>=300 && getx()<=425 && gety()>=690 & gety()<=722){
         text="Stairwell";
         text1="";
         text2="";
      }
      else if(getx()>=300 && getx()<=425 && gety()>722 && gety()<=786){
         text = "Girl's Bathrrom";
         text1="";
         text2="";
      }
      else if(getx()>=300 && getx()<=425 && gety()>786 && gety()<=1010){
         text="Art Room";
         text1="Room 203";
         text2="Mr.Dinky";
      }
      else if(getx()>=300 && getx()<=425 && gety()>1010 && gety()<=1330){
         text="Art Room";
         text1="Room 201";
         text2="Mr.Dinky";
      }
      else if(getx()>=625 && getx()<=700 && gety()>=64 && gety()<=192){
         text="Spanish Room";
         text1 = "Room 234";
         text2="Senora Sularz";
      }
      else
      {
         text="Welcome To";
         text1= "Pascack Hills";
         text2 = "";
      }
      }
   }
   
   public void setmaxSpeed(double num){
      maxSpeed=maxSpeed*num;
   }
   
   public void setLeft(boolean b) {left=b;}
   public void setRight(boolean b) {right=b;}
   public void setup(boolean b){up=b;}
   public void setdown(boolean b){down=b;}
   
   private void calculateCorners(double x, double y){
      int leftTile = tileMap.getColTile((int)(x-width/2));
      int rightTile = tileMap.getColTile((int)(x+width/2)-1);
      int topTile = tileMap.getRowTile((int)(y-height/2));
      int bottomTile = tileMap.getRowTile((int)(y+height/2)-1);
      topLeft = tileMap.isBlocked(topTile, leftTile);
      topRight = tileMap.isBlocked(topTile, rightTile);
      bottomLeft = tileMap.isBlocked(bottomTile, leftTile);
      bottomRight = tileMap.isBlocked(bottomTile, rightTile);
   }
   
   public void update(){
      //detrmine next position
      if(left){
         dx-= moveSpeed;
         if(dx<-maxSpeed){
            dx=-maxSpeed; 
         }
      }
      else if(right){
         dx+=moveSpeed;
         if(dx>maxSpeed){
            dx = maxSpeed;
         }
      }
      else{
         if(dx>0){
            dx-=stopSpeed;
            if(dx<0){
               dx=0;
            }
         }
         else if(dx<0){
            dx+=stopSpeed;
            if(dx>0){
               dx=0;
            }
         }
      }
      
      if(up){
         dy-=moveSpeed;
         if(dy<-maxSpeed){
            dy=-maxSpeed;
         }        
      }
      else if(down){
         dy+=moveSpeed;
         if(dy>maxSpeed){
            dy=maxSpeed;
         }
      }
      else{
         if(dy>0){
            dy-=stopSpeed;
            if(dy<0){
               dy=0;
            }
         }
         else if(dy<0){
            dy+=stopSpeed;
            if(dy>0){
               dy=0;
            }
         }
      }
      
      //check collisions
      
      int currCol = tileMap.getColTile((int)x);
      int currRow = tileMap.getRowTile((int)y);
      
      double tox = x+dx;
      double toy = y+dy;
      
      double tempx = x;
      double tempy = y;
      
      calculateCorners(x, toy);
      if(dy<0){
         if(topLeft || topRight){
            dy=0;
            tempy = currRow*tileMap.getTileSize()+height/2;
         }
         else{
            tempy+=dy;
         }
      }
      
      if(dy>0){
         if(bottomLeft || bottomRight){
            dy=0;
            tempy= (currRow+1)*tileMap.getTileSize()-height/2;
            
         }
         else{
            tempy+=dy;
         }
      }
      
      calculateCorners(tox,y);
      if(dx<0){
         if(topLeft || bottomLeft){
            dx=0;
            tempx = currCol*tileMap.getTileSize()+width/2;
         }
         else{
            tempx+=dx;
         }
      }
      if(dx>0){
         if(topRight || bottomRight){
            dx=0;
            tempx=(currCol+1)*tileMap.getTileSize()-width/2;
         }
         else{
            tempx+=dx;
         }
      }
      
      x=tempx;
      y=tempy;
      
      //move the map
      
      tileMap.setx((int)(GamePanel.WIDTH/2-x));
      tileMap.sety((int)(GamePanel.HEIGHT/2-y));
      
      
      //sprite animation
      
      if(left || right){
         animation.setFrames(walkingSprites);
         animation.setDelay(100);
      }
      else{
         animation.setFrames(idleSprites);
         animation.setDelay(-1);
      }
      if(dy<0){
         animation.setFrames(upSprites);
         animation.setDelay(500);
      }
      if(dy>0){
         animation.setFrames(downSprites);
         animation.setDelay(500);
      }
      
      animation.update();
      
      if(dx<0){
         facingLeft=true;
      }
      if(dx>0){
         facingLeft=false;
      }
      
   settext();
      
      
   }
   
   public void draw(Graphics2D g){
      int tx = tileMap.getx();
      int ty = tileMap.gety();
      
      if(facingLeft){
         g.drawImage(animation.getImage(),(int)(tx+x-width/2),(int)(ty+y-height/2),null);
      }
      else{
         g.drawImage(animation.getImage(),(int)(tx+x-width/2+width),(int)(ty+y-height/2),-width,height,null);
      }
      
      g.setColor(Color.WHITE);

      g.fillRect(600, 450, 175, 90);
      g.setColor(Color.BLACK);
      g.fillRect(600, 450, 175, 5);
      g.fillRect(600, 450, 5, 90);
      g.fillRect(600, 540, 175, 5);
      g.fillRect(770, 450, 5, 90);
      g.setColor(Color.ORANGE);
      g.setFont(font);
      g.drawString(text, 615, 485);
      g.drawString(text1, 615, 500);
      g.drawString(text2, 615, 515);
      
      }
}
