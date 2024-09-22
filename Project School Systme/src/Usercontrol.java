import javax.swing.*;
import java.awt.*;

public class Usercontrol {
    JFrame frame = new JFrame();
    JLabel text = new JLabel("Welcome User");

    Usercontrol(){
        text.setBounds(0,0,200,50);
        text.setFont(new Font(null, Font.LAYOUT_NO_LIMIT_CONTEXT,20));
        frame.add(text);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("User");
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
