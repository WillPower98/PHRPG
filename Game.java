import javax.swing.JFrame;
import javax.swing.JOptionPane;

//William Munoz
//May 11, 2016

public class Game extends JFrame
{
   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   /**
    * 
    */

   public static void main(String[] args)
   {
      
    JOptionPane.showMessageDialog(null,
            "Welcome",
            "Late To School", 
            JOptionPane.INFORMATION_MESSAGE,
           null);
    
    
   JFrame window = new JFrame("Late To School");
   window.setSize(800,600);
   window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   window.setLocationRelativeTo(null);
   window.setContentPane(new GamePanel());
   window.setVisible(true);
   }
}
