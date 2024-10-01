import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class RetrieveImageExample {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Database connection details
            String url = "jdbc:mysql://127.0.0.1:3306/account";
            String user = "root";
            String password = "159654";

            // Establish connection to MySQL
            connection = DriverManager.getConnection(url, user, password);

            // SQL query to retrieve the image
            String sql = "SELECT name, image FROM Images WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,4); // Assuming you want to retrieve the image with ID = 1

            // Execute the query
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // Get the image name
                String imageName = rs.getString("name");

                // Read the image as a binary stream
                InputStream inputStream = rs.getBinaryStream("image");

                // Save the image to a file
                File imageFile = new File("retrieved_" + imageName + ".jpg");
                FileOutputStream outputStream = new FileOutputStream(imageFile);

                byte[] buffer = new byte[1024];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                // Display the image in a JFrame
                ImageIcon imageIcon = new ImageIcon(imageFile.getAbsolutePath());
                Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                imageIcon = new ImageIcon(image);

                JFrame frame = new JFrame("Display Image");
                JLabel label = new JLabel(imageIcon);
                frame.getContentPane().add(label, BorderLayout.CENTER);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 400);
                frame.setVisible(true);

                System.out.println("Image retrieved and displayed successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
