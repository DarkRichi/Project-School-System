import javax.swing.*;
import java.awt.*;

public class Admincontrol {
    JFrame frame = new JFrame();
    JLabel text = new JLabel("Admin Control");

    Admincontrol(){
        text.setBounds(0,0,200,50);
        text.setFont(new Font(null, Font.LAYOUT_NO_LIMIT_CONTEXT,20));
        frame.add(text);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
