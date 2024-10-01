import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;

public class DB {
    public String[] Userlogin(String id, String pw) {
        String[] result = new String[3]; // Array to store role and name
        String query = "SELECT * FROM accounts WHERE ID = ? AND password = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/account", "root", "159654");
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, id);
            pst.setString(2, pw);
            ResultSet rst = pst.executeQuery();


            if (rst.next()) {
                result[0] = rst.getString(4); // role
                result[1] = rst.getString(2); // name
                result[2] = rst.getString(5); // data_image
                System.out.println("Name: " + result[1]);
                InputStream inputStream = rst.getBinaryStream(5);

                // Save the image to a file
                File imageFile = new File("retrieved_" + result[1] + ".jpg");
                FileOutputStream outputStream = new FileOutputStream(imageFile);

                byte[] buffer = new byte[1024];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
