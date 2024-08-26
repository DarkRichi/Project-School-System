import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Adminlogin implements ActionListener {
    JFrame frame = new JFrame("Admin Login");
    JLabel admin = new JLabel("Admin Login");
    JLabel enterid = new JLabel("Enter ID:");
    JLabel enterpassword = new JLabel("Password:");
    JButton signinbutton = new JButton("Sign In");
    JButton resetbutton = new JButton("Reset");
    JTextField inputid = new JTextField("");
    JPasswordField inputpw = new JPasswordField("");
    JLabel message = new JLabel();

    Font font = new Font("Arail",Font.PLAIN,16);

    public Adminlogin(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLayout(null);

        Font boldfont = new Font("Arail",Font.BOLD,20);
        admin.setBounds(125,20,150,50);
        admin.setBackground(Color.PINK);
        admin.setOpaque(true);
        admin.setFont(boldfont);
        admin.setHorizontalAlignment(SwingConstants.CENTER);
        admin.setVerticalAlignment(SwingConstants.CENTER);
        frame.add(admin);

        enterid.setBounds(70,70,100,50);
        enterid.setFont(font);
        frame.add(enterid);
        // Input Username or ID
        inputid.setBounds(150,80,120,30);
        frame.add(inputid);

        enterpassword.setBounds(70,120,100,50);
        enterpassword.setFont(font);
        frame.add(enterpassword);
        // Input Password
        inputpw.setBounds(150,130,120,30);
        frame.add(inputpw);

        // Button reset and sign in
        signinbutton.setBounds(225,200,100,30);
        signinbutton.addActionListener(this);
        frame.add(signinbutton);
        resetbutton.setBounds(50,200,100,30);
        resetbutton.addActionListener(this);
        frame.add(resetbutton);

        // Message label
        message.setBounds(100,250,200,50);
        message.setFont(new Font(null,Font.HANGING_BASELINE,30));
        frame.add(message);

        frame.setVisible(true);
    }
    public static void main(String[] args){
        new Adminlogin();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==resetbutton){
            inputid.setText("");
            inputpw.setText("");
        }

        if(e.getSource()==signinbutton){
            message.setText("Login Success");
            message.setForeground(Color.GREEN);
            Admincontrol admincontrol = new Admincontrol();
            frame.dispose();
        }

    }
}
