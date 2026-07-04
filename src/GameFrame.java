import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class GameFrame extends JFrame{
    public GameFrame(){
        // Getting current screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        add(new GamePanel());
        // SEt Frame to fill the screen
        setTitle("Zombie Shooter");
        setSize(screenSize);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
