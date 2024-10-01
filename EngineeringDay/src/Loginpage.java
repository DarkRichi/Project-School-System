import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loginpage extends JFrame implements ActionListener {
    JPanel panel, Rpanel, Lpanel;
    JLabel logintext, enterID, enterPW, logincheck;
    JButton loginbutton, signupbutton, resetbutton;
    JTextField inputID;
    JPasswordField inputPW;
    KeyStroke escapeKey = KeyStroke.getKeyStroke("ESCAPE");
    KeyStroke enterKey = KeyStroke.getKeyStroke("ENTER"); // Added Enter Key
    Action escape = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    };

    Action loginAction = new AbstractAction() { // Added action for Enter Key
        @Override
        public void actionPerformed(ActionEvent e) {
            performLogin();
        }
    };

    Loginpage() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 500);
        this.setLayout(null);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKey, "ESCAPE");
        this.getRootPane().getActionMap().put("ESCAPE", escape);

        // Register Enter Key for the login action
        this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(enterKey, "ENTER");
        this.getRootPane().getActionMap().put("ENTER", loginAction);

        panel = new JPanel();
        panel.setSize(800, 500);
        panel.setBackground(Color.PINK);
        panel.setBorder(new LineBorder(Color.BLACK, 5));
        panel.setLayout(null);

        Rpanel = new JPanel();
        Rpanel.setBounds(0, 0, 350, 500);
        Rpanel.setBackground(new Color(0xb5e48c));
        panel.add(Rpanel);

        Lpanel = new JPanel();
        Lpanel.setBounds(350, 0, 450, 500);
        Lpanel.setBackground(new Color(0x48cae4));
        Lpanel.setLayout(null);
        panel.add(Lpanel);

        logintext = new JLabel();
        logintext.setText("Login");
        logintext.setBounds(0, 50, 450, 50);
        logintext.setHorizontalAlignment(SwingConstants.CENTER);
        logintext.setForeground(Color.black);
        logintext.setFont(new Font("Inika", Font.BOLD, 28));
        Lpanel.add(logintext);

        enterID = new JLabel();
        enterID.setText("Enter ID:");
        enterID.setBounds(45, 120, 100, 30);
        enterID.setFont(new Font("Inika", Font.PLAIN, 16));
        enterID.setForeground(Color.BLACK);
        Lpanel.add(enterID);

        enterPW = new JLabel();
        enterPW.setText("Password:");
        enterPW.setForeground(Color.BLACK);
        enterPW.setFont(new Font("Inika", Font.PLAIN, 16));
        enterPW.setBounds(45, 200, 100, 30);
        Lpanel.add(enterPW);

        inputID = new JTextField();
        inputID.setText("");
        inputID.setForeground(Color.GRAY);
        inputID.setBounds(50, 150, 300, 30);
        inputID.setFont(new Font(null, Font.PLAIN, 16));
        inputID.setBackground(new Color(0x48cae4));
        inputID.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        Lpanel.add(inputID);

        inputPW = new JPasswordField();
        inputPW.setText("");
        inputPW.setForeground(Color.GRAY);
        inputPW.setBounds(50, 230, 300, 30);
        inputPW.setFont(new Font(null, Font.PLAIN, 16));
        inputPW.setBackground(new Color(0x48cae4));
        inputPW.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        Lpanel.add(inputPW);

        loginbutton = new JButton();
        loginbutton.setText("Login");
        loginbutton.setForeground(Color.BLACK);
        loginbutton.setFont(new Font("Inika", Font.PLAIN, 16));
        loginbutton.setBounds(50, 350, 100, 40);
        loginbutton.addActionListener(this);
        Lpanel.add(loginbutton);


        signupbutton = new JButton();
        signupbutton.setText("SignUp");
        signupbutton.setFont(new Font("Inika", Font.PLAIN, 16));
        signupbutton.setForeground(Color.BLACK);
        signupbutton.setBounds(175, 350, 100, 40);

        Lpanel.add(signupbutton);

        resetbutton = new JButton();
        resetbutton.setText("Reset");
        resetbutton.setForeground(Color.BLACK);
        resetbutton.setBounds(300, 350, 100, 40);
        resetbutton.setFont(new Font("Inika", Font.PLAIN, 16));
        resetbutton.addActionListener(this);
        Lpanel.add(resetbutton);

        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetbutton) {
            inputID.setText("");
            inputPW.setText("");
        }
        if (e.getSource() == loginbutton) {
            performLogin();
        }
    }

    // Method to perform login action
    private void performLogin() {
        String id = inputID.getText();
        String pw = String.valueOf(inputPW.getPassword());

        DB db = new DB();
        String[] loginInfo = db.Userlogin(id, pw);
        String role = loginInfo[0];
        if (role != null) {
            System.out.println("success");
            if (role.equals("admin")) {
                TeacherControlRoom teacherControlRoom = new TeacherControlRoom(id,pw);
                dispose();
            }
            if (role.equals("user")) {
                UserControlRoom userControlRoom = new UserControlRoom();
                dispose();
            }
        }
    }
}
