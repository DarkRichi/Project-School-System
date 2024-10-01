import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
public class UserControlRoom extends JPanel implements ActionListener{

    private ImageIcon resultIcon = new ImageIcon("C:\\Users\\TUF\\Desktop\\TEST\\src\\image\\resulticon.png");
    private ImageIcon assignmentIcon = new ImageIcon("C:\\Users\\TUF\\Desktop\\TEST\\src\\image\\assignmenticon.png");
    private ImageIcon notificationIcon = new ImageIcon("C:\\Users\\TUF\\Desktop\\TEST\\src\\image\\n" + //
            "otificationicon.png");
    private ImageIcon infoIcon = new ImageIcon("C:\\Users\\TUF\\Desktop\\TEST\\src\\image\\infoicon.png");
    private ImageIcon settingIcon = new ImageIcon("C:\\Users\\TUF\\Desktop\\TEST\\src\\image\\settingicon.png");

    private JLabel GPAmain = new JLabel();
    private JLabel GPAmainNum = new JLabel();
    private JLabel ATTmain = new JLabel();

    public UserControlRoom(){
        setLayout(null);
        setSize(1100,700);
        setBackground(Color.BLACK);

        //create left JPanel
        leftJPanel.setBounds(0, 0, 300, 700);
        leftJPanel.setLayout(null);

        //create a circle Panel to put profile
        circlePanel.setBounds(10,100,100,100);
        circlePanel.setLayout(null);
        circlePanel.setBackground(Color.gray);

        //create menusPanel
        menusPanel.setBounds(30,250,240,350);
        menusPanel.setLayout(null);
        menusPanel.setBorder(new Roundbluepurple(20));
        menusPanel.setOpaque(false);

        //STUDENT_TEXT.set
        Studenttext.setBounds(70, 10, 250, 100);
        Studenttext.setFont(new Font("Fira Code", Font.PLAIN, 30));

        //student id
        IDStudenttext.setText("ID");
        IDStudenttext.setBounds(140, 170, 100, 20);
        IDStudenttext.setFont(new Font("Arial", Font.BOLD, 20));

        //student name
        NameStudenttext.setText("NAME");
        NameStudenttext.setBounds(140, 130, 100, 20);
        NameStudenttext.setFont(new Font("Arial", Font.BOLD, 20));

        //set button
        //result button
        result.setBounds(20,25,200,40);
        result.setText("Result");
        result.setIcon(resultIcon);
        result.addActionListener(this);
        //assignment button
        assignment.setBounds(20,90,200,40);
        assignment.setText("Assignments");
        assignment.setIcon(assignmentIcon);
        assignment.addActionListener(this);
        //Notification button
        notification.setBounds(20,155,200,40);
        notification.setText("Notification");
        notification.setIcon(notificationIcon);
        notification.addActionListener(this);
        //Info button
        info.setBounds(20,220,200,40);
        info.setText("Info");
        info.setIcon(infoIcon);
        info.addActionListener(this);
        //Setting button
        setting.setBounds(20,285,200,40);
        setting.setText("Setting");
        setting.setIcon(settingIcon);
        setting.addActionListener(this);
        //add button to menus
        menusPanel.add(result);
        menusPanel.add(assignment);
        menusPanel.add(notification);
        menusPanel.add(info);
        menusPanel.add(setting);

        //add leftpanel
        leftJPanel.add(circlePanel);
        leftJPanel.add(menusPanel);
        leftJPanel.add(Studenttext);
        leftJPanel.add(IDStudenttext);
        leftJPanel.add(NameStudenttext);
        //----------------------------------------------------------------
        //main Right
        informationPanel_1.setBounds(50,400,200,200);
        informationPanel_1.setLayout(null);
        informationPanel_1.setBorder(new Roundbluepurple(20));
        informationPanel_1.setOpaque(false);

        GPAmain.setText("GPA");
        GPAmain.setBounds(50, 20, 100, 40);
        GPAmain.setFont(new Font("Arial", Font.BOLD, 40));

        GPAmainNum.setText("4.0");
        GPAmainNum.setBounds(65, 90, 100, 40);
        GPAmainNum.setFont(new Font("Arial", Font.BOLD, 40));

        informationPanel_1.add(GPAmain);
        informationPanel_1.add(GPAmainNum);

        mainRight.add(informationPanel_1);
        mainRight.setVisible(true);

        //----------------------------------------------------------------
        //----------------------------------------------------------------
        //result panel component
        year1.setBounds(50,100,700,100);
        year1.setLayout(null);
        year1.setOpaque(false);
        year1.setBorder(new Roundgreenblue(20));

        year2.setBounds(50,230,700,100);
        year2.setLayout(null);
        year2.setOpaque(false);
        year2.setBorder(new Roundgreenblue(20));

        year3.setBounds(50,360,700,100);
        year3.setLayout(null);
        year3.setOpaque(false);
        year3.setBorder(new Roundgreenblue(20));

        year4.setBounds(50,490,700,100);
        year4.setLayout(null);
        year4.setOpaque(false);
        year4.setBorder(new Roundgreenblue(20));

        //assignment panel component
        sub1.setBounds(300,400,300,100);
        sub1.setLayout(null);
        sub1.setOpaque(false);
        sub1.setBorder(new Roundpinkgreen(20));

        //notification panel component
        notic1.setBounds(300,400,300,100);
        notic1.setLayout(null);
        notic1.setOpaque(false);
        notic1.setBorder(new Roundredpink(20));

        //info panel component
        dev1.setBounds(0,400,300,100);
        dev1.setLayout(null);
        dev1.setOpaque(false);
        dev1.setBorder(new Roundaquapurple(100));

        // setting panel component
        set1.setBounds(400,500,300,100);
        set1.setLayout(null);
        set1.setOpaque(false);
        set1.setBorder(new Rounddarkgray(50));

        //----------------------------------------------------------------
        //----------------------------------------------------------------
        // add resultRight Panel;
        resultRight.add(year1);
        resultRight.add(year2);
        resultRight.add(year3);
        resultRight.add(year4);
        resultRight.setVisible(false);
        // add assignmentRight Panel;
        assignmentRight.add(sub1);
        assignmentRight.setVisible(false);
        // add notificationRight Panel
        notificationRight.add(notic1);
        notificationRight.setVisible(false);
        // add infoRight Panel
        infoRight.add(dev1);
        infoRight.setVisible(false);
        // add settingRight Panel
        settingRight.add(set1);
        settingRight.setVisible(false);
        //---------------------------------------------
        //----------------------------------------------------------------

        add(leftJPanel);
        add(mainRight);
        add(resultRight);
        add(assignmentRight);
        add(notificationRight);
        add(infoRight);
        add(settingRight);
    }
    //----------------------------------------------------------------
//----------------------------------------------------------------
//----------------------------------------------------------------
    // LEFT PANEL with neon background
    private JPanel leftJPanel = new JPanel(){
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            Color color1 = new Color(0,255,255);
            Color color2 = new Color(255,0,255);
            GradientPaint neon = new GradientPaint(0,0, color1.darker(), getWidth(),getHeight(), color2.darker(),true);
            g2d.setPaint(neon);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    };
    //----------------------------------------------------------------
    //create Text add to leftJPanel
    private JLabel Studenttext = new JLabel("STUDENT");
    //----------------------------------------------------------------
    //create Name Studenttext
    private JLabel NameStudenttext = new JLabel();
    //----------------------------------------------------------------
    //create ID Studenttext
    private JLabel IDStudenttext = new JLabel();
    //----------------------------------------------------------------
    // create circle panel import to leftJPanel
    private JPanel circlePanel = new JPanel(){
        public void paintComponent(Graphics g){
            super.paintComponents(g);
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();
            int diameter = Math.min(width, height);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // set Color of profile
            g2d.setColor(getBackground());
            g2d.fillOval((width - diameter) / 2, (height - diameter) / 2, diameter, diameter);
        }
    };
    //----------------------------------------------------------------
    // create menus panel import to leftJPanel
    private JPanel menusPanel = new JPanel(){};
    //----------------------------------------------------------------
    // create button class and create object import to menus panel
    private buttons result = new buttons();
    private buttons assignment = new buttons();
    private buttons notification = new buttons();
    private buttons info = new buttons();
    private buttons setting = new buttons();
    // create class
    private class buttons extends JButton implements MouseListener{
        private buttons(){
            this.setBounds(getX(),getY(),getWidth(),getHeight());
            this.setFocusable(false);
            this.setFont(new Font("Arial", Font.BOLD,18));
            this.setText(getText());
            this.setIconTextGap(20);
            this.setOpaque(false);
            this.setVerticalAlignment(JButton.CENTER);
            this.setHorizontalAlignment(JButton.LEFT);
            this.setHorizontalTextPosition(JButton.RIGHT);
            this.setVerticalTextPosition(JButton.BOTTOM);
            this.setBorder(BorderFactory.createEmptyBorder(5,10,5,5));
            this.setContentAreaFilled(false);
            this.addMouseListener(this);
            radius = 20;
        }
        protected void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //create​ color
            GradientPaint neon = new GradientPaint(0,0,color1,getWidth(),getHeight(),color2.darker(),true);
            //create button color
            if (over == true) {
                g2d.setPaint(neon);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            }
            //create border
            else{
                g2d.drawRoundRect(0,0,getWidth()-2,getHeight()-2,radius,radius);
            }
            super.paintComponent(g);
        }
        public Color color1=Color.white;
        public Color color2=Color.gray;
        public int radius = 20;
        public boolean over;
        @Override
        public void mouseClicked(MouseEvent e) {}
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {
            this.setBorder(BorderFactory.createEmptyBorder(5,20,5,5));
            //if u want 2color
            //color = Color(255,0,255);
            this.over = true;
        }
        @Override
        public void mouseExited(MouseEvent e) {
            this.setBorder(BorderFactory.createEmptyBorder(5,10,5,5));
            this.over = false;
        }
    }
    //----------------------------------------------------------------
//----------------------------------------------------------------
//----------------------------------------------------------------
//----------------------------------------------------------------
//----------------------------------------------------------------
    // create round border class with different color
    // create blue purple
    private class Roundbluepurple implements Border{
        private int radius;
        public Roundbluepurple(int radius) {
            this.radius = radius;
        }
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Shape shape = new RoundRectangle2D.Double(x, y, width - 1, height - 1, radius * 2, radius * 2);
            Color color1 = new Color(0,255,255);
            Color color2 = new Color(255,0,255);
            GradientPaint neon = new GradientPaint(500, 1300, color1.brighter(), getWidth(), getHeight(), color2.brighter(),true);
            g2d.setPaint(neon);
            g2d.fill(shape);
            g2d.dispose();
        }
        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(radius, radius, radius, radius);
        }
        @Override
        public boolean isBorderOpaque() {
            return false;
        }
    }
    //----------------------------------------------------------------
    // create green blue
    private class Roundgreenblue implements Border{
        private int radius;
        public Roundgreenblue(int radius) {
            this.radius = radius;
        }
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Shape shape = new RoundRectangle2D.Double(x, y, width - 1, height - 1, radius * 2, radius * 2);
            Color color1 = new Color(0,255,0);
            Color color2 = new Color(0,0,255);
            GradientPaint neon = new GradientPaint(500, 1200, color1.brighter(), getWidth(), getHeight(), color2.brighter(),true);
            g2d.setPaint(neon);
            g2d.fill(shape);
            g2d.dispose();
        }
        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(radius, radius, radius, radius);
        }
        @Override
        public boolean isBorderOpaque() {
            return false;
        }
    }
    //----------------------------------------------------------------
    // create pink green
    private class Roundpinkgreen implements Border{
        private int radius;
        public Roundpinkgreen(int radius) {
            this.radius = radius;
        }
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Shape shape = new RoundRectangle2D.Double(x, y, width - 1, height - 1, radius * 2, radius * 2);
            Color color1 = new Color(255,0,255);
            Color color2 = new Color(0,255,0);
            GradientPaint neon = new GradientPaint(-700, 700, color1.brighter(), getWidth(), getHeight(), color2.brighter(),true);
            g2d.setPaint(neon);
            g2d.fill(shape);
            g2d.dispose();
        }
        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(radius, radius, radius, radius);
        }
        @Override
        public boolean isBorderOpaque() {
            return false;
        }
    }
    //----------------------------------------------------------------
    // create aqua purple
    private class Roundaquapurple implements Border{
        private int radius;
        public Roundaquapurple(int radius) {
            this.radius = radius;
        }
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Shape shape = new RoundRectangle2D.Double(x, y, width - 1, height - 1, radius * 2, radius * 2);
            Color color1 = new Color(0x00FFFF);
            Color color2 = new Color(0xFF00FF);
            GradientPaint neon = new GradientPaint(0, 0, color1.darker(), getWidth(), getHeight(), color2.darker(),true);
            g2d.setPaint(neon);             //30,250,240,350
            g2d.fill(shape);
            g2d.dispose();
        }
        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(radius, radius, radius, radius);
        }
        @Override
        public boolean isBorderOpaque() {
            return false;
        }
    }
    //----------------------------------------------------------------
    // create red pink
    private class Roundredpink implements Border{
        private int radius;
        public Roundredpink(int radius) {
            this.radius = radius;
        }
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Shape shape = new RoundRectangle2D.Double(x, y, width - 1, height - 1, radius * 2, radius * 2);
            Color color1 = new Color(0xFF5252);
            Color color2 = new Color(0xFF99CC);
            GradientPaint neon = new GradientPaint(25, 1100, color1.darker(), getWidth(), getHeight(), color2.brighter(),true);
            g2d.setPaint(neon);
            g2d.fill(shape);
            g2d.dispose();
        }
        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(radius, radius, radius, radius);
        }
        @Override
        public boolean isBorderOpaque() {
            return false;
        }
    }
    //----------------------------------------------------------------
    // create dark gray
    private class Rounddarkgray implements Border{
        private int radius;
        public Rounddarkgray(int radius) {
            this.radius = radius;
        }
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Shape shape = new RoundRectangle2D.Double(x, y, width - 1, height - 1, radius * 2, radius * 2);
            Color color1 = new Color(0xD8BABA);
            Color color2 = new Color(0xFFFFFF);
            GradientPaint neon = new GradientPaint(0, 0, color1.darker(), getWidth(), getHeight(), color2.brighter(),true);
            g2d.setPaint(neon);
            g2d.fill(shape);
            g2d.dispose();
        }
        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(radius, radius, radius, radius);
        }
        @Override
        public boolean isBorderOpaque() {
            return false;
        }
    }
    //----------------------------------------------------------------
//----------------------------------------------------------------
//----------------------------------------------------------------
//----------------------------------------------------------------
//----------------------------------------------------------------
    //create Right panel class to store same background color
    private class RightPanel extends JPanel{
        public RightPanel(){
            this.setBounds(300,0,800,700);
            this.setLayout(null);
        }
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            Color color1 = new Color(0, 242, 250);
            Color color2 = new Color(2, 169, 224);
            GradientPaint neon = new GradientPaint(0,700, color1.brighter(),getWidth(),getHeight(),color2,true);
            g2d.setPaint(neon);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }
    //----------------------------------------------------------------
//----------------------------------------------------------------
//----------------------------------------------------------------
    //create mainRightPanel for information
    private RightPanel mainRight = new RightPanel();
    // componet in mainRight panel
    private JPanel informationPanel_1 = new JPanel();
    //----------------------------------------------------------------
    //create resultRightPanel for result button
    private RightPanel resultRight = new RightPanel();
    // component in resultRight panel
    private JPanel year1 = new JPanel();
    private JPanel year2 = new JPanel();
    private JPanel year3 = new JPanel();
    private JPanel year4 = new JPanel();
    //----------------------------------------------------------------
    //create assignmentRightPanel for assignment button
    private RightPanel assignmentRight = new RightPanel();
    // component in assignmentRight panel
    private JPanel sub1 = new JPanel();
    //----------------------------------------------------------------
    //create notificationRightPanel for assignment button
    private RightPanel notificationRight = new RightPanel();
    // component in assignmentRight panel
    private JPanel notic1 = new JPanel();
    //----------------------------------------------------------------
    //create infoRightPanel for assignment button
    private RightPanel infoRight = new RightPanel();
    // component in assignmentRight panel
    private JPanel dev1 = new JPanel();
    //----------------------------------------------------------------
    //create settingRightPanel for assignment button
    private RightPanel settingRight = new RightPanel();
    // component in assignmentRight panel
    private JPanel set1 = new JPanel();
    //----------------------------------------------------------------
//----------------------------------------------------------------
//----------------------------------------------------------------
//----------------------------------------------------------------
//----------------------------------------------------------------
//----------------------------------------------------------------
    // ActionListener for button
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == result){
            resultRight.setVisible(true);
            mainRight.setVisible(false);
            assignmentRight.setVisible(false);
            notificationRight.setVisible(false);
            infoRight.setVisible(false);
            settingRight.setVisible(false);
        }
        if (e.getSource() == assignment){
            assignmentRight.setVisible(true);
            mainRight.setVisible(false);
            resultRight.setVisible(false);
            notificationRight.setVisible(false);
            infoRight.setVisible(false);
            settingRight.setVisible(false);
        }
        if(e.getSource() == notification){
            mainRight.setVisible(false);
            resultRight.setVisible(false);
            assignmentRight.setVisible(false);
            notificationRight.setVisible(true);
            infoRight.setVisible(false);
            settingRight.setVisible(false);
        }
        if(e.getSource() == info){
            mainRight.setVisible(false);
            resultRight.setVisible(false);
            assignmentRight.setVisible(false);
            notificationRight.setVisible(false);
            infoRight.setVisible(true);
            settingRight.setVisible(false);
        }
        if(e.getSource() == setting){
            mainRight.setVisible(false);
            resultRight.setVisible(false);
            assignmentRight.setVisible(false);
            notificationRight.setVisible(false);
            infoRight.setVisible(false);
            settingRight.setVisible(true);
        }
    }
}
