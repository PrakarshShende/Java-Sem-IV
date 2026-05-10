import java.sql.*;

public class StudentDisplay {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/college",
                        "root",
                        "Root#9876SQL"
                    );
                 Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("select * from student")) {

                while (rs.next()) {
                    System.out.println(
                        rs.getInt(1) + " "
                        + rs.getString(2) + " "
                        + rs.getInt(3)
                    );
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}