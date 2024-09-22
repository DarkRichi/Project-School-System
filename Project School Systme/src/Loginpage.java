import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Scanner;

public class Loginpage implements ActionListener {

    private JFrame frame = new JFrame("Admin Login");
    private JLabel admin = new JLabel("Admin Login");
    private JLabel enterid = new JLabel("Enter ID:");
    private JLabel enterpassword = new JLabel("Password:");
    private JButton signinbutton = new JButton("Sign In");
    private JButton resetbutton = new JButton("Reset");
    private JTextField inputid = new JTextField("");
    private JPasswordField inputpw = new JPasswordField("");
    private JLabel message = new JLabel();

    private Font font = new Font("Arail",Font.PLAIN,16);

    HashMap<String,String> User = new HashMap<String,String>();
    HashMap<String,String> Admin = new HashMap<String,String>();

    Loginpage(){

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
        signinbutton.setFocusable(false);
        frame.add(signinbutton);
        resetbutton.setBounds(50,200,100,30);
        resetbutton.addActionListener(this);
        resetbutton.setFocusable(false);
        frame.add(resetbutton);

        // Message label
        message.setBounds(100,250,300,50);
        message.setFont(new Font(null,Font.HANGING_BASELINE,30));
        frame.add(message);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==resetbutton){
            inputid.setText("");
            inputpw.setText("");
        }
        Account account = new Account();
        Scanner scanner = new Scanner(inputid.getText());
        Scanner scanner2 = new Scanner(String.valueOf(inputpw.getPassword()));

        if(e.getSource()==signinbutton){
            String id = inputid.getText();
            String pw = String.valueOf(inputpw.getPassword());


            if (account.getadminInfo().containsKey(id)){
                if (account.getadminInfo().get(id).equals(pw)) {
                    message.setText("Admin Login");
                    message.setForeground(Color.GREEN);
                    Admincontrol admincontrol = new Admincontrol();

                } else {
                    message.setText("Wrong password");
                    message.setForeground(Color.RED);
                }

            } else if (!account.getadminInfo().containsKey(id)) {
                message.setText("ID not found");
                message.setForeground(Color.RED);
            }

            if (account.getuserInfo().containsKey(id)) {
                if (account.getuserInfo().get(id).equals(pw)) {
                    message.setText("User Login");
                    message.setForeground(Color.GREEN);
                    Usercontrol usercontrol = new Usercontrol();

                } else {
                    message.setText("Wrong password");
                    message.setForeground(Color.RED);
                }

            }

        }

    }

}
