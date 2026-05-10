import java.sql.*;

public class InsertStudent {

    public static void main(String[] args) {

        try {

            Class.forName(
                    "com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/college",
                            "root",
                            "root"
                    );

            PreparedStatement ps =
                    con.prepareStatement(
                            "insert into student values(?,?,?)"
                    );

            ps.setInt(1, 4);
            ps.setString(2, "Karan");
            ps.setInt(3, 88);

            int i = ps.executeUpdate();

            if (i > 0) {

                System.out.println(
                        "Record Inserted Successfully");
            }

            con.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}