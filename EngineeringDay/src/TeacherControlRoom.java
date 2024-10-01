import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;

public class TeacherControlRoom extends JFrame implements ActionListener{
    JLayeredPane LayeredPane;
    JLabel Welcome,Username;
    JPanel menu,ClassroomPanel,ProfilePanel;
    JButton ClassroomButton,AssignmentButton,NotificationButton,InfoButton,SettingButton;

    public TeacherControlRoom(String id,String pw){
    // Database Structure
        DB db = new DB();
        String[] loginInfo = db.Userlogin(id, pw);
        String name = loginInfo[1];
        String img = loginInfo[2];
        // KeyControl

        KeyStroke escapeKey = KeyStroke.getKeyStroke("ESCAPE");
        Action escape = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        // --------------------------------------------------------------------------------------------------------

        // Button
        ClassroomButton = new JButton("Classroom");
        ClassroomButton.setFont(new Font(null, Font.BOLD, 18));
        ClassroomButton.setBounds(30, 30, 180, 50);
        ClassroomButton.setHorizontalAlignment(SwingConstants.CENTER);
        ClassroomButton.setBorder(new ButtonBorder(30));
        ClassroomButton.setOpaque(false);
        ClassroomButton.setContentAreaFilled(false);
        ClassroomButton.addActionListener(this);
        ClassroomButton.setFocusPainted(false);

        AssignmentButton = new JButton();
        AssignmentButton.setText("Assignment");
        AssignmentButton.setFont(new Font(null, Font.BOLD, 18));
        AssignmentButton.setBounds(30,80,180,50);
        AssignmentButton.setHorizontalAlignment(SwingConstants.CENTER);
        AssignmentButton.setBorder(new ButtonBorder(30));
        AssignmentButton.setOpaque(false);
        AssignmentButton.setContentAreaFilled(false);

        NotificationButton = new JButton();
        NotificationButton.setText("Notification");
        NotificationButton.setFont(new Font(null, Font.BOLD, 18));
        NotificationButton.setBounds(30,130,180,50);
        NotificationButton.setHorizontalAlignment(SwingConstants.CENTER);
        NotificationButton.setBorder(new ButtonBorder(30));
        NotificationButton.setOpaque(false);
        NotificationButton.setContentAreaFilled(false);

        InfoButton = new JButton();
        InfoButton.setText("Info");
        InfoButton.setFont(new Font(null, Font.BOLD, 18));
        InfoButton.setBounds(30,180,180,50);
        InfoButton.setHorizontalAlignment(SwingConstants.CENTER);
        InfoButton.setBorder(new ButtonBorder(30));
        InfoButton.setOpaque(false);
        InfoButton.setContentAreaFilled(false);

        SettingButton = new JButton();
        SettingButton.setText("Setting");
        SettingButton.setFont(new Font(null, Font.BOLD, 18));
        SettingButton.setBounds(30,230,180,50);
        SettingButton.setHorizontalAlignment(SwingConstants.CENTER);
        SettingButton.setBorder(new ButtonBorder(30));
        SettingButton.setOpaque(false);
        SettingButton.setContentAreaFilled(false);

        // Panel
        ClassroomPanel = new JPanel();
        ClassroomPanel.setBackground(Color.LIGHT_GRAY);
        ClassroomPanel.setBounds(300,0,800,700);
        ClassroomPanel.setLayout(null);
        // Items
        Welcome = new JLabel();
        Welcome.setText("Welcome");
        Welcome.setFont(new Font(null, Font.ROMAN_BASELINE, 25));
        Welcome.setBounds(0, 0, 300, 50);
        Welcome.setHorizontalAlignment(SwingConstants.CENTER);

        Username = new JLabel();
        Username.setText("Name :" +name);
        Username.setBounds(130,100,110,40);
        Username.setFont(new Font("Inika",Font.TYPE1_FONT,15));

        ProfilePanel = new JPanel();;
        ProfilePanel.setBounds(20,80,100,100);


        // Menu
        menu = new JPanel();
        menu.setBounds(30,220,240,450);
        menu.setBorder(new MenuBorder(30));
        menu.setLayout(null);
        menu.setOpaque(false);
        // Add
        menu.add(ClassroomButton);
        menu.add(AssignmentButton);
        menu.add(NotificationButton);
        menu.add(InfoButton);
        menu.add(SettingButton);

        // Left Panel
        LPanel.setBounds(0,0,300,700);
        LPanel.setLayout(null);
        // Add
        LPanel.add(menu);
        LPanel.add(ProfilePanel);
        LPanel.add(Welcome);
        LPanel.add(Username);

        // Right Panel
        Rpanel.setBounds(300,0,800,700);
        Rpanel.setLayout(null);
        // Add

        // LayeredPanel
        LayeredPane = new JLayeredPane();
        LayeredPane.setBounds(0,0,1100,700);
        // Add panel
        LayeredPane.add(LPanel);
        LayeredPane.add(Rpanel);

        // --------------------------------------------------------------------------------------------------------

        // Frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Teacher");
        this.setSize(1100,700);
        this.getRootPane().getInputMap().put(escapeKey,"ESCAPE");
        this.getRootPane().getActionMap().put("ESCAPE",escape);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        // Add LayeredPanel
        this.add(LayeredPane);
        this.setVisible(true);


    }
// --------------------------------------------------------------------------------------------------------

    // Graphic
    private JPanel LPanel = new JPanel(){
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            Color color1 = new Color(0x3494E6);
            Color color2 = new Color(0xEC6EAD);
            GradientPaint neon = new GradientPaint(0,0, color1.brighter(), getWidth(),getHeight(), color2.brighter(),true);
            g2d.setPaint(neon);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    };

    private JPanel Rpanel = new JPanel(){
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            Color color2 = new Color(0x99d98c);
            Color color1 = new Color(0x76c893);
            GradientPaint neon = new GradientPaint(0,0, color1.brighter(), getWidth(),getHeight(), color2.darker(),true);
            g2d.setPaint(neon);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    };

    private class MenuBorder implements Border{
        private int arc;
        public MenuBorder(int arc) {
            this.arc = arc;
        }


        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Shape shape = new RoundRectangle2D.Double(x, y, width - 1, height - 1, arc * 2, arc * 2);
            Color color1 = new Color(0,255,255);
            Color color2 = new Color(255,0,255);
            GradientPaint neon = new GradientPaint(500, 1300, color1.brighter(), getWidth(), getHeight(), color2.brighter(),true);
            g2d.setPaint(neon);
            g2d.fill(shape);
            g2d.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(arc,arc,arc,arc);
        }

        @Override
        public boolean isBorderOpaque() {
            return false;
        }
    };


    // Button
    private class ButtonBorder implements Border{
        private int arc;
        public ButtonBorder(int arc) {
            this.arc = arc;
        }
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Shape shape = new RoundRectangle2D.Double(x, y, width - 1, height - 1, arc * 2, arc * 2);
            Color color1 = new Color(0x0096c7);
            Color color2 = new Color(0x00b4d8);
            GradientPaint neon = new GradientPaint(500, 1300, color1.brighter(), getWidth(), getHeight(), color2.brighter(),true);
            g2d.setPaint(neon);
            g2d.draw(shape);
            g2d.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(arc,arc,arc,arc);
        }

        @Override
        public boolean isBorderOpaque() {
            return false;
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ClassroomButton) {
            Rpanel.setVisible(false);
            ClassroomPanel.setVisible(true);
        }else {
            Rpanel.setVisible(true);
            ClassroomPanel.setVisible(false);
        }


    }
}
