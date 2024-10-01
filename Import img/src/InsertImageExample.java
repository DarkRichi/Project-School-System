import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class InsertImageExample {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            // Database connection details
            String url = "jdbc:mysql://127.0.0.1:3306/account";
            String user = "root";
            String password = "159654";

            // Establish connection to MySQL
            connection = DriverManager.getConnection(url, user, password);

            // SQL query to insert data
            String sql = "INSERT INTO Images (name, image) VALUES (?, ?)";
            pstmt = connection.prepareStatement(sql);

            // Set image name
            pstmt.setString(1, "Example Image");

            // Read the image file
            File imageFile = new File("C:\\Users\\Chetr\\OneDrive\\Pictures\\photo_2024-08-31_20-16-39.jpg");
            FileInputStream fis = new FileInputStream(imageFile);
            pstmt.setBinaryStream(2, fis, (int) imageFile.length());

            // Execute the statement
            int rowAffected = pstmt.executeUpdate();
            if (rowAffected > 0) {
                System.out.println("Image inserted successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
